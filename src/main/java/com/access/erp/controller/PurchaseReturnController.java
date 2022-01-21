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

import com.access.erp.model.MRN;
import com.access.erp.model.PurchaseReturn;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.service.ItemService;
import com.access.erp.service.MRMService;
import com.access.erp.service.PartyMasterService;
import com.access.erp.service.PurchaseReturnService;



@Controller
@RequestMapping("/purchasereturn")
public class PurchaseReturnController {

	@Autowired PurchaseReturnService purchasereturnService;
	@Autowired MRMService mrnService;
	@Autowired PartyMasterService partyMasterService;
	@Autowired ItemService itemService;
	
	
	@GetMapping("/")
	public String purchaseReturnPage(Model model) {
		
		List<MRN> MrnList=mrnService.getAllMrm();
		model.addAttribute("Mrnlist",MrnList);
		
		List<PartyMaster> listParty=partyMasterService.getAllpartyMaster();
		model.addAttribute("listParty",listParty);
		
		List<Item> listItem = itemService.getAllItem();
		model.addAttribute("listitem", listItem);
		
		model.addAttribute("purchaseReturn", new PurchaseReturn());
		return"layouts/Master/purchaseReturn";
		
	}
	
	@PostMapping("/")
	public String addPurchaseReturn(@ModelAttribute("purchaseReturn") PurchaseReturn purchaseReturn,RedirectAttributes redirectAttributes ) {
		System.out.println("testing :" + purchaseReturn.getIssueNo() );
		System.out.println("testing :" + purchaseReturn.getPrDate() );
		System.out.println("testing :" + purchaseReturn.getPartyMaster().getPartyCode());

		
		purchasereturnService.addPurchaseReturn(purchaseReturn);
		
		return"redirect:/purchasereturn/";
		
	}
	
	@GetMapping("/list")
	public String purchaseReturnList(Model model) {
		
		
		List<PurchaseReturn>purchaseReturnList=purchasereturnService.getAllPurchaseReturn();
		if (purchaseReturnList != null) {
			model.addAttribute("purchaseReturnList", purchaseReturnList);
		}
		return "layouts/listview/listofPurchaseReturn";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editPurchaseReturn(@PathVariable("id") String purchasePrNo,Model model) {
		
		PurchaseReturn purchaseReturn = purchasereturnService.editPurchaseReturn(purchasePrNo).get();
		model.addAttribute("purchaseReturn", purchaseReturn);
		
		List<MRN> MrnList=mrnService.getAllMrm();
		model.addAttribute("Mrnlist",MrnList);
		
		List<PartyMaster> listParty=partyMasterService.getAllpartyMaster();
		model.addAttribute("listParty",listParty);
		
		List<Item> listItem = itemService.getAllItem();
		model.addAttribute("listitem", listItem);
		
		
	
		return"layouts/editview/editPurchaseReturn";
	}
	
	
	  @GetMapping("/delete/{id}") public String deletePurchaseReturn(@PathVariable("id")
	  
	  String purchasePrNo, Model model,RedirectAttributes redirectAttributes) {
		  purchasereturnService.deletePurchaseReturn(purchasePrNo);
	  
	  redirectAttributes.addFlashAttribute("message","PurchaseReturn  has been deleted successfully!");
	  redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	  
	  return "redirect:/purchasereturn/list"; 
	  }
	  
	  
	  @PostMapping("/update")
		public String updatePurchaseReturn(@ModelAttribute("purchaseReturn") PurchaseReturn purchaseReturn,RedirectAttributes redirectAttributes ) {
			System.out.println("testing :" + purchaseReturn.getIssueNo() );
			System.out.println("testing :" + purchaseReturn.getPrDate() );
			System.out.println("testing :" + purchaseReturn.getPartyMaster().getPartyCode());

			
			purchasereturnService.updatePurchaseReturn(purchaseReturn);
			
			return"redirect:/purchasereturn/";
			
		}
	  
	  
	  
	 
	
	
	
	
	
	
	
}
