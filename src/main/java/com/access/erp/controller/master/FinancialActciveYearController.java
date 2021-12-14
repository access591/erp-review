
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.service.CompanyService;
import com.access.erp.service.FinancialActiveYearService;
import com.access.erp.service.FinancialYearService;
import com.access.erp.service.MyUserService;

@Controller

@RequestMapping("/financialactiveyear")
public class FinancialActciveYearController {

	@Autowired
	FinancialActiveYearService financialActiveYearService;
	@Autowired MyUserService myUserService;
	@Autowired CompanyService companyService;
	@Autowired FinancialYearService financialYearService;
	
	

	@GetMapping("/")
	public String financialActiveYear(Model model) {

		List<MyUser> listMyUser = myUserService.getAllMyUser();
		model.addAttribute("listMyUser", listMyUser);
		
		List<FinancialYear> listFinancialyear = financialYearService.getAllFinancialYear();
		model.addAttribute("listFinancialyear", listFinancialyear);
		
		
		List<Company> listCompany = companyService.getAllCompany();
		model.addAttribute("listCompany", listCompany);
		
		
		
		model.addAttribute("financialActiveYear", new FinancialActiveYear());
		return "layouts/Master/financialactiveyear";
	}

	@PostMapping("/")
	public String addFinancialActiveYear(
			@ModelAttribute("financialActiveYear") FinancialActiveYear financialActiveYear,RedirectAttributes redirectAttributes) {

		boolean isExist = financialActiveYearService.existsByFinancialYearAndMyUserAndCompany(financialActiveYear.getFinancialYear(), 
							financialActiveYear.getMyUser(), financialActiveYear.getCompany());
		
		System.out.println("isExist value : " + isExist);
		
		if(isExist) {
			
			redirectAttributes.addFlashAttribute("message", "Record  Already Exists!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success"); 
			
			
		}else {
			
			financialActiveYearService.addFinancialActiveYear(financialActiveYear);
			redirectAttributes.addFlashAttribute("message", "Record  has been saved successfully!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success"); 
		}
		
		

		return "redirect:/financialactiveyear/";
	}

	@GetMapping("/list")
	public String viewFinancialActiveYear(Model model) {

		List<FinancialActiveYear> financialActiveYearList = financialActiveYearService.getAllFinancialActiveYear();
		if (financialActiveYearList != null) {
			model.addAttribute("financialActiveYearList", financialActiveYearList);
		}
		return "layouts/listview/listofFinancialActiveyear";
	}

	@GetMapping("/edit/{id}")
	public String editFinancialActiveYear(@PathVariable("id") Long id, Model model) {

		List<MyUser> listMyUser = myUserService.getAllMyUser();
		model.addAttribute("listMyUser", listMyUser);
		
		List<FinancialYear> listFinancialyear = financialYearService.getAllFinancialYear();
		model.addAttribute("listFinancialyear", listFinancialyear); 
		
		
		List<Company> listCompany = companyService.getAllCompany();
		model.addAttribute("listCompany", listCompany);
		
		
		
		FinancialActiveYear financialActiveYear = financialActiveYearService
				.editFinancialActiveYear(id).get();
		model.addAttribute("financialActiveYear", financialActiveYear);
		
		return "layouts/editview/editfinancialActiveyear";
	}

	@GetMapping("/delete/{id}")
	public String deleteFianncialActiveYear(@PathVariable("id") Long id, Model model,RedirectAttributes redirectAttributes) {
		financialActiveYearService.deleteFinanciaActivelYear(id);

		redirectAttributes.addFlashAttribute("message", "Record  has been saved successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		
		return "redirect:/financialactiveyear/list";

	}
	
	
	@PostMapping("/update")
	public String updateFinancialActiveYear(
			@ModelAttribute("financialActiveYear") FinancialActiveYear financialActiveYear,RedirectAttributes redirectAttributes) {
		
		
			financialActiveYearService.addFinancialActiveYear(financialActiveYear);
			redirectAttributes.addFlashAttribute("message", "Record  has been updated successfully!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success"); 
	
		return "redirect:/financialactiveyear/";
	}


}
