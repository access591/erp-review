package com.access.erp.controller.master;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.access.erp.model.master.Department;
import com.access.erp.model.master.Designation;
import com.access.erp.model.master.Employee;
import com.access.erp.service.DepartmentService;
import com.access.erp.service.DesignationService;
import com.access.erp.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired EmployeeService employeeService;
	@Autowired DepartmentService departmentService;
	
	@Autowired DesignationService designationService;
	
	
	//@GetMapping("/")
	public String employee(Model model) {
		
//		List<Employee> employeeList = employeeService.getAllEmployee();
//		model.addAttribute("employeeList", employeeList);
		model.addAttribute("employee", new Employee());
		return "layouts/Master/employee";
	}
	
	//@ModelAttribute("employee") Employee employee
	
	@GetMapping("/add")
	public String addEmployee() {
		
		Employee employee = new Employee();
		
		employee.setEmpCode("EMP-101");
		employee.setEmpName("Admin");
		employee.setEmpType('E');
		employee.setBirthPlace("UK");
		employee.setSex("M");
		employee.setMaritalStatus('M');
		employee.setHeight(5);
		employee.setIdMark("ID Mark");
		employee.setCaste("caste");
		employee.setPermAdd1("Address 1");
		employee.setPermAdd2("Address-2");
		employee.setPermCity("UK");
		employee.setPermPin(21212);
		employee.setPermState("UK");
		employee.setLocalAdd1("local add 2");
		employee.setLocalAdd2("local add1");
		employee.setLocalCity("city");
		employee.setLocalPhone("8989989");
		employee.setLocalPin(121212);
		employee.setLocalState("state");
		employee.setLocalPin(2122323);
		employee.setLocation("location");
		employee.setActive("Y");
		employee.setStatusDate(new Date());
		employee.setMobilePhone("34343434");
		employee.setDob(new Date());
		employee.setDoj(new Date());
		
		//Designation d = new Designation();
		//d.setDesigCode("D-001");
		List<Department> listDepartment = departmentService.getAllDepartment();
		List<Designation> listDesigNation = designationService.getAllDesignation();
		
		
		//Department dp = new Department();
		//dp.setDeptCode("DEP-002");
		
		//employee.setDepartment(listDepartment.get(0));
		//employee.setDesignation(listDesigNation.get(0));
		
		employeeService.addEmployee(employee);
		
		//return "redirect:/employee/";
		return null;
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
		
		Employee employee = employeeService.editEmployee(empCode).get();
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
	public Employee getEmployeeInfo(@PathVariable(value = "empCode") String empCode, Model model) {
		
		System.out.println("employee iinfo : "+ empCode);
		Employee employee =  employeeService.findEmployeeById(empCode);
		return employee;
		
		
	}

}
