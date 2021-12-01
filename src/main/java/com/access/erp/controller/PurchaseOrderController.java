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
import com.access.erp.model.PurchaseOrder;
import com.access.erp.model.QuotationDetail;
import com.access.erp.model.RfQuotation;
import com.access.erp.model.RfQuotationItem;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.CurrencyMaster;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.State;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.CurrencyRepo;
import com.access.erp.repo.OpenIndentDetailRepo;
import com.access.erp.repo.OpenIndentRepo;
import com.access.erp.repo.QuotationDetailRepo;
import com.access.erp.repo.RFQuotationRepo;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.ItemService;
import com.access.erp.service.OpenIndentService;
import com.access.erp.service.PartyMasterService;
import com.access.erp.service.PurchaseOrderService;
import com.access.erp.service.RfQuotationService;
import com.access.erp.service.StateService;
import com.access.erp.utility.QuotationPartyState;

@Controller
@RequestMapping("purchaseorder")
public class PurchaseOrderController {

	@Autowired
	QuotationDetailRepo quotationDetailRepo;
	@Autowired
	SupplierRepo supplierRepo;
	@Autowired
	CurrencyRepo currencyRepo;

	@Autowired
	RFQuotationRepo rfQuotationRepo;
	@Autowired
	OpenIndentService openIndentService;
	@Autowired
	PurchaseOrderService purchaseOrderService;
	@Autowired
	PartyMasterService partyMasterService;
	@Autowired
	StateService stateService;
	@Autowired OpenIndentRepo openIndentRepo;
	@Autowired ItemService itemService;
	@Autowired OpenIndentDetailRepo openIndentDetailRepo;
	

	@GetMapping("/")
	public String purchaseOrder(Model model) {

		// only quotation which is approved

		List<QuotationDetail> lsitQuotationDetail = quotationDetailRepo.findByApprovalStatus1("Y");
		model.addAttribute("lsitQuotationDetail", lsitQuotationDetail);

		List<PartyMaster> listParty = partyMasterService.getAllpartyMaster();
		model.addAttribute("listParty", listParty);

		List<CurrencyMaster> listCurrency = currencyRepo.findAll();
		model.addAttribute("listCurrency", listCurrency);

		model.addAttribute("purchaseOrder", new PurchaseOrder());

		List<State> stateList = stateService.getAllState();
		model.addAttribute("stateList", stateList);

		return "layouts/Master/purchaseOrder";
	}

	@PostMapping("/")
	public String addPurchaseOrder(@ModelAttribute("purchaseOrder") PurchaseOrder po) {

		purchaseOrderService.addPurchaseOrder(po);
		return "redirect:/purchaseorder/";

	}

	@GetMapping("/list")
	public String listPurchaseOrder(Model model) {

		List<PurchaseOrder> listPurchaseOrder = purchaseOrderService.getAllPurchaseOrder();

		if (listPurchaseOrder != null) {
			model.addAttribute("listPurchaseOrder", listPurchaseOrder);
		}
		return "layouts/listview/listofPurchaseOrder";
	}

	@GetMapping("/edit/{id}")
	public String editPurchaseOrder(@PathVariable("id") String poCode, Model model) {

		System.out.println("po code is : " + poCode);

		List<QuotationDetail> lsitQuotationDetail = quotationDetailRepo.findAll();
		model.addAttribute("lsitQuotationDetail", lsitQuotationDetail);

		List<SupplierMaster> listSupplier = supplierRepo.findAll();
		model.addAttribute("listSupplier", listSupplier);

		List<CurrencyMaster> listCurrency = currencyRepo.findAll();
		model.addAttribute("listCurrency", listCurrency);

		PurchaseOrder po = purchaseOrderService.editPurchaseOrder(poCode).get();

		// System.out.println("get item list : " +
		// po.get().getListPurchaseOrderItem().get(0).getPacking());

		model.addAttribute("purchaseOrder", po);

		return "layouts/editview/editPurchaseOrder";
	}

	@GetMapping("/delete/{id}")
	public String deletePurchaseOrder(@PathVariable("id") String purchaseOrderCode, Model model) {

		purchaseOrderService.deletePurchaseOrder(purchaseOrderCode);
		return "redirect:/purchaseorder/list";
	}

