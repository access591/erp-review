package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.access.erp.model.GateEntry;
import com.access.erp.model.PurchaseOrder;
import com.access.erp.model.PurchaseOrderItem;
import com.access.erp.model.master.Item;
import com.access.erp.repo.PurchaseOrderItemRepo;
import com.access.erp.repo.PurchaseOrderRepo;
import com.access.erp.service.PurchaseOrderService;

@Controller
@RequestMapping("gateentry")
public class GateEntryController {
	
	@Autowired PurchaseOrderService purchaseOrderService;
	@Autowired PurchaseOrderItemRepo purchaseOrderItemRepo;
	
	
	@GetMapping("/")
	public String gateEntryPage(Model model) {
		
		model.addAttribute("gateEntry", new GateEntry());
		
		List<PurchaseOrder> listPurchaseOrder = purchaseOrderService.getApprovedPurchaseorder();
		model.addAttribute("listPO", listPurchaseOrder);
		
		
		return "layouts/Master/gateEntry";
	}
	
	
	@ResponseBody
	@GetMapping("/indentdetailinpo/{poNumber}")
	public PurchaseOrder poDetail(@PathVariable(value = "poNumber") String poNumber, Model model) {

		System.out.println("item  iinfo : " + poNumber);

		PurchaseOrder po = purchaseOrderService.editPurchaseOrder(poNumber).get();
		
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
	


}
