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

import com.access.erp.model.master.Country;
import com.access.erp.model.master.State;
import com.access.erp.service.CountryService;
import com.access.erp.service.StateService;

@Controller
@RequestMapping("/state")
public class StateController {
	
	@Autowired StateService stateService;
	@Autowired CountryService countryService;
	
	@GetMapping("/")
	public String state(Model model) {
		
		List<Country> countryList = countryService.getAllCountry();
		model.addAttribute("countryList", countryList);
		model.addAttribute("state", new State());
		return "layouts/Master/state";
	}
	
	@PostMapping("/")
	public String addState(@ModelAttribute("state") State state) {
		
		stateService.addState(state);
		
		return "redirect:/state/";
	}
	
	@GetMapping("/list")
	public String viewStateList(Model model) {
		
		List<State> stateList = stateService.getAllState();
		
		if(stateList != null) {
			model.addAttribute("stateList", stateList);
		}
		return "layouts/listview/listofstate";
	}
	
	@GetMapping("/edit/{id}")
	public String editState(@PathVariable("id") String stateCode,Model model) {
		
		
		System.out.println("module code is : "+ stateCode);
		List<Country> countryList = countryService.getAllCountry();
		model.addAttribute("countryList", countryList);
		Optional<State> state = stateService.editState(stateCode);
		model.addAttribute("state", state);
		return "layouts/editview/editState";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteState(@PathVariable("id") String stateCode,Model model) {
		stateService.deleteState(stateCode);
		return "redirect:/state/list";
	}

}
