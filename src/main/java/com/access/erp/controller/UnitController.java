package com.access.erp.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.master.Unit;
import com.access.erp.service.UnitService;
import com.access.erp.singleton.GlobalParameter;

@Controller
public class UnitController {

	@Autowired UnitService unitService;
	
	@Autowired GlobalParameter globalParameter;
	
	
	
	@GetMapping("/unit")
	public String unit(Model model) {
		
		model.addAttribute("unit", new Unit());
		return"layouts/Master/unitMaster";
	}
	
	@PostMapping("addunit")
	public String addUnitMaster(@ModelAttribute("unit") Unit unit,RedirectAttributes redirectAttributes) {
		
		
		
		System.out.println("testing : " + unit.getUnitDesc());
		
		System.out.println("pricipal : ");
		
		unit.setCompany(globalParameter.getCompany());
		
		unitService.addUnit(unit);
		//redirect:/category/
		return"redirect:/unit";
		
	}
	
	
	@GetMapping("/unitList")
	public String viewUnitList(Model model) {
		System.out.println("unit list ");
		List<Unit> unitList =unitService.getAllUnit();
		if(unitList != null)
			model.addAttribute("unitList",unitList);
		return"layouts/listview/listofunit";
	}
	
	
	
	
}
