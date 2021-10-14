package com.access.erp.controller;

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

import com.access.erp.model.OpenIndent;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.Item;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.ItemService;
import com.access.erp.service.OpenIndentService;

@Controller
@RequestMapping("/openindent")
public class OpenIndentController {

	@Autowired OpenIndentService openIndentService;
	@Autowired EmployeeService employeeService;
	@Autowired ItemService itemService;
	

	@GetMapping("/")
	public String openIndent(Model model) {
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		
		model.addAttribute("openIndent", new OpenIndent());
		
		List<Item> itemList = itemService.getAllItem();
		model.addAttribute("itemList", itemList);
		
		return "layouts/Master/openindent";
	}

	@PostMapping("/")
	public String addOpenIndent(@ModelAttribute("openIndent") OpenIndent openIndent) {

		System.out.println(" testing : " + openIndent.getOpeIndentDetail().get(0).getTotalValue());
		openIndentService.addOpenIndent(openIndent);

		return "redirect:/openindent/";
	}

	@GetMapping("/list")
	public String viewOpenIndentList(Model model) {

		List<OpenIndent> openIndentList = openIndentService.getAllOpenIndent();

		if (openIndentList != null) {
			model.addAttribute("openIndentList", openIndentList);
		}
		return "layouts/listview/listofopenIndent";
	}

	@GetMapping("/edit/{id}")
	public String editOpenIndent(@PathVariable("id") String indentCode, Model model) {

		System.out.println("edit open indent form is running ");
		Optional<OpenIndent> openIndent = openIndentService.editOpenIndent(indentCode);

		openIndent.ifPresent(indent -> model.addAttribute("openIndent", indent));
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);

		return "layouts/editview/editOpenIndent";
	}
	
	@GetMapping("/view/{id}")
	public String viewOpenIndent(@PathVariable("id") String indentCode, Model model) {

		System.out.println("edit open indent form is running ");
		Optional<OpenIndent> openIndent = openIndentService.editOpenIndent(indentCode);

		openIndent.ifPresent(indent -> model.addAttribute("openIndent", indent));
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);

		return "layouts/view/viewOpenIndent";
	}

	

	@GetMapping("/delete/{id}")
	public String deleteOpenIndent(@PathVariable("id") String openIndent, Model model) {
		openIndentService.deleteOpenIndent(openIndent);
		return "redirect:/openindent/list";
	}

	@GetMapping("/approve")
	public String approvePage(Model model) {

		List<OpenIndent> openIndentList = openIndentService.getAllOpenIndent();

		if (openIndentList != null) {
			model.addAttribute("openIndentList", openIndentList);
		}

		return "layouts/Master/openIndentApproval";
	}
	
	
	
	@GetMapping("/approve/{id}/{status}/{level}")
	public String aprroveOpenIndent(@PathVariable("id") String indentNumber,@PathVariable("level") String level
			,@PathVariable("status") String approvalStatus) {
		
		
		System.out.println(" approve id : " + indentNumber);
		System.out.println(" approve level : " + level);
		System.out.println(" approve status : " + approvalStatus);
		
		
		openIndentService.approval(indentNumber, approvalStatus, level);
		
		return "redirect:/openindent/approve";
	}

}
