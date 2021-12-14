package com.access.erp.controller.master;

import java.security.Principal;
import java.util.Date;
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


import com.access.erp.model.master.Country;
import com.access.erp.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {
	
	@Autowired CountryService countryService;
	
	@GetMapping("/")
	public String country(Model model) {
		

		model.addAttribute("country", new Country());
		return "layouts/Master/country";
	}
	
	@PostMapping("/")
	public String addCountry(@ModelAttribute("country") Country country,Principal principal) {
		
		country.setInsertedBy(principal.getName());
		country.setInsertedDate(new Date());
		
		countryService.addCountry(country);
		
		return "redirect:/country/";
	}
	
	@GetMapping("/list")
	public String viewCountryList(Model model) {
		
		List<Country> countryList = countryService.getAllCountry();
		
		if(countryList != null) {
			model.addAttribute("countryList", countryList);
		}
		return "layouts/listview/listofcountry";
	}
	
	@GetMapping("/edit/{id}")
	public String editCountry(@PathVariable("id") String countryCode,Model model) {
		
		
		System.out.println("module code is : "+ countryCode);
		Optional<Country> country = countryService.editCountry(countryCode);
		model.addAttribute("country", country);
		return "layouts/editview/editCountry";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCountry(@PathVariable("id") String countryCode,Model model) {
		countryService.deleteCountry(countryCode);
		return "redirect:/country/list";
	}
	
	@PostMapping("/update")
	public String updateCountry(@ModelAttribute("country") Country country,Principal principal) {
		
		country.setUpdateBy(principal.getName());
		country.setUpdatedDate(new Date());
		countryService.addCountry(country);
		
		return "redirect:/country/";
	}
	

}
