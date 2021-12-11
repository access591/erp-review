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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.ItemOpening;
import com.access.erp.model.MaterialRequisitionMaster;
import com.access.erp.model.master.Department;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.Store;
import com.access.erp.service.DepartmentService;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.ItemOpeningService;
import com.access.erp.service.ItemService;
import com.access.erp.service.MaterialRequisitionMasterService;
import com.access.erp.service.StoreService;
import com.access.erp.utility.Item_itemOpening;

@Controller
@RequestMapping("/materialrequisition")
public class MaterialRequisitionController {
	
	@Autowired EmployeeService employeeService;
	@Autowired StoreService storeService;
	@Autowired DepartmentService departmentService;
	@Autowired MaterialRequisitionMasterService materialRequisitionMasterService;
	@Autowired ItemService itemService;
	@Autowired ItemOpeningService itemOpeningService;
	
	
	@GetMapping("/")
	public String materialRequisition(Model model) {
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		
		List<Store> storeList = storeService.getAllStore();
		model.addAttribute("storeList", storeList);
		
		List<Item> itemList = itemService.getAllItem();
		model.addAttribute("itemList", itemList);
		
		model.addAttribute("materialRequisition", new MaterialRequisitionMaster());
		return "layouts/Master/materialRequisition";
	}
	
	
	@PostMapping("/")
	public String addMaterialRequisitionMaster(@ModelAttribute("materialRequisition") MaterialRequisitionMaster materialRequisition, RedirectAttributes redirectAttributes) {

		

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
		
		materialRequisitionMasterService.addMaterialRequisitionMaster(materialRequisition);

		return "redirect:/materialrequisition/";
	}

	@GetMapping("/list")
	public String viewMaterialRequisitionList(Model model) {

		List<MaterialRequisitionMaster> listMaterialRequisition = materialRequisitionMasterService.getAllMaterialRequisitionMaster();

		if (listMaterialRequisition != null) {
			model.addAttribute("listMaterialRequisition", listMaterialRequisition);
		}
		return "layouts/listview/listofMaterialRequisition";
	}

	@GetMapping("/edit/{id}")
	public String editMaterialRequisition(@PathVariable("id") String requisitionNo, Model model) {


		MaterialRequisitionMaster materialRequisition = materialRequisitionMasterService.editMaterialRequisitionMaster(requisitionNo).get();
		model.addAttribute("materialRequisition", materialRequisition);

		
		return "layouts/editview/editMaterialRequisition";
	}

	@GetMapping("/delete/{id}")
	public String deleteMaterialRequisition(@PathVariable("id") String requisitionNo, Model model) {
		
		materialRequisitionMasterService.deleteMaterialRequisitionMaster(requisitionNo);
		return "redirect:/materialrequisition/list";
	}
	
	
	
	@GetMapping("/approval")
	public String materialRequisitionApproval( Model model) {
		
		//materialRequisitionMasterService.deleteMaterialRequisitionMaster(requisitionNo);
		return "layouts/Master/materialRequisitionApproval";
	}
	
	
	
	
	
	@ResponseBody
	@GetMapping("/employeeinfo/{id}")
	public Department getDeptByEmp(@PathVariable(value="id") String empCode) {
		
		Employee employee = employeeService.editEmployee(empCode).get();
		
		Department department = new Department();
		
		if(employee.getDepartment()!=null) {
			
			department.setDeptCode(employee.getDepartment().getDeptCode());
			department.setDeptName(employee.getDepartment().getDeptName());
		}
		
		return department;
	}
	
	@ResponseBody
	@GetMapping("/itemInfo/{id}")
	public Item_itemOpening getItemInfo(@PathVariable(value="id") String itemCode) {
		
		Item item = itemService.editItem(itemCode).get();
		ItemOpening itemOpening = itemOpeningService.editItemOpening(itemCode).get();
		
		Item_itemOpening itemItemOpening = new Item_itemOpening();
		itemItemOpening.setItem(item);
		itemItemOpening.setItemOpening(itemOpening);
		return itemItemOpening;
	}

}
