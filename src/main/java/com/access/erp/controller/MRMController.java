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
import com.access.erp.model.master.CurrencyMaster;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.CurrencyRepo;
import com.access.erp.repo.GateEntryDetailRepo;
import com.access.erp.repo.MRMRepo;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.GateEntryService;
import com.access.erp.service.MRMService;
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
		
		MRN mrn = mrmService.editMrm(mrnNo).get();
		model.addAttribute("MRN", mrn);
		

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
	
	@ResponseBody
	@GetMapping("/gateentryinfo/{id}")
	public MrnUtility getItemInfoAgainstGateEntry(@PathVariable(value = "id") String id, Model model) {

		// GateEntryNumber

		GateEntry gateEntry = gateEntryService.editGateEntry(id).get();

		MrnUtility mrnUtility = new MrnUtility();
		mrnUtility.setGateEntry(gateEntry);

		List<GateEntryItemDetail> gateEntryDetailList = gateEntryDetailRepo.findByGateEntry(gateEntry);

		List<Item> itemList = new ArrayList<>();

		for (GateEntryItemDetail gateEntryDetail : gateEntryDetailList) {

			Item item = gateEntryDetail.getItem();
			itemList.add(item);
		}
		mrnUtility.setItemList(itemList);
		return mrnUtility;

	}
}
