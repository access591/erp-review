package com.access.erp.controller.master;

import java.util.Calendar;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.master.FinancialYear;
import com.access.erp.repo.FinnancialYearRepo;
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
	public String addFinancialYear(@ModelAttribute("financialYear") FinancialYear financialYear,RedirectAttributes redirectAttributes) {
		
		String lastDigitFromDat = financialYear.getFromDate().toString().substring(26);
		String lastDigitToDate = financialYear.getToDate().toString().substring(26);
		System.out.println(" date is : " + lastDigitFromDat);
		System.out.println(" date is : " + lastDigitToDate);
		
		//String lastDigitFromDate = financialYear.getFromDate().substring(Math.max(financialYear.getFromDate().length() - 2, 0));
		
		//String lastDigitToDate = financialYear.getToDate().substring(Math.max(financialYear.getToDate().length() - 2, 0));
		
		
		financialYear.setFinancialYearCode(lastDigitFromDat+"-"+lastDigitToDate);
		
		boolean fYear = financialYearService.isFinancialYearExists(financialYear.getFinancialYearCode());
		System.out.println("fyear is : "+ fYear);
		
		if(fYear == false) {
			financialYearService.addFinancialYear(financialYear);
			redirectAttributes.addFlashAttribute("message", "Record  has been saved successfully!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		}
		else {
			redirectAttributes.addFlashAttribute("message", "Financial Year Already Exists..");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		}
		
		
		
		
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
	public String editFinancialYear(@PathVariable("id") String id,Model model) {
		
		
		
		Optional<FinancialYear> financialYear = financialYearService.editFinancialYear(id);
		model.addAttribute("financialYear", financialYear);
		return "layouts/editview/editfinancialyear";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteFianncialYear(@PathVariable("id") String id,Model model) {
		financialYearService.deleteFinancialYear(id);
		return "redirect:/financialyear/list";
	}

}



