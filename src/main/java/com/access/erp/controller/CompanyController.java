package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.access.erp.model.master.Company;

@Controller
public class CompanyController {
	
	
	@GetMapping("companydetail")
	public String companyDetail(Model model) {
		
		model.addAttribute("company", new Company());
		return "layouts/Master/companyDetail";
	}

}
