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

import com.access.erp.model.OpenIndent;
import com.access.erp.model.master.Category;
import com.access.erp.model.master.City;
import com.access.erp.model.master.Country;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.State;
import com.access.erp.service.CityService;
import com.access.erp.service.CountryService;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.PartyMasterService;
import com.access.erp.service.StateService;
import com.access.erp.singleton.GlobalParameter;

@Controller
@RequestMapping("/party")
public class PartyMasterController {
	
	@Autowired CityService cityService;
	@Autowired StateService stateService;
	@Autowired CountryService countryService;
	
	@Autowired EmployeeService employeeService;
	@Autowired PartyMasterService partyMasterService;
	@Autowired GlobalParameter globalParameter;
	
	
	
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
	
	
	@PostMapping("/")
	public String addPartyMaster(@ModelAttribute("partyMaster") PartyMaster partyMaster) {

		System.out.println(" partyMaster : " );
		
		partyMaster.setcCode(globalParameter.getGlobalCompany());
		partyMasterService.addPartyMaster(partyMaster);

		return "redirect:/party/";
	}
	
	
	@GetMapping("/list")
	public String viewPartyList(Model model) {
		
		List<PartyMaster> partyList = partyMasterService.getAllpartyMaster();
		
		if(partyList != null) {
			model.addAttribute("partyList", partyList);
		}
		return "layouts/listview/listofParty";
	}
	
	@GetMapping("/edit/{id}")
	public String editParty(@PathVariable("id") String partyCode,Model model) {
		
		List<City> listCity = cityService.getAllCity();
		model.addAttribute("listCity", listCity);
		
		List<State> listState = stateService.getAllState();
		model.addAttribute("listState", listState);
		
		List<Country> listCountry = countryService.getAllCountry();
		model.addAttribute("listCountry", listCountry);
		
		List<Employee> listEmployee = employeeService.getAllEmployee();
		model.addAttribute("listEmployee", listEmployee);
		
		
		PartyMaster party = partyMasterService.editPartyMaster(partyCode).get();
		model.addAttribute("partyMaster", party);
		return "layouts/editview/editParty";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteParty(@PathVariable("id") String partyCode,Model model,RedirectAttributes redirectAttributes) {
		partyMasterService.deletePartyMaster(partyCode);
		
		redirectAttributes.addFlashAttribute("message", "Category  has been deleted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success"); 
		
		return "redirect:/party/list";
	}

}
