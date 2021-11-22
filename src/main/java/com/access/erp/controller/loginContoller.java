package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.service.CompanyService;
import com.access.erp.service.FinancialActiveYearService;

@Controller
public class loginContoller {

	/*
	 * @GetMapping("/") public String loginPage(Model model) { return "login"; }
	 */

	@Autowired
	FinancialActiveYearService financialActiveyearService;
	@Autowired
	CompanyService companyService;
	

	@GetMapping("/verify")
	public String indexPage(Model model) {


		List<Company> listCompany = companyService.getAllCompany();
		model.addAttribute("listCompany", listCompany);
		
		return "layouts/loginPopup";
	}

	@PostMapping("/index")
	public String loginPopupPage(Model model) {

		return "layouts/index";
	}
	
	
	@ResponseBody
	@GetMapping("/activefy/{id}")
	public List<FinancialActiveYear> getStateCountryById(@PathVariable(value = "id") String compCode) {
		
		Company company = companyService.editCompany(compCode);
		
		System.out.println("Company code Is : " + company.getCompCode());
		List<FinancialActiveYear> fy =  financialActiveyearService.findByCompany(company);
		System.out.println("fy size : " + fy.size());
		return fy;
		
		//return null;
	}

}
