package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/purchasereturn")
public class PurchaseReturnController {

	
	
	@GetMapping("/")
	public String purchaseReturnPage(Model model) {
		
		//model.addAttribute("purchaseReturn", new PurchaseReturn());
		return"layouts/Master/purchaseReturn";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
