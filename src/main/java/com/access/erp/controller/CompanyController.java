package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
	
	
	@GetMapping("companydetail")
	public String companyDetail(Model model) {
		
		return "layouts/Master/companyDetail";
	}

}
