package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quotationapproval")
public class QuotationApproval {
	
	@GetMapping("/")
	public String quotationApproval() {
		
		
		return "layouts/Master/quotationApproval";
	}
	
	
	@GetMapping("/quotationapprovallist")
	public String quotationApprovalList() {
		
		return "layouts/Master/quotationApprovalList";
	}

}
