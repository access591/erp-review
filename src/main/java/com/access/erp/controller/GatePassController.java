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

import com.access.erp.model.GatePass;
import com.access.erp.model.master.Department;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.GatePassRepo;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.DepartmentService;
import com.access.erp.service.EmployeeService;

@Controller
@RequestMapping("/gatepass")
public class GatePassController {
	
	@Autowired EmployeeService employeeService;
	@Autowired DepartmentService departmentService;
	@Autowired SupplierRepo supplierRepo;
	@Autowired GatePassRepo gatePassRepo;
	
	@GetMapping("/")
	public String gatePass(Model model) {
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		
		List<Department> departmentList = departmentService.getAllDepartment();
		model.addAttribute("departmentList", departmentList);
		
		List<SupplierMaster> supplierList = supplierRepo.findAll();
		model.addAttribute("supplierList", supplierList);
		
				
		model.addAttribute("gatePass", new GatePass());
		return "layouts/Master/gatePass";
		
		
	}
	
	@PostMapping("/")
	public String addGatePass(@ModelAttribute("gatePass") GatePass gatePass) {

		System.out.println(" testing : ");
		gatePassRepo.save(gatePass);

		return "redirect:/gatepass/";
	}

	@GetMapping("/list")
	public String viewGatePassList(Model model) {

		List<GatePass> gatePassList = gatePassRepo.findAll();
		if (gatePassList != null) {
			model.addAttribute("gatePassList", gatePassList);
		}
		return "layouts/listview/listofGatePass";
	}

	@GetMapping("/edit/{id}")
	public String editGatePass(@PathVariable("id") String gatePassNo, Model model) {

		System.out.println("edit gate pass form is running ");
		GatePass gatePass = gatePassRepo.findById(gatePassNo).get();

	
		model.addAttribute("gatePass", gatePass);

		return "layouts/editview/editGatePass";
	}
	
	

	@GetMapping("/delete/{id}")
	public String deleteGatePass(@PathVariable("id") String gatePassNo, Model model) {
		gatePassRepo.deleteById(gatePassNo);
		return "redirect:/gatepass/list";
	}

}
