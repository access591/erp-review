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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.master.Category;
import com.access.erp.model.master.SubCategory;
import com.access.erp.service.CategoryService;
import com.access.erp.service.SubCategoryMasterService;
import com.access.erp.singleton.GlobalParameter;

@Controller
@RequestMapping("/subcategory")
public class SubCategoryController {

	@Autowired SubCategoryMasterService subCategoryService;
	@Autowired GlobalParameter globalParameter;
	@Autowired CategoryService categoryService;
	@Autowired SubCategoryMasterService subcategoryService;
	
	@GetMapping("/")
	public String subCategory(Model model) {
		
		model.addAttribute("subCategory", new SubCategory());
		
		List<Category> catgoryList = categoryService.getAllCategory();
		model.addAttribute("categoryList", catgoryList);
		
		return "layouts/Master/subCategory";
	}
	
	@PostMapping("/")
	public String addSubCategory(@ModelAttribute("subcategory") SubCategory subcategory,Principal principal,RedirectAttributes redirectAttributes) {
		
		System.out.println("testinh : " + subcategory.getSubCategoryDesc());
		
		  subcategory.setInsertedBy(principal.getName());
		  subcategory.setInsertedDate(new Date());
		 	
		subcategory.setMyuser(globalParameter.getMyUser());
	
		subcategoryService.addServiceCategory(subcategory);
		redirectAttributes.addFlashAttribute("message", "Submitted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		
		
		return "redirect:/subcategory/";
	}
	
	@GetMapping("/list")
	public String viewSubCategoryList(Model model) {
		System.out.println("subCategoryList");

		List<SubCategory> subCategoryList = subCategoryService.getAllServiceCategory();
		
		if(subCategoryList != null) {
			
			
			model.addAttribute("subCategoryList", subCategoryList);
			
		}
		return "layouts/listview/listofsubCategory";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategoryService(@PathVariable("id") String subCategoryCode,Model model,RedirectAttributes redirectAttributes) {
		
		System.out.println("module code is : "+ subCategoryCode);
		
		List<Category> catgoryList = categoryService.getAllCategory();
		model.addAttribute("categoryList", catgoryList);
		
		SubCategory subcategory = subCategoryService.editSubCategory(subCategoryCode).get();
		model.addAttribute("subCategory", subcategory);
		redirectAttributes.addFlashAttribute("message", "Submitted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "layouts/editview/editSubCategory";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategoryService(@PathVariable("id") String subCategoryCode,Model model,RedirectAttributes redirectAttributes) {
		subCategoryService.deleteSubCategory(subCategoryCode);
		redirectAttributes.addFlashAttribute("message", "deleted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success"); 
		return "redirect:/subcategory/list";
	}
	
	@PostMapping("/update")
	public String updateSaveCategory(@ModelAttribute("subcategory") SubCategory subcategory,Principal principal,RedirectAttributes redirectAttributes) {
		
		
		subcategory.setUpdateBy(principal.getName());
		subcategory.setUpdatedDate(new Date());
		
		subcategoryService.addServiceCategory(subcategory);
		redirectAttributes.addFlashAttribute("message", "updated successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success"); 
		return "redirect:/subcategory/";
	}

}