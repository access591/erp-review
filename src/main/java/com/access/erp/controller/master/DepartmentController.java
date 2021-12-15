package com.access.erp.controller.master;

import java.security.Principal;
import java.util.Date;
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

import com.access.erp.model.master.Department;
import com.access.erp.service.DepartmentService;


@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired DepartmentService departmentService;

	@GetMapping("/")
	public String department(Model model) {
		

		model.addAttribute("department", new Department());
		return "layouts/Master/department";
	}
	
	@PostMapping("/")
	public String addDepartment(@ModelAttribute("department") Department department,Principal principal) {
		
		System.out.println("add deepartmet methiod");
		
		department.setInsertedBy(principal.getName());
		department.setInsertedDate(new Date());
		departmentService.addDepartment(department);
		
		return "redirect:/department/";
	}
	
	@GetMapping("/list")
	public String viewDepartmentList(Model model) {
		
		List<Department> departmentList = departmentService.getAllDepartment();
		
		if(departmentList != null) {
			model.addAttribute("departmentList", departmentList);
		}
		return "layouts/listview/listofdepartment";
	}
	
	@GetMapping("/edit/{id}")
	public String editDepartment(@PathVariable("id") String deptCode,Model model) {
		
		
		System.out.println("module code is : "+ deptCode);
		Optional<Department> department = departmentService.editDepartment(deptCode);
		model.addAttribute("department", department);
		return "layouts/editview/editDepartment";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") String deptCode,Model model) {
		departmentService.deleteDepartment(deptCode);
		return "redirect:/department/list";
	}
	
	@PostMapping("/update")
	public String updateDepartment(@ModelAttribute("department") Department department,Principal principal) {
		
		System.out.println("add deepartmet methiod");
		
		department.setUpdateBy(principal.getName());
		department.setUpdatedDate(new Date());
		
		departmentService.addDepartment(department);
		
		return "redirect:/department/";
	}

}

