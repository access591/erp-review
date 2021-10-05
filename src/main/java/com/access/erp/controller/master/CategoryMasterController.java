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

import com.access.erp.model.master.Category;
import com.access.erp.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryMasterController {
	
	
	@Autowired CategoryService categoryService;
	
	
	@GetMapping("/")
	public String category(Model model) {
		
		model.addAttribute("category", new Category());
		return "layouts/Master/categoryMaster";
	}
	
	@PostMapping("/")
	public String addCategory(@ModelAttribute("category") Category category) {
		
		categoryService.addCategory(category);
		
		return "redirect:/category/";
	}
	
	@GetMapping("/list")
	public String viewCategoryList(Model model) {
		
		List<Category> categoryList = categoryService.getAllCategory();
		
		if(categoryList != null) {
			model.addAttribute("categoryList", categoryList);
		}
		return "layouts/listview/listofcategory";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") String categoryCode,Model model) {
		
		
		Optional<Category> category = categoryService.editCategory(categoryCode);
		model.addAttribute("category", category);
		return "layouts/editview/editCategory";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") String categoryCode,Model model) {
		categoryService.deleteCategory(categoryCode);
		return "redirect:/category/list";
	}

}
