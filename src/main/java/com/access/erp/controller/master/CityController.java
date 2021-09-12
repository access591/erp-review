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

import com.access.erp.model.master.City;
import com.access.erp.model.master.ModuleMaster;
import com.access.erp.service.ModuleMasterService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired ModuleMasterService moduleMasterService;
	
	@GetMapping("/")
	public String city(Model model) {
		

		model.addAttribute("city", new City());
		return "layouts/Master/cityMaster";
	}
	
	@PostMapping("/")
	public String addCity(@ModelAttribute("city") City city) {
		
//		moduleMasterService.addModule(moduleMaster);
		
		return "redirect:/city/";
	}
	
	@GetMapping("/list")
	public String viewCityList(Model model) {
		
		List<ModuleMaster> cityList = moduleMasterService.getAllModule();
		
		if(cityList != null) {
			model.addAttribute("cityList", cityList);
		}
		return "layouts/listview/listofcity";
	}
	
	@GetMapping("/edit/{id}")
	public String editCity(@PathVariable("id") String cityCode,Model model) {
		
		
		System.out.println("module code is : "+ cityCode);
		Optional<ModuleMaster> city = moduleMasterService.editModule(cityCode);
		model.addAttribute("city", city);
		return "layouts/editview/editCity";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCity(@PathVariable("id") String cityCode,Model model) {
//		moduleMasterService.deleteModuleMaster(moduleCode);
		return "redirect:/city/list";
	}

}
