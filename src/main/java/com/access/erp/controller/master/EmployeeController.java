package com.access.erp.controller.master;

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

import com.access.erp.model.master.Employee;
import com.access.erp.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired EmployeeService employeeService;
	
	@GetMapping("/")
	public String employee(Model model) {
		
//		List<Employee> employeeList = employeeService.getAllEmployee();
//		model.addAttribute("employeeList", employeeList);
		model.addAttribute("employee", new Employee());
		return "layouts/Master/employee";
	}
	
	@PostMapping("/")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.addEmployee(employee);
		
		return "redirect:/employee/";
	}
	
	@GetMapping("/list")
	public String viewEmployeeList(Model model) {
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		
		if(employeeList != null) {
			model.addAttribute("employeeList", employeeList);
		}
		return "layouts/listview/listofemployee";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") String empCode,Model model) {
		
		Optional<Employee> employee = employeeService.editEmployee(empCode);
		model.addAttribute("employee", employee);
		return "layouts/editview/editEmployee";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCity(@PathVariable("id") String empCode,Model model) {
		employeeService.deleteEmployee(empCode);
		return "redirect:/employee/list";
	}
	
	
	@ResponseBody
	@GetMapping("/employeeinfo/{empCode}")
	public Optional<Employee> getEmployeeInfo(@PathVariable(value = "empCode") String empCode, Model model) {
		
		System.out.println("employee iinfo : "+ empCode);
		Optional<Employee> employee =  employeeService.editEmployee(empCode);
		return employee;
	}

}