	// AJAX Request

	@ResponseBody
	@GetMapping("/supplierDetail/{id}")
	public SupplierMaster getSupplierInfo(@PathVariable(value = "id") String id, Model model) {

		SupplierMaster supplier = supplierRepo.findBySupplierId(Long.parseLong(id));
		System.out.println("supplier detail : " + supplier.getSupplierState());
		return supplier;

	}

	@ResponseBody
	@GetMapping("/quotationDetail/{id}")
	public QuotationPartyState getQuotationInfo(@PathVariable(value = "id") String quotId, Model model) {

		QuotationDetail quotationDetail = quotationDetailRepo.findById(quotId).get();
		System.out.println("quotation detail : " + quotationDetail.getQuotDate());
		PartyMaster party = null;
		if (quotationDetail.getSuplierCode() != null || quotationDetail.getSuplierCode() != "") {

			party = partyMasterService.editPartyMaster(quotationDetail.getSuplierCode()).get();

		}
		QuotationPartyState quotationPartyState = new QuotationPartyState();
		quotationPartyState.setQuotationDetail(quotationDetail);
		quotationPartyState.setPartyMaster(party);

		return quotationPartyState;

	}

	// Against Quotation Through

	// list of indent against quotation

	@ResponseBody
	@GetMapping("/indentlist/{id}")
	public List<String> getIndentList(@PathVariable(value = "id") String quotationId, Model model) {

		System.out.println("get indent detail info");
		QuotationDetail quotationDetail = quotationDetailRepo.findById(quotationId).get();

		// get RFQ from quotationdetail

		System.out.println("rfq from quotation detauil : " + quotationDetail.getRfqNo());
		String rfqCode = quotationDetail.getRfqNo();

		RfQuotation rfQuotation = rfQuotationRepo.findById(rfqCode).get();

		List<String> listRfQuotationItem = new ArrayList<>();

		for (RfQuotationItem rfquotationItem : rfQuotation.getListRFQuotation()) {

			listRfQuotationItem.add(rfquotationItem.getOpenIndent().getIndentNumber());
			// System.out.println("item spec : " + rfquotationItem.getItemSpec());
		}

		return listRfQuotationItem;

	}

	// detail of indent
	
	@ResponseBody
	@GetMapping("/indentdetail/{id}")
	public OpenIndent getIndentDetail(@PathVariable(value = "id") String indentNum, Model model) {

		OpenIndent openIndent = openIndentService.editOpenIndent(indentNum).get();

		return openIndent;

	}
	
	
	// list of item against indent number 
	
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
	
	
	
	// item info which is in open indent detail table...
	
	@ResponseBody
	@GetMapping("/itemInfo/{itemCode}/{indentCode}")
	public OpenIndentDetail ItemInfoByItemCode(@PathVariable(value = "itemCode") String itemCode,@PathVariable(value = "indentCode") String indentCode, Model model) {

		System.out.println("item  iinfo : " + itemCode);
		System.out.println("indent   iinfo : " + indentCode);
		
		OpenIndent openIndent = openIndentService.editOpenIndent(indentCode).get();

		//OpenIndentDetail findByIndItemCodeAndOpenIndent(String indentItemCode,OpenIndent openIndent);
		OpenIndentDetail openIndentDetail = openIndentDetailRepo.findByIndItemCodeAndOpenIndent(itemCode, openIndent);
		
		
		return openIndentDetail;

	}
	

	// working
	// Against indent through

	@ResponseBody
	@GetMapping("/indent/indentdetail/")
	public List<String> getIndentDetailByPurchaseThroughIndent() {

		List<OpenIndent> listOpenIndent = openIndentService.getAllOpenIndent();

		List<String> indentList = new ArrayList<>();

		for (OpenIndent indent : listOpenIndent) {

			indentList.add(indent.getIndentNumber());
			// System.out.println("item spec : " + rfquotationItem.getItemSpec());
		}

		return indentList;
	}

	// get sipplier list/ party against quotation which is approved

	@ResponseBody
	@GetMapping("/supplierlist/{id}")
	public List<PartyMaster> getPartyMasterAgainstQuotation(@PathVariable(value = "id") String quotationId) {

		// QuotationDetail quotation =
		return null;
	}

}
