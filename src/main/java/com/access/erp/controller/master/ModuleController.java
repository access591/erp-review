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

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.service.ModuleMasterService;

@Controller
@RequestMapping("/module")
public class ModuleController {
	
	@Autowired ModuleMasterService moduleMasterService;
	
	@GetMapping("/")
	public String module(Model model) {
		

		model.addAttribute("module", new ModuleMaster());
		return "layouts/Master/moduleMaster";
	}
	
	@PostMapping("/")
	public String addModule(@ModelAttribute("module") ModuleMaster moduleMaster,Principal principal) {
		
		
		moduleMaster.setInsertedBy(principal.getName());
		moduleMaster.setInsertedDate(new Date());
		moduleMasterService.addModule(moduleMaster);
		
		return "redirect:/module/";
	}
	
	@GetMapping("/list")
	public String viewModuleList(Model model) {
		
		List<ModuleMaster> listModule = moduleMasterService.getAllModule();
		
		if(listModule != null) {
			model.addAttribute("listModule", listModule);
		}
		return "layouts/listview/listofmodulemaster";
	}
	
	@GetMapping("/edit/{id}")
	public String editModule(@PathVariable("id") String moduleCode,Model model) {
		
		
		System.out.println("module code is : "+ moduleCode);
		Optional<ModuleMaster> module = moduleMasterService.editModule(moduleCode);
		model.addAttribute("module", module);
		return "layouts/editview/editModule";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteModule(@PathVariable("id") String moduleCode,Model model) {
		moduleMasterService.deleteModuleMaster(moduleCode);
		return "redirect:/module/list";
	}
	
	
	@PostMapping("/update")
	public String updateModule(@ModelAttribute("module") ModuleMaster moduleMaster,Principal principal) {
		
		
		moduleMaster.setUpdateBy(principal.getName());
		moduleMasterService.addModule(moduleMaster);
		
		return "redirect:/module/";
	}

}
