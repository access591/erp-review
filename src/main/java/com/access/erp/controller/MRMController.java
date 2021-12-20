package com.access.erp.controller;

import java.util.ArrayList;
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

import com.access.erp.model.GateEntry;
import com.access.erp.model.GateEntryItemDetail;
import com.access.erp.model.MRN;
import com.access.erp.model.PurchaseOrder;
import com.access.erp.model.PurchaseOrderItem;
import com.access.erp.model.master.CurrencyMaster;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.Store;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.CurrencyRepo;
import com.access.erp.repo.GateEntryDetailRepo;
import com.access.erp.repo.MRMRepo;
import com.access.erp.repo.PurchaseOrderItemRepo;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.GateEntryService;
import com.access.erp.service.ItemService;
import com.access.erp.service.MRMService;
import com.access.erp.service.StoreService;
import com.access.erp.utility.MrnUtility;

@Controller
@RequestMapping("mrn")
public class MRMController {

	@Autowired
	GateEntryService gateEntryService;
	@Autowired
	SupplierRepo supplierRepo;
	@Autowired
	MRMRepo mrmRepo;
	@Autowired
	MRMService mrmService;

	@Autowired
	CurrencyRepo currencyRepo;
	@Autowired
	GateEntryDetailRepo gateEntryDetailRepo;
	@Autowired ItemService itemService;
	@Autowired PurchaseOrderItemRepo purchaseOrderItemRepo;
	@Autowired StoreService storeService;
	
	

	@GetMapping("/")
	public String mrmPage(Model model) {

		List<GateEntry> gateEntryList = gateEntryService.getAllGateEntry();
		model.addAttribute("gateEntryList", gateEntryList);

		List<SupplierMaster> supplierList = new ArrayList<>();
		for (GateEntry gateEntry : gateEntryList) {

			//SupplierMaster supplier = gateEntry.getSupplier();
			//supplierList.add(supplierRepo.findBySupplierId(supplier.getSupplierId()));
			
			
		}

		model.addAttribute("supplierList", supplierList);

		List<CurrencyMaster> currencyList = currencyRepo.findAll();
		model.addAttribute("currencyList", currencyList);
		

		List<Store> storeList = storeService.getAllStore();
		model.addAttribute("storeList", storeList);

		model.addAttribute("mrn", new MRN());

		return "layouts/Master/mrn";
	}

	@PostMapping("/")
	public String addMRM(@ModelAttribute("MRN") MRN mrn) {

		// System.out.println(" testing : " +
		// openIndent.getOpeIndentDetail().get(0).getTotalValue());
		mrmService.addMrm(mrn);

		return "redirect:/mrn/";
	}

	@GetMapping("/list")
	public String viewOpenIndentList(Model model) {

		List<MRN> mrnList = mrmService.getAllMrm();

		if (mrnList != null) {
			model.addAttribute("mrnList", mrnList);
		}

		return "layouts/listview/listofMrn";
	}

	@GetMapping("/edit/{id}")
	public String editMrn(@PathVariable("id") String mrnNo, Model model) {

		System.out.println("edit mrn indent form is running ");
		
		List<GateEntry> gateEntryList = gateEntryService.getAllGateEntry();
		model.addAttribute("gateEntryList", gateEntryList);
		
		List<Item> itemList = itemService.getAllItem();
		model.addAttribute("itemList", itemList);
		
		MRN mrn = mrmService.editMrm(mrnNo).get();
		model.addAttribute("mrn", mrn);
		
		List<Store> storeList = storeService.getAllStore();
		model.addAttribute("storeList", storeList);
		

		return "layouts/editview/editMrn";
	}

	@GetMapping("/delete/{id}")
	public String deleteOpenIndent(@PathVariable("id") String mrnNo, Model model) {
		mrmService.deleteMrm(mrnNo);
		return "redirect:/mrn/list";
	}

	
	@GetMapping("/mrnTaxInfo")
	public String taxInfo(Model model) {
		
		model.addAttribute("mrn", new MRN());
		
		return "layouts/Master/mrnTaxInfo";
	}

	
	//AJAX  
	
	
	@ResponseBody
	@GetMapping("/gateentryinfo/{id}")
	public MrnUtility getGateEntryInfoAgainstGateEntry(@PathVariable(value = "id") String id, Model model) {

		// GateEntryNumber

		GateEntry gateEntry = gateEntryService.editGateEntry(id).get();

		MrnUtility mrnUtility = new MrnUtility();
		mrnUtility.setGateEntry(gateEntry);

		List<GateEntryItemDetail> gateEntryDetailList = gateEntryDetailRepo.findByGateEntry(gateEntry);

		List<Item> itemList = new ArrayList<>();

		for (GateEntryItemDetail gateEntryDetail : gateEntryDetailList) {

			
		
			Item item = gateEntryDetail.getItem();
			itemList.add(item);
			mrnUtility.setPoGst(gateEntryDetail.getPurchaseOrder().getGst());
			mrnUtility.setCurrency (gateEntryDetail.getPurchaseOrder().getCurrency());
			mrnUtility.setConversionValue(String.valueOf( gateEntryDetail.getPurchaseOrder().getConversionValue()));
		}
		//mrnUtility.setItemList(itemList);
		return mrnUtility;

	}
	
