package com.access.erp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.repo.FinnancialActiveYearRepo;
import com.access.erp.service.CompanyService;
import com.access.erp.service.FinancialActiveYearService;
import com.access.erp.service.FinancialYearService;
import com.access.erp.service.MyUserService;
import com.access.erp.singleton.GlobalParameter;
import com.access.erp.singleton.SingletonDummy;

@Controller
public class loginContoller {

	/*
	 * @GetMapping("/") public String loginPage(Model model) { return "login"; }
	 */

	@Autowired
	FinancialActiveYearService financialActiveyearService;
	@Autowired
	CompanyService companyService;
	@Autowired
	MyUserService myUserService;
	@Autowired
	FinnancialActiveYearRepo finnancialActiveYearRepo;
	@Autowired
	FinancialYearService financialYearService;
	@Autowired GlobalParameter globalParameter;

	@GetMapping("/verify")
	public String indexPage(Model model,Principal principal) {

		System.out.println("###################### Verify Page #####################");
		
		
		System.out.println("principal : " + principal.getName());
		
		MyUser myUser = myUserService.editMyUser(principal.getName()).get();
		
		List<FinancialActiveYear> fyYearList =  finnancialActiveYearRepo.findByMyUser(myUser);
		
		
		List<Company> companyList = new ArrayList<>();
		for(FinancialActiveYear fy : fyYearList) {
			
			if(!companyList.contains(fy.getCompany())) {
				companyList.add(fy.getCompany());
			}
			
		}
		
		
		model.addAttribute("companyList", companyList);

		model.addAttribute("login", new FinancialActiveYear());

		return "layouts/loginPopup";
	}

	
	
	@PostMapping("/index")
	public String loginPopupPage(Model model, @ModelAttribute("") FinancialActiveYear financialActiveYear,
			Principal principal) {

		//store current financial year 
		String activeUser = principal.getName();

		System.out.println("company is : " + financialActiveYear.getCompany().getCompCode());

		System.out.println("fy year is : " + financialActiveYear.getFinancialYear().getFinancialYearCode());
		System.out.println("active user  : " + activeUser);

		Company aCompany = companyService.editCompany(financialActiveYear.getCompany().getCompCode());
		
		FinancialYear aFy = financialYearService
				.editFinancialYear(financialActiveYear.getFinancialYear().getFinancialYearCode()).get();
		
		MyUser aUser = myUserService.editMyUser(activeUser).get();

		boolean isExist = finnancialActiveYearRepo.existsByFinancialYearAndMyUserAndCompany(aFy, aUser, aCompany);

		System.out.println("isExist or Not :" + isExist);
		
		if(isExist) {
			globalParameter.setGlobaluser(aUser.getUserCode());
			globalParameter.setGlobalCompany(aCompany.getCompCode());
			globalParameter.setGlobalFinanceYear(aFy.getFinancialYearCode());
			
			globalParameter.setCompany(aCompany);
			globalParameter.setMyUser(aUser);
			globalParameter.setFyYear(aFy);
			
			
			//AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
			return "layouts/index";
		}else {
			return "layouts/login";
		}

		
		
	}
	
	
	@GetMapping("/home")
	public String homePage(Model model,Principal principal) {

		if(principal.getName()==null) {
			return "layouts/login";
		}
		else {
			return "layouts/index";
		}

		
	}

	@ResponseBody
	@GetMapping("/activefy/{id}")
	public List<FinancialActiveYear> getStateCountryById(@PathVariable(value = "id") String compCode,Principal principal) {

		Company company = companyService.editCompany(compCode);

		System.out.println("Company code Is : " + company.getCompCode());
		
		MyUser myUser = myUserService.editMyUser(principal.getName()).get();
		
		
		List<FinancialActiveYear> fy = finnancialActiveYearRepo.findByCompanyAndMyUser(company,myUser);
		System.out.println("fy size : " + fy.size());
		return fy;

		
	}

}
