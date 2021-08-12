package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginContoller {
	
	@GetMapping("/")
	public String loginPage(Model model) {
		return "login";
	}
	
	
	@GetMapping("/index")
	public String indexPage(Model model) {
		return "index";
	}
	
	@GetMapping("/navbar")
	public String navbarPAge(Model model) {
		return "fragments/navbar";
	}
	
	@GetMapping("/sidebar")
	public String sidebarPage(Model model) {
		return "fragments/sidebar";
	}
	
	
	@GetMapping("/navbar1")
	public String navbarPAge1(Model model) {
		return "fragments/navbar1";
	}
	
	@GetMapping("/sidebar1")
	public String sidebarPage1(Model model) {
		return "fragments/sidebar1";
	}
	
	

}
