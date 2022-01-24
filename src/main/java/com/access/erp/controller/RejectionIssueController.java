package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		System.out.println("testing :" + rejectionIssue.getReqDate()  );
		System.out.println("rate :" + rejectionIssue.getListRejectionIssueDetail().get(0).getIssrate());
		rejectionIssueService.addRejectionIssue(rejectionIssue);
		
		return"redirect:/rejectionissue/";
	}
	
	
	
	@GetMapping("/list")
	public String RejectionIssueList(Model model) {
		
		List<RejectionIssue> ListRejectionIssue = rejectionIssueService.getAllRejectionIssue();
		if(ListRejectionIssue != null) {
			model.addAttribute("RejectionIssueList",ListRejectionIssue);
		}
				
				
		return"layouts/listview/listofRejectionIssue";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editRejectionIssue(@PathVariable("id") String IssueNo,Model model) {
	
		RejectionIssue rejectionIssue= rejectionIssueService.editRejectionIssue(IssueNo).get();
		model.addAttribute("RejectionIsssue",rejectionIssue);
	
		
	return"layouts/editview/editRejectionIssue";
	}

	@GetMapping("/delete/{id}")
	public String deleteRejectionIssue(@PathVariable("id") String IssueNo ,Model model,RedirectAttributes redirectAttributes) {
		rejectionIssueService.deleteRejectionIssue(IssueNo);
		
		 redirectAttributes.addFlashAttribute("message","RejectionIssue  has been deleted successfully!");
		  redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		  
		
		  return "redirect:/rejectionissue/list"; 
	}
}
	
	
