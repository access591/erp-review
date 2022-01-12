package com.access.erp.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.master.Category;
import com.access.erp.model.master.Unit;
import com.access.erp.service.UnitService;
import com.access.erp.singleton.GlobalParameter;

@Controller
@RequestMapping("/unit")
public class UnitController {

	@Autowired UnitService unitService;
	
	@Autowired GlobalParameter globalParameter;
	
	
	
	@GetMapping("/")
	public String unit(Model model) {
		
		model.addAttribute("unit", new Unit());
		return"layouts/Master/unitMaster";
	}
	
	@PostMapping("/")
	public String addUnitMaster(@ModelAttribute("unit") Unit unit,RedirectAttributes redirectAttributes) {
		
		
		
		System.out.println("testing : " + unit.getUnitDesc());
		
		System.out.println("pricipal : ");
		
		unit.setCompany(globalParameter.getCompany());
		
		unitService.addUnit(unit);
		redirectAttributes.addFlashAttribute("message", "Submitted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		
		//redirect:/category/
		return"redirect:/unit/";
		
	}
	
	
	@GetMapping("/list")
	public String viewUnitList(Model model) {
		System.out.println("unit list ");
		List<Unit> unitList =unitService.getAllUnit();
		if(unitList != null)
			model.addAttribute("unitList",unitList);
		return"layouts/listview/listofunit";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editUnit(@PathVariable("id") String unitCode,Model model) {
	
		System.out.println("edit controller");
	Optional<Unit>unit = unitService.editUnit(unitCode);
	model.addAttribute("unit",unit);
	return"layouts/editview/editUnit";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUnit(@PathVariable("id")  String unitCode,Model model ) {
		
		System.out.println("delete button...");
		unitService.deleteUnit(unitCode);
		
		return"redirect:/unit/list";
	}
	
	
	@PostMapping("/update")
	public String updateUnitMaster(@ModelAttribute("unit") Unit unit,RedirectAttributes redirectAttributes,Principal principal) {
		
		
		
		System.out.println("testing : " + unit.getUnitDesc());
		
		System.out.println("pricipal : ");
		
		unit.setUpdateBy(principal.getName());
		unit.setUpdatedDate(new Date());
		
		unitService.addUnit(unit);
		redirectAttributes.addFlashAttribute("message", "Updated successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		
		//redirect:/category/
		return"redirect:/unit/";
		
	}
	
	
	
}
