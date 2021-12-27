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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.IssueSlip;
import com.access.erp.model.ItemOpening;
import com.access.erp.model.MaterialRequisitionDetail;
import com.access.erp.model.MaterialRequisitionMaster;
import com.access.erp.model.master.City;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.Department;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.State;
import com.access.erp.model.master.Store;
import com.access.erp.repo.MaterialRequisitionDetailRepo;
import com.access.erp.service.DepartmentService;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.IssueSlipService;
import com.access.erp.service.ItemOpeningService;
import com.access.erp.service.ItemService;
import com.access.erp.service.MaterialRequisitionMasterService;
import com.access.erp.service.StoreService;
import com.access.erp.singleton.GlobalParameter;
import com.access.erp.utility.RequisitionDetailItemOpening;

@Controller
@RequestMapping("/issueslip")
public class IssueSlipController {

	@Autowired EmployeeService employeeService;
	@Autowired DepartmentService departmentService;
	@Autowired IssueSlipService issueSlipService;
	@Autowired MaterialRequisitionMasterService requisitionService;
	@Autowired StoreService storeService;
	@Autowired ItemService itemService;
	@Autowired MaterialRequisitionDetailRepo requisitionDetailRepo;
	@Autowired ItemOpeningService itemOpeningService;
	@Autowired GlobalParameter globalParameter;
	
	
	
	@GetMapping("/")
	public String issueSlip(Model model) {
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		
		List<Department> departmentList = departmentService.getAllDepartment();
		model.addAttribute("departmentList", departmentList);
		
		List<MaterialRequisitionMaster> requisitionMaster = requisitionService.getAllMaterialRequisitionMaster();
		model.addAttribute("requisitionMaster", requisitionMaster);
		
		List<Store> storeList = storeService.getAllStore();
		model.addAttribute("storeList", storeList);
		
		
		model.addAttribute("issueSlip", new IssueSlip());
		return "layouts/Master/issueSlip";
	}
	
	
	@PostMapping("/")
	public String addIssueSlip(@ModelAttribute("issueSlip") IssueSlip issueSlip, RedirectAttributes redirectAttributes) {

		//System.out.println("city code 1: " + company.getcCity().getCityCode());
		//System.out.println("city code 2: " + company.getrCity().getCityCode());

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

		issueSlip.setCompany(globalParameter.getCompany());
		issueSlip.setFycode(globalParameter.getFyYear());
		issueSlip.setMuUser(globalParameter.getMyUser());
		
		issueSlipService.addIssueSlip(issueSlip);
		return "redirect:/issueslip/";
	}

	@GetMapping("/list")
	public String viewIssueSlipList(Model model) {

		List<IssueSlip> listIssueSlip = issueSlipService.getAllIssueSlip();

		if (listIssueSlip != null) {
			model.addAttribute("listIssueSlip", listIssueSlip);
		}
		return "layouts/listview/listofIssueSlip";
	}

	@GetMapping("/edit/{id}")
	public String editIssueSlip(@PathVariable("id") String issueSlipCode, Model model) {

		//System.out.println("company code is : " + compCode);

		

		IssueSlip IssueSlip = issueSlipService.editIssueSlip(issueSlipCode).get();
		model.addAttribute("IssueSlip", IssueSlip);

		//System.out.println("company child info : " + company.getInsuranceDetail().get(0).getCustCode());
		return "layouts/editview/editIssueSlip";
	}

	@GetMapping("/delete/{id}")
	public String deleteIssueSlip(@PathVariable("id") String issueSlipCode, Model model) {
		issueSlipService.deleteIssueSlip(issueSlipCode);
		return "redirect:/issueslip/list";
	}
	
	
	
	//AJAX REQUEST FOR ADD FORM 
	
	@ResponseBody
	@GetMapping("requisitioninfo/{reqNum}")
	public MaterialRequisitionMaster getRequisitionInfo(@PathVariable("reqNum") String reqNum) {
		
		return requisitionService.editMaterialRequisitionMaster(reqNum).get();
	}
	
	@ResponseBody
	@GetMapping("itelist/againstreq/{reqNum}")
	public ArrayList<Item> getItemListAgainstReq(@PathVariable("reqNum") String reqNum) {
		
		MaterialRequisitionMaster requisitionMaster = requisitionService.editMaterialRequisitionMaster(reqNum).get();
		
		ArrayList<Item> itemList = new ArrayList<>();
		for(MaterialRequisitionDetail requisitionDetail : requisitionMaster.getMaterialRequisitionDetails()) {
			
			if(requisitionDetail.getItem()!= null) {
				Item item = itemService.editItem(requisitionDetail.getItem().getItemCode()).get();
				itemList.add(item);
			}
			
		}
		return itemList;
	}

	
	@ResponseBody
	@GetMapping("iteminfo/againstreq/{reqNum}/{itemCode}")
	public RequisitionDetailItemOpening getItemInfoAgainstReq(@PathVariable("reqNum") String reqNum,@PathVariable("itemCode") String itemCode) {
		
		Item item = itemService.editItem(itemCode).get();
		MaterialRequisitionMaster requisitionMaster = requisitionService.editMaterialRequisitionMaster(reqNum).get();
		
		RequisitionDetailItemOpening reqDetailItemOpening = new RequisitionDetailItemOpening();
		
		MaterialRequisitionDetail requisitionDetail = requisitionDetailRepo.findByItemAndMaterialRequisitionMaster(item, requisitionMaster);
		
		ItemOpening itemOpening = itemOpeningService.editItemOpening(itemCode).get();	
		
		reqDetailItemOpening.setItemOpening(itemOpening);
		reqDetailItemOpening.setMaterialRequisitionDetail(requisitionDetail);
		
		return reqDetailItemOpening;
	}
	
	
	@ResponseBody
	@GetMapping("/storelist")
	public List<Store> getStoreList() {
		return storeService.getAllStore();
	}

	
	
}
