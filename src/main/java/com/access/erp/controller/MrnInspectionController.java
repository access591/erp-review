package com.access.erp.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.access.erp.model.FifoRateItem;
import com.access.erp.model.ItemOpening;
import com.access.erp.model.MRN;
import com.access.erp.model.MRNDetail;
import com.access.erp.model.MrnInspection;
import com.access.erp.model.MrnInspectionItemDetail;
import com.access.erp.model.StoreWiseStock;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.Store;
import com.access.erp.repo.FefoRateItemRepo;
import com.access.erp.repo.MRMRepo;
import com.access.erp.repo.MrnDetailRepo;
import com.access.erp.repo.StoreWisestockRepo;
import com.access.erp.service.CompanyService;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.FinancialActiveYearService;
import com.access.erp.service.FinancialYearService;
import com.access.erp.service.ItemOpeningService;
import com.access.erp.service.ItemService;
import com.access.erp.service.MRMService;
import com.access.erp.service.MrnInspectionService;
import com.access.erp.service.PartyMasterService;
import com.access.erp.service.StoreService;
import com.access.erp.singleton.GlobalParameter;

@Controller
@RequestMapping("/inspection")
public class MrnInspectionController {

	@Autowired
	MRMService mrmService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	MrnInspectionService mrnInspectionService;
	@Autowired
	MrnDetailRepo mrnDetailRepo;
	@Autowired
	ItemService itemService;
	@Autowired
	MRMRepo mrnRepo;

	@Autowired
	FefoRateItemRepo fifoRateItemRepo;
	@Autowired
	StoreWisestockRepo storeWiseStockRepo;
	@Autowired
	FinancialYearService fyYearService;
	@Autowired
	CompanyService companyService;
	@Autowired
	PartyMasterService partyMasterService;
	@Autowired
	StoreService storeService;
	@Autowired ItemOpeningService itemOpeningService;
	@Autowired GlobalParameter globalParameter;

	// @Autowired FinancialActiveYearService fyActiveYearService;

	@GetMapping("/")
	public String inspectionPage(Model model) {

		model.addAttribute("inspection", new MrnInspection());

		// List<MRN> mrmList = mrnRepo.findByMrnDetailsDol("Y");

		List<MRNDetail> ListmrnDetail = mrnDetailRepo.findByDolStatus("Y");

		model.addAttribute("mrmList", ListmrnDetail);

		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);

