package com.access.erp.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.master.City;
import com.access.erp.model.master.Country;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.State;
import com.access.erp.service.CityService;
import com.access.erp.service.CountryService;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.StateService;

@Controller
@RequestMapping("/party")
public class PartyMasterController {
	
	@Autowired CityService cityService;
	@Autowired StateService stateService;
	@Autowired CountryService countryService;
	
	@Autowired EmployeeService employeeService;
	
	
	
	@GetMapping("/")
	public String party(Model model) {
		
		List<City> listCity = cityService.getAllCity();
		model.addAttribute("listCity", listCity);
		
		List<State> listState = stateService.getAllState();
		model.addAttribute("listState", listState);
		
		List<Country> listCountry = countryService.getAllCountry();
		model.addAttribute("listCountry", listCountry);
		
		List<Employee> listEmployee = employeeService.getAllEmployee();
		model.addAttribute("listEmployee", listEmployee);
		
		
		
		
		model.addAttribute("partyMaster", new PartyMaster());
		return "layouts/Master/partyMaster";
	}

}
