package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RejectionIssueController {

	@GetMapping("/rejectionissue")
	public String addRejectionIssue(Model model) {
		
		
		return"layouts/Master/rejectionIssue";
	}
	
	
	
	
}
