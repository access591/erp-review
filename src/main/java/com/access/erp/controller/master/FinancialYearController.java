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

import com.access.erp.model.master.FinancialYear;
import com.access.erp.service.FinancialYearService;

@Controller
@RequestMapping("/financialyear")
public class FinancialYearController {
	
	@Autowired FinancialYearService financialYearService;
	
	
	
	@GetMapping("/")
	public String financialYear(Model model) {
		
		model.addAttribute("financialYear", new FinancialYear());
		return "layouts/Master/financialyear";
	}
	
	@PostMapping("/")
	public String addFinancialYear(@ModelAttribute("financialYear") FinancialYear financialYear) {
		
		financialYearService.addFinancialYear(financialYear);
		
		return "redirect:/financialyear/";
	}
	
	@GetMapping("/list")
	public String viewFinancialYear(Model model) {
		
		List<FinancialYear> financialYearList = financialYearService.getAllFinancialYear();
		if(financialYearList != null) {
			model.addAttribute("financialYearList", financialYearList);
		}
		return "layouts/listview/listofFinancialyear";
	}
	
	@GetMapping("/edit/{id}")
	public String editFinancialYear(@PathVariable("id") Long id,Model model) {
		
		
		
		Optional<FinancialYear> financialYear = financialYearService.editFinancialYear(id);
		model.addAttribute("financialYear", financialYear);
		return "layouts/editview/editfinancialyear";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteFianncialYear(@PathVariable("id") Long id,Model model) {
		financialYearService.deleteFinancialYear(id);
		return "redirect:/financialyear/list";
	}

}



