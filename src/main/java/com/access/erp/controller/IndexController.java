package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


	@GetMapping("/login")
	public String loginPage(Model model) {
		
		System.out.println("welcome");
		return "layouts/login";
	}
	
	
}
