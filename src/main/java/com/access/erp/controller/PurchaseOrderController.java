package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.access.erp.model.QuotationDetail;
import com.access.erp.model.master.CurrencyMaster;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.CurrencyRepo;
import com.access.erp.repo.QuotationDetailRepo;
import com.access.erp.repo.SupplierRepo;

@Controller
@RequestMapping("purchaseorder")
public class PurchaseOrderController {
	
	@Autowired QuotationDetailRepo quotationDetailRepo;
	@Autowired SupplierRepo supplierRepo;
	@Autowired CurrencyRepo currencyRepo;
	
	
	@GetMapping("/")
	public String purchaseOrder(Model model) {
		
		List<QuotationDetail> lsitQuotationDetail = quotationDetailRepo.findAll();
		model.addAttribute("lsitQuotationDetail", lsitQuotationDetail);
		
		List<SupplierMaster> listSupplier = supplierRepo.findAll();
		model.addAttribute("listSupplier", listSupplier);
		
		List<CurrencyMaster> listCurrency = currencyRepo.findAll();
		model.addAttribute("listCurrency", listCurrency);
		
		
		return "layouts/Master/purchaseOrder";
	}
	
	
	
	@ResponseBody
	@GetMapping("/purchaseorder/{id}")
	public SupplierMaster getStateCountryById(@PathVariable(value = "id") String id, Model model) {
	
		SupplierMaster supplier = supplierRepo.findBySupplierId(Long.parseLong(id));
		System.out.println("supplier detail : "+ supplier.getSupplierState());
		return supplier;

	}

}
