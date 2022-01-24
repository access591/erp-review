package com.access.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.service.RejectionIssueService;
import  com.access.erp.model.RejectionIssue;

@Controller
@RequestMapping("/rejectionissue")
public class RejectionIssueController {

	@Autowired RejectionIssueService rejectionIssueService;
	
	
	@GetMapping("/")
	public String RejectionIssue(Model model) {
		
		model.addAttribute("RejectionIsssue",new RejectionIssue() );
		
		return"layouts/Master/rejectionIssue";
	}
	
	
	@PostMapping("/")
	public String addRejectionIssue(@ModelAttribute("RejectionIssue")RejectionIssue rejectionIssue) {
		
		System.out.println();
		
		rejectionIssueService.addRejectionIssue(rejectionIssue);
		
		return"redirect:/rejectionissue/";
	}
	
	
	
	@GetMapping("/list")
	public String RejectionIssueList(Model model) {
		
		
		
		return"";
	}
	
	
	
}
