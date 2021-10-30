package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.PurchaseOrder;
import com.access.erp.service.PurchaseOrderService;

@Controller
@RequestMapping("poapproval")
public class PoApprovalController {
	
	@Autowired PurchaseOrderService purchaseOrderService;
	
	@GetMapping("/")
	public String poApprovalPage(Model model) {
		
		List<PurchaseOrder> listPurchaseOrder = purchaseOrderService.getAllPurchaseOrder();
		model.addAttribute("listPurchaseOrder", listPurchaseOrder);
		
		
		return "layouts/Master/purchaseOrderApproval";
	}
	
	
	@GetMapping("/approve/{id}/{status}")
	public String poApproval(@PathVariable("id") String poNumber,@PathVariable("status") String approvalStatus) {
		
		
		
		System.out.println("Po Number Is : " + poNumber);
		System.out.println(" status : " + approvalStatus);
		purchaseOrderService.purchaseOrderApproval(poNumber, approvalStatus);
		
		return "redirect:/poapproval/";
	}
	
	
	

}
