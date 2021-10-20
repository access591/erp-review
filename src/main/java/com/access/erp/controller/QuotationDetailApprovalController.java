package com.access.erp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.QuotationDetail;
import com.access.erp.repo.QuotationDetailRepo;
import com.access.erp.service.QuotationDetailService;

@Controller
@RequestMapping("approvalquotationdetail")
public class QuotationDetailApprovalController {
	
	@Autowired QuotationDetailRepo quotationDetailRepo;
	@Autowired QuotationDetailService quotationDetailService;
	
	
	@GetMapping("/")
	public String quotationApprovalPage(Model model) {
		
		List<QuotationDetail> listQuotationDetail = quotationDetailRepo.findAll();
		
		for(QuotationDetail detail : listQuotationDetail) {
			
			System.out.println("detail is : " +detail.getApprovalStatus1());
		}
		
		model.addAttribute("listQuotationDetail", listQuotationDetail);
		
		return "layouts/Master/quotationApproval";
	}
	
	
	@GetMapping("/{quotNum}/{status}")
	public String quotationApproval(@PathVariable("quotNum") String quotNum,@PathVariable("status") String status) {
		
		System.out.println("quot num is : " + quotNum);
		System.out.println("status value is : " + status);
		
		quotationDetailService.approvalForQuotationDetail(quotNum, status);
		
		return "redirect:/approvalquotationdetail/";
	}
	
	
	//pending work 
	@GetMapping("/view/{quotNum}/")
	public String viewQuotationDetail(@PathVariable("quotNum") String quotNum,Model model,
			@ModelAttribute("quotation")Optional<QuotationDetail> quotaion) {
		
		System.out.println("quot num is : " + quotNum);
		quotaion =  quotationDetailService.editQuotationDetail(quotNum);
		
		
		quotaion.ifPresent(q -> model.addAttribute("quotaion", q));
		
		
		
		
		return "layouts/view/viewQuotationDetail";
	}
	
	
	
	
	@GetMapping("/quotationapprovallist")
	public String quotationApprovalList() {
		
		return "layouts/Master/quotationApprovalList";
	}

}
