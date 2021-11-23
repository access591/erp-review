package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.GatePass;
import com.access.erp.model.master.Department;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.DepartmentService;
import com.access.erp.service.EmployeeService;

@Controller
@RequestMapping("/gatepass")
public class GatePassController {
	
	@Autowired EmployeeService employeeService;
	@Autowired DepartmentService departmentService;
	@Autowired SupplierRepo supplierRepo;
	
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

}
