package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.QuotationDetail;
import com.access.erp.repo.QuotationDetailRepo;

@Controller
@RequestMapping("approvalquotationdetail")
public class QuotationDetailApprovalController {
	
	@Autowired QuotationDetailRepo quotationDetailRepo;
	
	
	@GetMapping("/")
	public String quotationApprovalPage(Model model) {
		
		List<QuotationDetail> listQuotationDetail = quotationDetailRepo.findAll();
		model.addAttribute("listQuotationDetail", listQuotationDetail);
		
		return "layouts/Master/quotationApproval";
	}
	
	
	@GetMapping("/{quotNum}/{status}")
	public String quotationApproval(@PathVariable("quotNum") String quotNum,@PathVariable("status") String status) {
		
		System.out.println("quot num is : " + quotNum);
		System.out.println("status value is : " + status);
		
		
		return "redirect:/approvalquotationdetail";
	}
	
	
	
	
	@GetMapping("/quotationapprovallist")
	public String quotationApprovalList() {
		
		return "layouts/Master/quotationApprovalList";
	}

}
