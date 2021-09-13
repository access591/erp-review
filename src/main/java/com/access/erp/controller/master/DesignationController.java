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

import com.access.erp.model.master.Designation;
import com.access.erp.service.DesignationService;

@Controller
@RequestMapping("/designation")
public class DesignationController {
	
	@Autowired DesignationService designationService;
	
	@GetMapping("/")
	public String designation(Model model) {
		

		model.addAttribute("designation", new Designation());
		return "layouts/Master/designation";
	}
	
	@PostMapping("/")
	public String addDesignation(@ModelAttribute("designation") Designation designation) {
		
		designationService.addDesignation(designation);
		
		return "redirect:/designation/";
	}
	
	@GetMapping("/list")
	public String viewDesignationList(Model model) {
		
		List<Designation> designationList = designationService.getAllDesignation();
		
		if(designationList != null) {
			model.addAttribute("designationList", designationList);
		}
		return "layouts/listview/listofdesignation";
	}
	
	@GetMapping("/edit/{id}")
	public String editDesignation(@PathVariable("id") String desigCode,Model model) {
		
		
		System.out.println("module code is : "+ desigCode);
		Optional<Designation> designation = designationService.editDesignation(desigCode);
		model.addAttribute("designation", designation);
		return "layouts/editview/editDesignation";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDesignation(@PathVariable("id") String desigCode,Model model) {
		designationService.deleteDesignation(desigCode);
		return "redirect:/designation/list";
	}

}
