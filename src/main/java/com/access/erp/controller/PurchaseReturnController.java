package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.PurchaseReturn;
import com.access.erp.service.PurchaseReturnService;



@Controller
@RequestMapping("/purchasereturn")
public class PurchaseReturnController {

	@Autowired PurchaseReturnService purchasereturnService;
	
	@GetMapping("/")
	public String purchaseReturnPage(Model model) {
		
		model.addAttribute("purchaseReturn", new PurchaseReturn());
		return"layouts/Master/purchaseReturn";
		
	}
	
	@PostMapping("/")
	public String addPurchaseReturn(@ModelAttribute("purchaseReturn") PurchaseReturn purchaseReturn,RedirectAttributes redirectAttributes ) {
		
		purchasereturnService.addPurchaseReturn(purchaseReturn);
		return"redirect:/purchasereturn";
		
	}
	
	@GetMapping("/list")
	public String purchaseReturnList(Model model) {
		
		
		List<PurchaseReturn>purchaseReturnList=purchasereturnService.getAllPurchaseReturn();
		if (purchaseReturnList != null) {
			model.addAttribute("purchaseReturnList", purchaseReturnList);
		}
		return "layouts/listview/listofPurchaseReturn";
	}
	
	
	
	
	
	
	
	
	
	
}
