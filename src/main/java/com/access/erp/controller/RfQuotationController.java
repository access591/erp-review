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
import com.access.erp.model.RfQuotation;
import com.access.erp.model.master.City;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.State;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.ItemRepo;
import com.access.erp.repo.OpenIndentRepo;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.OpenIndentDetailService;
import com.access.erp.service.OpenIndentService;
import com.access.erp.service.RfQuotationService;
import com.access.erp.utility.ItemListOfIndent;



/*request for quotation*/



@Controller
@RequestMapping("/requestquotation")
public class RfQuotationController {

	@Autowired  OpenIndentService openIndentService;
	@Autowired OpenIndentDetailService openIndentDetailService;
	@Autowired ItemRepo itemRepo;
	@Autowired OpenIndentRepo openIndentRepo;
	@Autowired SupplierRepo supplierRepo;
	@Autowired RfQuotationService rfQuotationService;
	
	
	
	@GetMapping("/")
	public String requestQuotation(Model model) {
		
		List<OpenIndent> aprovedOpenIndentList = openIndentService.approvedOpenIndent();
		model.addAttribute("aprovedOpenIndentList", aprovedOpenIndentList);
		
		model.addAttribute("rFQuotation", new RfQuotation());
		
		List<SupplierMaster> listSupplierMaster = supplierRepo.findAll();
		model.addAttribute("listSupplier", listSupplierMaster);
		
		return "layouts/Master/requestForQuotation";
	}
	
	
	
	
	@PostMapping("/")
	public String addrFQuotation(@ModelAttribute("rFQuotation")RfQuotation rfQuotation) {
		
		System.out.println( " add rf Quotation method " );
		rfQuotationService.addRfQuotation(rfQuotation);
		return "redirect:/requestquotation/";
	}
	
	
	@GetMapping("/list")
	public String viewRequestQuotation(Model model) {
		
		List<RfQuotation> rfqList = rfQuotationService.getAllRfQuotation();
		
		if(rfqList != null) {
			model.addAttribute("rfqList", rfqList);
		}
		return "layouts/listview/listofRequestForQuotation";
	}
	
	@GetMapping("/edit/{id}")
	public String editRequestQuotation(@PathVariable("id") String rfqCode,Model model) {
		
		System.out.println("rfqCode code is : "+ rfqCode);
		
		List<OpenIndent> aprovedOpenIndentList = openIndentService.approvedOpenIndent();
		model.addAttribute("aprovedOpenIndentList", aprovedOpenIndentList);
		
		List<SupplierMaster> listSupplierMaster = supplierRepo.findAll();
		model.addAttribute("listSupplier", listSupplierMaster);
		
		
		Optional<RfQuotation> rFQuotation = rfQuotationService.editRfQuotation(rfqCode);
		
		// openIndent.ifPresent(indent -> model.addAttribute("openIndent", indent));
		
		rFQuotation.ifPresent(quotation -> model.addAttribute("rFQuotation", quotation));
		
		//model.addAttribute("rFQuotation", rFQuotation);
		return "layouts/editview/editRequestForQuotation";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRequestQuotation(@PathVariable("id") String rfqCode,Model model) {
		rfQuotationService.deleteRfQuotation(rfqCode);
		return "redirect:/requestquotation/list";
	}
	
	
	
	
	
	
	
	
	
	@ResponseBody
	@GetMapping("/itemdetail/{indentNumber}")
	public ItemListOfIndent getItemListBehalfOfIndentNumber(@PathVariable(value = "indentNumber") String indentNumber, Model model) {
		
		System.out.println("employee iinfo : "+ indentNumber);
		
		OpenIndent openIndent = new OpenIndent();
		openIndent.setIndentNumber(indentNumber);
		
		ItemListOfIndent itemListOfIndent = new ItemListOfIndent();
		
		List<OpenIndentDetail> listOpenIndentDetail = openIndentDetailService.findOpenIndentDetailByOpenIndent(openIndent);
		
		OpenIndent indent = openIndentRepo.findByIndentNumber(indentNumber);
		
		List<Item> listItem = new ArrayList<>();
		
		for(OpenIndentDetail indentDetail : listOpenIndentDetail) {
			
			Item item = itemRepo.findByItemCode(indentDetail.getIndItemCode());
			System.out.println("item info : " + item.getDescription());
			System.out.println("item info : " + item.getItemCode());
			listItem.add(item);
		}
		
		itemListOfIndent.setIndentDate(indent.getIndentDate());
		itemListOfIndent.setListItem(listItem);
		
		return itemListOfIndent;
		
		
	}
	
	@ResponseBody
	@GetMapping("/itemdetail1/{itemCode}")
	public Item getItemDetail(@PathVariable(value = "itemCode") String itemCode, Model model) {
		
		System.out.println("item iinfo : "+ itemCode);
		
		Item item = itemRepo.findByItemCode(itemCode);
		
		return item;
		
		
	}
	
	
	@ResponseBody
	@GetMapping("/supplierdetail/{supplierCode}")
	public SupplierMaster supplierDetail(@PathVariable(value = "supplierCode") String supplierCode, Model model) {
		
		System.out.println("supplierCode iinfo : "+ supplierCode);
		
		SupplierMaster supllier = supplierRepo.findBySupplierId(Long.valueOf(supplierCode).longValue());
		
		return supllier;
		
		
	}
	
	
	@ResponseBody
	@GetMapping("/indentinfo")
	public List<OpenIndent> indentInfo( Model model) {
		
		
		
		List<OpenIndent> listOpenIndent = openIndentRepo.findAll();		
		return listOpenIndent;
		
		
	}
}
