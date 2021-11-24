package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/issuslip")
public class IssueSlipController {

	@GetMapping("/")
	public String issueSlip(Model model) {
		
		return "layouts/Master/issueSlip";
	}
	
}
