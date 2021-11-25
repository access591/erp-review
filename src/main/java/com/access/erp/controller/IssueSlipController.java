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

import com.access.erp.model.IssueSlip;
import com.access.erp.model.master.City;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.Department;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.State;
import com.access.erp.service.DepartmentService;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.IssueSlipService;

@Controller
@RequestMapping("/issuslip")
public class IssueSlipController {

	@Autowired EmployeeService employeeService;
	@Autowired DepartmentService departmentService;
	@Autowired IssueSlipService issueSlipService;
	
	
	@GetMapping("/")
	public String issueSlip(Model model) {
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		
		List<Department> departmentList = departmentService.getAllDepartment();
		model.addAttribute("departmentList", departmentList);
		
		
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

		return "redirect:/issuslip/";
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
		return "redirect:/issuslip/list";
	}

	
	
}
