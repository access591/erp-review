package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.ItemOpening;
import com.access.erp.model.master.Category;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.MyUser;
import com.access.erp.service.CategoryService;
import com.access.erp.service.ItemOpeningService;
import com.access.erp.service.ItemService;
import com.access.erp.singleton.GlobalParameter;

@Controller
@RequestMapping("/itemopening")
public class ItemOppeningController {

	@Autowired ItemService itemService;
	@Autowired ItemOpeningService itemOpeningService;
	@Autowired CategoryService categoryService;
	
	@Autowired GlobalParameter globalParameter;
	
	
	@GetMapping("/")
	public String itemOpening(Model model) {
		
		List<Item> listItem = itemService.getAllItem();
		model.addAttribute("listItem", listItem);
		
		//List<Category> categoryList = categoryService.getAllCategory();
		//model.addAttribute("categoryList", categoryList);
		
		model.addAttribute("itemOpening", new ItemOpening());
		
		return "layouts/Master/itemOpening";
	}
	
	@PostMapping("/")
	public String addItemOpening(@ModelAttribute("itemOpening") ItemOpening itemOpening,RedirectAttributes redirectAttributes) {

		
		itemOpening.setFinancialYear(globalParameter.getFyYear());
		itemOpening.setMyUser(globalParameter.getMyUser());
		itemOpening.setCompany(globalParameter.getCompany());
		
		itemOpeningService.addItemOpening(itemOpening);
		
		
		
		redirectAttributes.addFlashAttribute("message", "Item-Opening  has been saved successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");

		return "redirect:/itemopening/";
	}

	@GetMapping("/list")
	public String itemOpeningList(Model model) {

		List<ItemOpening> itemOpeningList = itemOpeningService.getAllItemOpening();

		if (itemOpeningList != null) {
			model.addAttribute("itemOpeningList", itemOpeningList);
		}
		return "layouts/listview/listofItemOpening";
	}

	@GetMapping("/edit/{id}")
	public String editItemOpening(@PathVariable("id") String itemOpeningCode, Model model) {

		System.out.println("edit item opening form is running ");
		ItemOpening itemOpening = itemOpeningService.editItemOpening(itemOpeningCode).get();
		model.addAttribute("itemOpening", itemOpening);

		List<Item> listItem = itemService.getAllItem();
		model.addAttribute("listItem", listItem);

		return "layouts/editview/editItemOpening";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteItemOpening(@PathVariable("id") String itemOpeningCode, Model model,RedirectAttributes redirectAttributes) {
		itemOpeningService.deleteItemOpening(itemOpeningCode);
		
		redirectAttributes.addFlashAttribute("message", "Item-opening  has been deleted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		
		return "redirect:/itemopening/list";
	}
	
	
	//GET ITEM DETAIL
	
	@ResponseBody
	@GetMapping("/itemdetail/{id}")
	public Item getItemDetailById(@PathVariable(value = "id") String id) {
		
		Item itemDetail = itemService.editItem(id).get();	
		
		System.out.println("item detail (CAtegory info ): "+ itemDetail.getCategory().getCategCode());
		return itemDetail;

	}

}
