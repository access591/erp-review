package com.access.erp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.access.erp.model.MRN;
import com.access.erp.model.MrnInspection;
import com.access.erp.model.master.Employee;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.MRMService;

@Controller
@RequestMapping("/inspection")
public class MrnInspectionController {
	
	@Autowired MRMService mrmService;
	@Autowired EmployeeService employeeService;

	@GetMapping("/")
	public String inspectionPage(Model model) {
		
		model.addAttribute("inspection", new MrnInspection());
		
		List<MRN> mrmList = mrmService.getAllMrm();
		model.addAttribute("mrmList", mrmList);
		
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		
		return "layouts/Master/mrnInspection";
	}
	
	
	
	@ResponseBody
	@GetMapping("/mrninfo/{id}")
	public MRN mrnInfo(@PathVariable(value = "id") String id, Model model) {

		// GateEntryNumber
		MRN mrn =  mrmService.editMrm(id).get();
		
		return mrn;

	}
}
