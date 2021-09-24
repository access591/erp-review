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

import com.access.erp.model.master.Item;
import com.access.erp.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired ItemService itemService;
	
	@GetMapping("/")
	public String item(Model model) {
		
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
		return "layouts/listview/listofItem";
	}
	
	@GetMapping("/edit/{id}")
	public String editItem(@PathVariable("id") String itemCode,Model model) {
		
		System.out.println("module code is : "+ itemCode);
		
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