		return "layouts/Master/mrnInspection";
	}

	@PostMapping("/")
	public String addInspection(@ModelAttribute("inspection") MrnInspection inspection,
			RedirectAttributes redirectAttributes) {

		/*
		 * boolean exists = companyRepo.existsById(company.getCompCode()); if (!exists)
		 * {
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

		// update fifo table

		FinancialYear fyYear = fyYearService.editFinancialYear("21-22").get();
		Company company = companyService.editCompany("EB");
		MRN mrn = mrmService.editMrm(inspection.getMrn().getMrnNo()).get();

		PartyMaster party = partyMasterService.editPartyMaster(mrn.getPartyMaster().getPartyCode()).get();

		// Store store = storeService.editStore

		List<Item> itemList = new ArrayList<>();

		// if item == accepected
		// int i = 0; i< inspection.getMrnInspectionItems().size() ;
		for (MrnInspectionItemDetail inspectionItemDetail : inspection.getMrnInspectionItems()) {

			// if item == accepected

			FifoRateItem fiffoRate = new FifoRateItem();

			fiffoRate.setFyYear(fyYear);
			fiffoRate.setMrn(mrn);
			fiffoRate.setCompany(company);

			fiffoRate.setMrnDate(mrn.getMrnDate());

			Item item = itemService.editItem(inspectionItemDetail.getItem().getItemCode()).get();

			// find item which is in mrn detail against item and mrn

			List<MRNDetail> mrnDetail = mrnDetailRepo.findByMrnAndItem(mrn, item);

			if (mrnDetail.size() > 0) {

				fiffoRate.setRate(mrnDetail.get(0).getItemRate());
				fiffoRate.setQty(mrnDetail.get(0).getItemRec());
				fiffoRate.setPenItems(mrnDetail.get(0).getItemRec());
				fiffoRate.setItemNetVal(mrnDetail.get(0).getPoNetVal());

			}

			// Store

			fiffoRate.setItem(item);

			fiffoRate.setPartyMaster(party);

			fifoRateItemRepo.save(fiffoRate);

			// for StorewiseStock

			StoreWiseStock storeWiseStock = new StoreWiseStock();

			storeWiseStock.setItem(item);

			if (mrnDetail.get(0).getStore() != null) {

				storeWiseStock.setStore(mrnDetail.get(0).getStore());

			}

			storeWiseStock.setQty(mrnDetail.get(0).getItemRec());

			storeWiseStock.setQty(inspectionItemDetail.getInspectedQty());
			storeWiseStock.setFyYear(fyYear);
			
			storeWiseStock.setCompany(company);
			
			storeWiseStockRepo.save(storeWiseStock);
			
			
			
			
			ItemOpening itemOpening = itemOpeningService.editItemOpening(item.getItemCode()).get();
			
			itemOpening.setCurrentStock(itemOpening.getCurrentStock()+mrnDetail.get(0).getItemRec());
			itemOpeningService.addItemOpening(itemOpening);
			
			

		}

	
		inspection.setCompany(globalParameter.getCompany());
		inspection.setFy(globalParameter.getFyYear());
		inspection.setMyUser(globalParameter.getMyUser());
		
		mrnInspectionService.addMrnInspection(inspection);
		return "redirect:/inspection/";
	}

	@GetMapping("/list")
	public String viewInspectionList(Model model) {

		List<MrnInspection> listInspection = mrnInspectionService.getAllMrnInspection();

		if (listInspection != null) {
			model.addAttribute("listInspection", listInspection);
		}
		return "layouts/listview/listofMrnInspection";
	}

	@GetMapping("/edit/{id}")
	public String editInspection(@PathVariable("id") String inspCode, Model model) {

		System.out.println("company code is : " + inspCode);

		List<MRN> mrmList = mrmService.getAllMrm();
		model.addAttribute("mrmList", mrmList);

		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);

		List<Item> itemList = itemService.getAllItem();
		model.addAttribute("itemList", itemList);

		MrnInspection inspection = mrnInspectionService.editMrnInspection(inspCode).get();
		model.addAttribute("inspection", inspection);

		return "layouts/editview/editMrnInspection";
	}

	@GetMapping("/delete/{id}")
	public String deleteInspection(@PathVariable("id") String inspCode, Model model) {
		mrnInspectionService.deleteMrnInspection(inspCode);
		return "redirect:/inspection/list";
	}

	@GetMapping("/approval/")
	public String approvalInspection(@ModelAttribute("inspection") Model model) {

		return "layouts/Master/mrnInspectionApproval";
	}

	// AJAX FOR ADD PAGE

	@ResponseBody
	@GetMapping("/mrninfo/{id}")
	public MRN mrnInfo(@PathVariable(value = "id") String id, Model model) {

		// GateEntryNumber
		MRN mrn = mrmService.editMrm(id).get();

		return mrn;

	}

	// itemlist/againstmrn/

	@ResponseBody
	@GetMapping("/itemlist/againstmrn/{id}")
	public List<Item> getItemListAgainstMrn(@PathVariable(value = "id") String mrnCode, Model model) {

		MRN mrn = mrmService.editMrm(mrnCode).get();

		List<MRNDetail> mrnDetail = mrnDetailRepo.findByMrn(mrn);

		// mrnDetail.stream().distinct().collect(Collectors.toList());

		List<Item> itemList = new ArrayList<>();

		for (MRNDetail mDetail : mrnDetail) {
			if (!itemList.contains(mDetail.getItem())) {
				itemList.add(mDetail.getItem());
			}
		}

		return itemList;

	}

	// get item info against mrno

	@ResponseBody
	@GetMapping("/iteminfo/againstmrn//{itemCode}/{mrnNo}")
	public MRNDetail getItemInfoAgainstMrn(@PathVariable(value = "mrnNo") String mrnCode,
			@PathVariable(value = "itemCode") String itemCode) {

		MRN mrn = mrmService.editMrm(mrnCode).get();
		Item item = itemService.editItem(itemCode).get();

		List<MRNDetail> mrnDetail = mrnDetailRepo.findByMrnAndItem(mrn, item);

		if (mrnDetail.size() > 0) {
			return mrnDetail.get(0);
		}

		return null;

	}

	// Ajax for in edit mode

	@ResponseBody
	@GetMapping("edit/itemlist/againstmrn/{id}")
	public List<Item> getItemListAgainstMrnEdit(@PathVariable(value = "id") String mrnCode, Model model) {

		MRN mrn = mrmService.editMrm(mrnCode).get();

		List<MRNDetail> mrnDetail = mrnDetailRepo.findByMrn(mrn);

		// mrnDetail.stream().distinct().collect(Collectors.toList());

		List<Item> itemList = new ArrayList<>();

		for (MRNDetail mDetail : mrnDetail) {
			if (!itemList.contains(mDetail.getItem())) {
				itemList.add(mDetail.getItem());
			}
		}

		return itemList;

	}

	// get item info against mrno

	@ResponseBody
	@GetMapping("edit/iteminfo/againstmrn//{itemCode}/{mrnNo}")
	public MRNDetail getItemInfoAgainstMrnEdit(@PathVariable(value = "mrnNo") String mrnCode,
			@PathVariable(value = "itemCode") String itemCode) {

		MRN mrn = mrmService.editMrm(mrnCode).get();
		Item item = itemService.editItem(itemCode).get();

		List<MRNDetail> mrnDetail = mrnDetailRepo.findByMrnAndItem(mrn, item);

		if (mrnDetail.size() > 0) {
			return mrnDetail.get(0);
		}

		return null;

	}

}
