package com.access.erp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.GateEntry;
import com.access.erp.model.ItemOpening;
import com.access.erp.model.PurchaseOrder;
import com.access.erp.model.PurchaseOrderItem;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.repo.PurchaseOrderItemRepo;
import com.access.erp.repo.PurchaseOrderRepo;
import com.access.erp.service.GateEntryService;
import com.access.erp.service.ItemService;
import com.access.erp.service.PartyMasterService;
import com.access.erp.service.PurchaseOrderService;
import com.access.erp.utility.PurchaseOrderItem_Item;

@Controller
@RequestMapping("/gateentry")
public class GateEntryController {
	
	@Autowired PurchaseOrderService purchaseOrderService;
	@Autowired PurchaseOrderItemRepo purchaseOrderItemRepo;
	@Autowired ItemService itemService;
	
	@Autowired GateEntryService gateEntryService;
	
	@Autowired PartyMasterService partyMasterService;
	
	
	
	@GetMapping("/")
	public String gateEntryPage(Model model) {
		//strin nam = req.getpara("name")
		model.addAttribute("gateEntry", new GateEntry());
		
		List<PurchaseOrder> listPurchaseOrder = purchaseOrderService.getApprovedPurchaseorder();
		model.addAttribute("listPO", listPurchaseOrder);
		
		
		
		List<PartyMaster> partyMasterList = partyMasterService.findByPartyCodeContaining("S");
		model.addAttribute("partyMasterList", partyMasterList);
		
		
		
		return "layouts/Master/gateEntry";
	}
	
	
	@PostMapping("/")
	public String addGateEntry(@ModelAttribute("gateEntry") GateEntry gateEntry, RedirectAttributes redirectAttributes) {

		

		
		//boolean exists = companyRepo.existsById(company.getCompCode());
		/*
		 * if (!exists) {
		 * 
		 * companyService.addCompany(company);
		 * redirectAttributes.addFlashAttribute("message",
		 * "Company  has been saved successfully! ");
		 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		 * 
		 * } else {
		 * 
		 * redirectAttributes.addFlashAttribute("message",
		 * "Company Code Allready exists! Please try another One !!");
		 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); }
		 */
		gateEntryService.addGateEntry(gateEntry);
		
		redirectAttributes.addFlashAttribute("message", "Gate Entry  has been saved successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/gateentry/";
	}
	
	
	@GetMapping("/list")
	public String gateEntryList(Model model) {

		List<GateEntry> gateEntryList = gateEntryService.getAllGateEntry();

		if (gateEntryList != null) {
			model.addAttribute("gateEntryList", gateEntryList);
		}
		return "layouts/listview/listofGateEntry";
	}

	@GetMapping("/edit/{id}")
	public String editGateEntry(@PathVariable("id") String gateEntryCode, Model model) {

		System.out.println("edit item opening form is running ");
		GateEntry gateEntry = gateEntryService.editGateEntry(gateEntryCode).get();
		model.addAttribute("gateEntry", gateEntry);
		
		List<PartyMaster> partyMasterList = partyMasterService.findByPartyCodeContaining("S");
		model.addAttribute("partyMasterList", partyMasterList);
		

		List<PurchaseOrder> listPurchaseOrder = purchaseOrderService.getApprovedPurchaseorder();
		model.addAttribute("listPO", listPurchaseOrder);

		return "layouts/editview/editGateEntry";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteGateEntry(@PathVariable("id") String gateEntryCode, Model model,RedirectAttributes redirectAttributes) {
		gateEntryService.deleteGateEntry(gateEntryCode);
		
		redirectAttributes.addFlashAttribute("message", "Gate Entry  has been deleted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		
		return "redirect:/itemopening/list";
	}
	
	
	@ResponseBody
	@GetMapping("/indentdetailinpo/{poNumber}")
	public PurchaseOrder poDetail(@PathVariable(value = "poNumber") String poNumber, Model model) {

		System.out.println("item  iinfo : " + poNumber);

		PurchaseOrder po = purchaseOrderService.editPurchaseOrder(poNumber).get();
		
		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		String todayAsString = df.format(po.getPoDate());
		
		System.out.println("today as date : " + todayAsString);
		
		
		//po.setPoDate(new Date(po.getPoDate().toString().substring(10)));
		System.out.println("purchase order date type is : " + po.getPoDate());
		
		//Item item = itemService.editItem(itemCode).get();
		
		return po;

	}
	
	//Get Item lIst in purchase order item detail using po number (FK)
	
	@ResponseBody
	@GetMapping("/itemList/{poNumber}")
	public List<PurchaseOrderItem> itemDetailInPoDetail(@PathVariable(value = "poNumber") String poNumber, Model model) {

		System.out.println("item  iinfo : " + poNumber);

		PurchaseOrder po = purchaseOrderService.editPurchaseOrder(poNumber).get();
		
		List<PurchaseOrderItem>  purchaseOrderItem  = purchaseOrderItemRepo.findByPurchaseOrder(po);
		
		//Item item = itemService.editItem(itemCode).get();
		
	
		return purchaseOrderItem;

	}
	
	
	@ResponseBody
	@GetMapping("/itemInfo/{itemNumber}/{poNumber}")
	public PurchaseOrderItem_Item itemInfo(@PathVariable(value = "itemNumber") String itemNumber,@PathVariable(value = "poNumber") String poNumber, Model model) {

		
		PurchaseOrderItem_Item purchaseOrderItem_item = new PurchaseOrderItem_Item();
		
		PurchaseOrder purchaseOrder = purchaseOrderService.editPurchaseOrder(poNumber).get();
		Item item = itemService.editItem(itemNumber).get();
		
		PurchaseOrderItem purchaseOrderItem = purchaseOrderItemRepo.findByItemAndPurchaseOrder(item, purchaseOrder);
		
		purchaseOrderItem_item.setPurchaseOrderItem(purchaseOrderItem);
		purchaseOrderItem_item.setItem(item);
		//Item item = itemService.editItem(itemNumber).get();
		
	
		return purchaseOrderItem_item;

	}
	


}
