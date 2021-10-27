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

import com.access.erp.model.OpenIndent;
import com.access.erp.model.QuotationDetail;
import com.access.erp.model.RfQuotation;
import com.access.erp.model.master.CurrencyMaster;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.CurrencyRepo;
import com.access.erp.repo.OpenIndentRepo;
import com.access.erp.repo.QuotationDetailRepo;
import com.access.erp.repo.RFQuotationRepo;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.QuotationDetailService;
import com.access.erp.service.RfQuotationService;

@Controller
@RequestMapping("approvalquotationdetail")
public class QuotationDetailApprovalController {
	
	@Autowired QuotationDetailRepo quotationDetailRepo;
	@Autowired QuotationDetailService quotationDetailService;
	
	@Autowired QuotationDetailService quotationService;
	@Autowired RfQuotationService rfQuotationService;
	@Autowired RFQuotationRepo rfQuotationRepo;
	@Autowired SupplierRepo supplierRepo;
	@Autowired CurrencyRepo currencyRepo;
	@Autowired OpenIndentRepo openIndentRepo;
	
	
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
	public String viewQuotationDetail(@PathVariable("quotNum") String quotCode,Model model
			) {
		
		List<RfQuotation> listRfQuotation = rfQuotationService.getAllRfQuotation();
		model.addAttribute("listRfQuotation", listRfQuotation);

		List<SupplierMaster> listSupplierMaster = supplierRepo.findAll();
		model.addAttribute("listSupplier", listSupplierMaster);

		List<CurrencyMaster> listCurrencyMaster = currencyRepo.findAll();
		model.addAttribute("listCurrencyMaster", listCurrencyMaster);

		// get indent number which is in RFQ (Child Of RFQ)
		List<OpenIndent> listIndentInRfq = quotationService.getIndentInRFQ();
		model.addAttribute("listIndentInRfq", listIndentInRfq);
		
		
		
		QuotationDetail quotaion = quotationService.editQuotationDetail(quotCode).get();
		model.addAttribute("quotation", quotaion);
	
		return "layouts/view/viewQuotationDetail";
	}
	
	
	
	
	@GetMapping("/quotationapprovallist")
	public String quotationApprovalList() {
		
		return "layouts/Master/quotationApprovalList";
	}

}