	@ResponseBody
	@GetMapping("itemlist/againstgateentry/{gateEntry}")
	public List<Item> getItemListAgainstGateEntry(@PathVariable(value = "gateEntry") String gateEntryNo){
		
		GateEntry gateEntry = gateEntryService.editGateEntry(gateEntryNo).get();
		List<GateEntryItemDetail> gateEntryDetailList = gateEntryDetailRepo.findByGateEntry(gateEntry);
		List<Item> itemList = new ArrayList<>();
		
		for (GateEntryItemDetail gateEntryDetail : gateEntryDetailList) {
		
			Item item = gateEntryDetail.getItem();
			itemList.add(item);
	
		}
		
		return itemList;
	}
	
	
	@ResponseBody
	@GetMapping("iteminfo/againstgateentry/{itemCode}/{gateEntry}")
	public PurchaseOrderItem getItemInfoAgainstGateEntry(@PathVariable(value = "itemCode") String itemCode , @PathVariable(value="gateEntry") String gateEntryNo){
		
		System.out.println("hello ");
		GateEntry gateEntry = gateEntryService.editGateEntry(gateEntryNo).get();
		
		Item item = itemService.editItem(itemCode).get();
		
		PurchaseOrderItem purchaseOrderItem = null  ;
		
		// find against item code and gate entry code 
		List<GateEntryItemDetail> gateEntryDetailList = gateEntryDetailRepo.findByGateEntryAndItem(gateEntry, item);
		
		if(gateEntryDetailList.size()>0) {
			PurchaseOrder purchaseOrder = gateEntryDetailList.get(0).getPurchaseOrder();
			purchaseOrderItem  = purchaseOrderItemRepo.findByItemAndPurchaseOrder(item, purchaseOrder);
		}
		
		// po from gate entry 
		// get po detail by po id and item 
		
		
				
				
	
		return purchaseOrderItem;
		//return gateEntryDetailList;
	}
	
	
	
	//AJAX for EDIT MODE
	
	@ResponseBody
	@GetMapping("/edit/gateentryinfo/{id}")
	public MrnUtility getGateEntryInfoAgainstGateEntryEdit(@PathVariable(value = "id") String id, Model model) {

		// GateEntryNumber

		GateEntry gateEntry = gateEntryService.editGateEntry(id).get();

		MrnUtility mrnUtility = new MrnUtility();
		mrnUtility.setGateEntry(gateEntry);

		List<GateEntryItemDetail> gateEntryDetailList = gateEntryDetailRepo.findByGateEntry(gateEntry);

		List<Item> itemList = new ArrayList<>();

		for (GateEntryItemDetail gateEntryDetail : gateEntryDetailList) {

			
		
			Item item = gateEntryDetail.getItem();
			itemList.add(item);
			mrnUtility.setPoGst(gateEntryDetail.getPurchaseOrder().getGst());
			mrnUtility.setCurrency (gateEntryDetail.getPurchaseOrder().getCurrency());
			mrnUtility.setConversionValue(String.valueOf( gateEntryDetail.getPurchaseOrder().getConversionValue()));
		}
		//mrnUtility.setItemList(itemList);
		return mrnUtility;

	}
	

	@ResponseBody
	@GetMapping("/edit/itemlist/againstgateentry/{gateEntry}")
	public List<Item> getItemListAgainstGateEntryEdit(@PathVariable(value = "gateEntry") String gateEntryNo){
		
		GateEntry gateEntry = gateEntryService.editGateEntry(gateEntryNo).get();
		List<GateEntryItemDetail> gateEntryDetailList = gateEntryDetailRepo.findByGateEntry(gateEntry);
		List<Item> itemList = new ArrayList<>();
		
		for (GateEntryItemDetail gateEntryDetail : gateEntryDetailList) {
		
			Item item = gateEntryDetail.getItem();
			itemList.add(item);
	
		}
		
		return itemList;
	}
	
	
	@ResponseBody
	@GetMapping("/edit/iteminfo/againstgateentry/{itemCode}/{gateEntry}")
	public PurchaseOrderItem getItemInfoAgainstGateEntryEdit(@PathVariable(value = "itemCode") String itemCode , @PathVariable(value="gateEntry") String gateEntryNo){
		
		System.out.println("hello ");
		GateEntry gateEntry = gateEntryService.editGateEntry(gateEntryNo).get();
		
		Item item = itemService.editItem(itemCode).get();
		
		PurchaseOrderItem purchaseOrderItem = null  ;
		
		// find against item code and gate entry code 
		List<GateEntryItemDetail> gateEntryDetailList = gateEntryDetailRepo.findByGateEntryAndItem(gateEntry, item);
		
		if(gateEntryDetailList.size()>0) {
			PurchaseOrder purchaseOrder = gateEntryDetailList.get(0).getPurchaseOrder();
			purchaseOrderItem  = purchaseOrderItemRepo.findByItemAndPurchaseOrder(item, purchaseOrder);
		}
		
		// po from gate entry 
		// get po detail by po id and item 
		
		
				
				
	
		return purchaseOrderItem;
		//return gateEntryDetailList;
	}
	
	
	
}
