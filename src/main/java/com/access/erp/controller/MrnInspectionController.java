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

import com.access.erp.model.MRN;
import com.access.erp.model.MrnInspection;
import com.access.erp.model.master.Employee;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.MRMService;
import com.access.erp.service.MrnInspectionService;

@Controller
@RequestMapping("/inspection")
public class MrnInspectionController {
	
	@Autowired MRMService mrmService;
	@Autowired EmployeeService employeeService;
	@Autowired MrnInspectionService mrnInspectionService;
	

	@GetMapping("/")
	public String inspectionPage(Model model) {
		
		model.addAttribute("inspection", new MrnInspection());
		
		List<MRN> mrmList = mrmService.getAllMrm();
		model.addAttribute("mrmList", mrmList);
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		
		return "layouts/Master/mrnInspection";
	}
	
	
	@PostMapping("/")
	public String addInspection(@ModelAttribute("inspection") MrnInspection inspection, RedirectAttributes redirectAttributes) {

		

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

		return "redirect:/inspection/";
	}

	@GetMapping("/list")
	public String viewInspectionList(Model model) {

		List<MrnInspection> listInspection = mrnInspectionService.getAllMrnInspection();

		if (listInspection != null) {
			model.addAttribute("listInspection", listInspection);
		}
		return "layouts/listview/listofInspection";
	}

	@GetMapping("/edit/{id}")
	public String editInspection(@PathVariable("id") String inspCode, Model model) {

		System.out.println("company code is : " + inspCode);

		List<MRN> mrmList = mrmService.getAllMrm();
		model.addAttribute("mrmList", mrmList);
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		
		MrnInspection inspection = mrnInspectionService.editMrnInspection(inspCode).get();
		model.addAttribute("inspection", inspection);

		
		return "layouts/editview/editInspection";
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
	
	
	
	@ResponseBody
	@GetMapping("/mrninfo/{id}")
	public MRN mrnInfo(@PathVariable(value = "id") String id, Model model) {

		// GateEntryNumber
		MRN mrn =  mrmService.editMrm(id).get();
		
		return mrn;

	}
}
