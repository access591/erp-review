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

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.model.master.SubModule;
import com.access.erp.service.ModuleMasterService;

@Controller
@RequestMapping("submodule")
public class SubModuleController {
	
@Autowired ModuleMasterService moduleMasterService;
	
	@GetMapping("/")
	public String subModule(Model model) {
		

		model.addAttribute("subModule", new SubModule());
		return "layouts/Master/subModule";
	}
	
	
	@PostMapping("/")
	public String addSubModule(@ModelAttribute("subModule") SubModule subModule) {
		
		//moduleMasterService.addModule(moduleMaster);
		
		return "redirect:/submodule/";
	}
	
	@GetMapping("/list")
	public String viewModuleList(Model model) {
		
		//List<ModuleMaster> listModule = moduleMasterService.getAllModule();
		
//		if(listModule != null) {
//			model.addAttribute("listModule", listModule);
//		}
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

}

