package com.access.erp.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.OpenIndentDetail;
import com.access.erp.model.QuotationDetail;
import com.access.erp.model.RfQuotation;
import com.access.erp.model.master.CurrencyMaster;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.CurrencyRepo;
import com.access.erp.repo.OpenIndentRepo;
import com.access.erp.repo.RFQuotationRepo;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.ItemService;
import com.access.erp.service.QuotationDetailService;
import com.access.erp.service.RfQuotationService;

@Controller
@RequestMapping("/quotationdetail")
public class QuotationDetailController {

	@Autowired
	QuotationDetailService quotationService;
	@Autowired
	RfQuotationService rfQuotationService;
	@Autowired
	RFQuotationRepo rfQuotationRepo;
	@Autowired
	SupplierRepo supplierRepo;
	@Autowired
	CurrencyRepo currencyRepo;
	@Autowired
	OpenIndentRepo openIndentRepo;
	@Autowired
	ItemService itemService;

	@GetMapping("/")
	public String quotationDetail(Model model) {

		List<RfQuotation> listRfQuotation = rfQuotationService.getAllRfQuotation();
		model.addAttribute("listRfQuotation", listRfQuotation);

		List<SupplierMaster> listSupplierMaster = supplierRepo.findAll();
		model.addAttribute("listSupplier", listSupplierMaster);

		List<CurrencyMaster> listCurrencyMaster = currencyRepo.findAll();
		model.addAttribute("listCurrencyMaster", listCurrencyMaster);

		// get indent number which is in RFQ (Child Of RFQ)
		List<OpenIndent> listIndentInRfq = quotationService.getIndentInRFQ();
		model.addAttribute("listIndentInRfq", listIndentInRfq);

		model.addAttribute("quotation", new QuotationDetail());
		return "layouts/Master/quotationDetail";
	}
	
	
	

	@PostMapping("/")
	public String addQuotationDetail(@ModelAttribute("quotation") QuotationDetail quotation) {

		System.out.println("Hello");
		quotationService.addQuotationdetail(quotation);

		return "redirect:/quotationdetail/";
	}

	@GetMapping("/list")
	public String viewQuotationList(Model model) {

		List<QuotationDetail> quotationList = quotationService.getAllQuotationDetail();

		if (quotationList != null) {
			model.addAttribute("quotationList", quotationList);
		}
		return "layouts/listview/listofQuotationDetail";
	}

	@GetMapping("/edit/{id}")
	public String editQuotation(@PathVariable("id") String quotCode, Model model) {

		Optional<QuotationDetail> quotaion = quotationService.editQuotationDetail(quotCode);
		model.addAttribute("quotaion", quotaion);
		return "layouts/editview/editQuotationDetail";
	}

	@GetMapping("/delete/{id}")
	public String deleteQuotation(@PathVariable("id") String quotCode, Model model) {
		quotationService.deleteQuotationDetail(quotCode);
		return "redirect:/quotationdetail/list";
	}

	@ResponseBody
	@GetMapping("/rfqdetail/{id}")
	public RfQuotation getStateCountryById(@PathVariable(value = "id") String id, Model model) {

		RfQuotation rfQuotation = rfQuotationRepo.findByRfqNo(id);
		return rfQuotation;

	}

	@ResponseBody
	@GetMapping("/supplierinfo/{supplierCode}")
	public SupplierMaster supplierInfo(@PathVariable(value = "supplierCode") String supplierCode, Model model) {

		System.out.println("supplierCode iinfo : " + supplierCode);

		SupplierMaster supllier = supplierRepo.findBySupplierId(Long.valueOf(supplierCode).longValue());

		return supllier;

	}

	@ResponseBody
	@GetMapping("/indentdetail/{indentNumber}")
	public OpenIndent indentDetailByIndentNumber(@PathVariable(value = "indentNumber") String indentNumber,
			Model model) {

		System.out.println("supplierCode iinfo : " + indentNumber);

		OpenIndent openIndent = openIndentRepo.findByIndentNumber(indentNumber);

		System.out.println("indent date is : " + openIndent.getIndentDate());

		// OpenIndent openIndent = openIndentRepo.findById(indentNumber).get();

		return openIndent;

	}

	@ResponseBody
	@GetMapping("/itemList/{indentNumber}")
	public List<Item> ItemInfoByIndentNumber(@PathVariable(value = "indentNumber") String indentNumber, Model model) {

		System.out.println("indent number iinfo : " + indentNumber);

		/*
		 * 1- get Open Indent Detail 2- fetch indent Detail from openIndent 2- get Item
		 * Code which is in Indent Detail Entity by string formate
		 */

		List<Item> listItem = new ArrayList<>();
		OpenIndent openIndent = openIndentRepo.findByIndentNumber(indentNumber);

		for (OpenIndentDetail detail : openIndent.getOpeIndentDetail()) {

			String itemCode = detail.getIndItemCode();
			System.out.println("Item code is : " + itemCode);

			Item item = itemService.editItem(itemCode).get();

			System.out.println(" Item Info : " + item.getItemCode());
			listItem.add(item);
		}

		return listItem;

	}

	@ResponseBody
	@GetMapping("/itemInfo/{itemCode}")
	public Item ItemInfoByItemCode(@PathVariable(value = "itemCode") String itemCode, Model model) {

		System.out.println("item  iinfo : " + itemCode);

		
		Item item = itemService.editItem(itemCode).get();
		
		return item;

	}

}