package com.access.erp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.QuotationDetail;
import com.access.erp.service.QuotationDetailService;

@Controller
@RequestMapping("/quotationdetail")
public class QuotationDetailController {

	@Autowired QuotationDetailService quotationService;
	
	@GetMapping("/")
	public String quotationDetail(Model model) {
		
		model.addAttribute("quotation", new QuotationDetail());
		return "layouts/Master/quotationDetail";
	}
	
	@PostMapping("/")
	public String addQuotationDetail(@ModelAttribute("quotation") QuotationDetail quotation) {
		
		quotationService.addQuotationdetail(quotation);
		
		return "redirect:/quotationdetail/";
	}
	
	@GetMapping("/list")
	public String viewQuotationList(Model model) {
		
		List<QuotationDetail> quotationList = quotationService.getAllQuotationDetail();
		
		if(quotationList != null) {
			model.addAttribute("quotationList", quotationList);
		}
		return "layouts/listview/listofQuotationDetail";
	}
	
	@GetMapping("/edit/{id}")
	public String editQuotation(@PathVariable("id") String quotCode,Model model) {
		
		
		
		Optional<QuotationDetail> quotaion = quotationService.editQuotationDetail(quotCode);
		model.addAttribute("quotaion", quotaion);
		return "layouts/editview/editQuotationDetail";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteQuotation(@PathVariable("id") String quotCode,Model model) {
		quotationService.deleteQuotationDetail(quotCode);
		return "redirect:/quotationdetail/list";
	}

}