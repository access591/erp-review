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
import com.access.erp.model.master.SubModuleMaster;
import com.access.erp.service.ModuleMasterService;
import com.access.erp.service.SubModuleMasterService;

@Controller
@RequestMapping("/sub-module")
public class SubModuleController {

	@Autowired
	SubModuleMasterService subModuleMasterService;
	@Autowired ModuleMasterService moduleService;

	@GetMapping("/")
	public String subModule(Model model) {

		List<ModuleMaster> moduleList = moduleService.getAllModule();
		model.addAttribute("moduleList", moduleList);
		
		model.addAttribute("subModule", new SubModuleMaster());
		return "layouts/Master/subModule";
	}

	@PostMapping("/")
	public String addSubModule(@ModelAttribute("subModule") SubModuleMaster subModule,Principal principal) {

		
		subModule.setInsertedBySubModule(principal.getName());
		subModule.setInsertedDateSubModule(new Date());
		 subModuleMasterService.addSubModule(subModule);

		return "redirect:/sub-module/";
	}

	@GetMapping("/list")
	public String viewSubModuleList(Model model) {

		 List<SubModuleMaster> listSubModule = subModuleMasterService.getAllSubModule();

		if(listSubModule != null) {
			model.addAttribute("listSubModule", listSubModule);
		}
		return "layouts/listview/listofsubmodule";
	}

	@GetMapping("/edit/{id}")
	public String editSubModule(@PathVariable("id") String subModuleCode, Model model) {

		System.out.println("module code is : " + subModuleCode);
		List<ModuleMaster> moduleList = moduleService.getAllModule();
		model.addAttribute("moduleList", moduleList);
		Optional<SubModuleMaster> subModule = subModuleMasterService.editSubModule(subModuleCode);
		model.addAttribute("subModule", subModule);
		return "layouts/editview/editSubModule";
	}

	@GetMapping("/delete/{id}")
	public String deleteSubModule(@PathVariable("id") String subModuleCode, Model model) {
		subModuleMasterService.deleteSubModuleMaster(subModuleCode);
		return "redirect:/sub-module/list";
	}
	
	@PostMapping("/update")
	public String updateSubModule(@ModelAttribute("subModule") SubModuleMaster subModule,Principal principal) {

		
		subModule.setUpdateBySubModule(principal.getName());
		subModule.setUpdatedDateSubModule(new Date());
		 subModuleMasterService.addSubModule(subModule);

		return "redirect:/sub-module/";
	}

}
