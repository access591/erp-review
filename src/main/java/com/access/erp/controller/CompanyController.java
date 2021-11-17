package com.access.erp.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.master.City;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.State;
import com.access.erp.repo.CompanyRepo;
import com.access.erp.service.CityService;
import com.access.erp.service.CompanyService;
import com.access.erp.service.StateService;

@Controller
@RequestMapping("/companydetail")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	StateService stateService;

	@Autowired
	CityService cityService;

	@GetMapping("/")
	public String companyDetail(Model model, Principal principal) {

		System.out.println("principal : " + principal.getName());
		model.addAttribute("company", new Company());

		List<State> listState = stateService.getAllState();
		model.addAttribute("listState", listState);

		return "layouts/Master/companyDetail";
	}

	@PostMapping("/")
	public String addCompany(@ModelAttribute("company") Company company, RedirectAttributes redirectAttributes) {

		System.out.println("city code 1: " + company.getcCity().getCityCode());
		System.out.println("city code 2: " + company.getrCity().getCityCode());

		boolean exists = companyRepo.existsById(company.getCompCode());
		if (!exists) {
			
			companyService.addCompany(company);
			redirectAttributes.addFlashAttribute("message", "Company  has been saved successfully! ");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			
		} else {

			redirectAttributes.addFlashAttribute("message", "Company Code Allready exists! Please try another One !!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		}

		return "redirect:/companydetail/";
	}

	@GetMapping("/list")
	public String viewCompanyList(Model model) {

		List<Company> listCompany = companyService.getAllCompany();

		if (listCompany != null) {
			model.addAttribute("listCompany", listCompany);
		}
		return "layouts/listview/listofCompany";
	}

	@GetMapping("/edit/{id}")
	public String editCompany(@PathVariable("id") String compCode, Model model) {

		System.out.println("company code is : " + compCode);

		List<State> listState = stateService.getAllState();
		model.addAttribute("listState", listState);
		
		List<City> listCity = cityService.getAllCity();
		model.addAttribute("listCity", listCity);

		Company company = companyService.editCompany(compCode);
		model.addAttribute("company", company);

		System.out.println("company child info : " + company.getInsuranceDetail().get(0).getCustCode());
		return "layouts/editview/editCompany";
	}

	@GetMapping("/delete/{id}")
	public String deleteCompany(@PathVariable("id") String compCode, Model model) {
		companyService.deleteCompany(compCode);
		return "redirect:/companydetail/list";
	}

	@ResponseBody
	@GetMapping("/citylist/{id}")
	public List<City> getCityListByStateId(@PathVariable(value = "id") String id, Model model) {

		System.out.println("get city list by State code ");

		State state = new State();
		state.setStateCode(id);
		List<City> listCity = cityService.findByState(state);

		return listCity;

	}
}
