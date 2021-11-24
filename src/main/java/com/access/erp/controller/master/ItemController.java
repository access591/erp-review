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
import com.access.erp.model.master.Item;
import com.access.erp.model.master.Store;
import com.access.erp.model.master.UOM;
import com.access.erp.service.CategoryService;
import com.access.erp.service.ItemService;
import com.access.erp.service.StoreService;
import com.access.erp.service.UOMService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired ItemService itemService;
	@Autowired UOMService uomService;
	@Autowired StoreService storeService;
	@Autowired CategoryService categoryService;
	
	
	@GetMapping("/")
	public String item(Model model) {
		
		List<UOM> listUom = uomService.getAllUOM();
		model.addAttribute("listUom", listUom);
		
		List<Store> listStore = storeService.getAllStore();
		model.addAttribute("listStore", listStore);
		
		List<Category> listcategory = categoryService.getAllCategory();
		model.addAttribute("listCategory",listcategory);
		
		model.addAttribute("item", new Item());
		return "layouts/Master/itemMaster";
	}
	
	@PostMapping("/")
	public String addItem(@ModelAttribute("item") Item item) {
		
		
		itemService.addItem(item);
		return "redirect:/item/";
	}
	
	@GetMapping("/list")
	public String viewItemList(Model model) {
		
		List<Item> itemList = itemService.getAllItem();
		
	
		
		if(itemList != null) {
			model.addAttribute("itemList", itemList);
		}
		return "layouts/listview/listofitem";
	}
	
	@GetMapping("/edit/{id}")
	public String editItem(@PathVariable("id") String itemCode,Model model) {
		
		System.out.println("module code is : "+ itemCode);
		
		List<UOM> listUom = uomService.getAllUOM();
		model.addAttribute("listUom", listUom);
		
		List<Store> listStore = storeService.getAllStore();
		model.addAttribute("listStore", listStore);
		
		List<Category> listcategory = categoryService.getAllCategory();
		model.addAttribute("listCategory",listcategory);
		
		Optional<Item> item = itemService.editItem(itemCode);
		
		item.ifPresent(i -> model.addAttribute("item", i));
		
		return "layouts/editview/editItem";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") String itemCode,Model model) {
		itemService.deleteItem(itemCode);
		return "redirect:/item/list";
	}

}