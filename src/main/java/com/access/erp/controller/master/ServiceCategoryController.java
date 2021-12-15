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

import com.access.erp.model.master.ServiceCategory;
import com.access.erp.service.ServiceCategoryMasterService;

@Controller
@RequestMapping("/servicecategory")
public class ServiceCategoryController {

	@Autowired ServiceCategoryMasterService serviceCategoryService;
	
	@GetMapping("/")
	public String serviceCategory(Model model) {
		
		model.addAttribute("serviceCategory", new ServiceCategory());
		return "layouts/Master/serviceCategory";
	}
	
	@PostMapping("/")
	public String addServiceCategory(@ModelAttribute("servicecategory") ServiceCategory servicecategory,Principal principal) {
		
		
		servicecategory.setInsertedBy(principal.getName());
		servicecategory.setInsertedDate(new Date());
		
		servicecategory.setuCode("EB");
		serviceCategoryService.addServiceCategory(servicecategory);
		
		return "redirect:/servicecategory/";
	}
	
	@GetMapping("/list")
	public String viewServiceCategoryList(Model model) {
		
		List<ServiceCategory> serviceCategoryList = serviceCategoryService.getAllServiceCategory();
		
		if(serviceCategoryList != null) {
			model.addAttribute("serviceCategoryList", serviceCategoryList);
		}
		return "layouts/listview/listofserviceCategory";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategoryService(@PathVariable("id") String serviceCategoryCode,Model model) {
		
		System.out.println("module code is : "+ serviceCategoryCode);
		
		
		Optional<ServiceCategory> servicecategory = serviceCategoryService.editServiceCategory(serviceCategoryCode);
		model.addAttribute("serviceCategory", servicecategory);
		return "layouts/editview/editServiceCategory";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategoryService(@PathVariable("id") String serviceCategoryCode,Model model) {
		serviceCategoryService.deleteServiceCategory(serviceCategoryCode);
		return "redirect:/servicecategory/list";
	}
	
	@PostMapping("/update")
	public String updateServiceCategory(@ModelAttribute("servicecategory") ServiceCategory servicecategory,Principal principal) {
		
		
		servicecategory.setUpdateBy(principal.getName());
		servicecategory.setUpdatedDate(new Date());
		serviceCategoryService.addServiceCategory(servicecategory);
		
		return "redirect:/servicecategory/";
	}

}