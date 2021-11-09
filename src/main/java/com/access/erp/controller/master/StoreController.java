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

import com.access.erp.model.master.Store;
import com.access.erp.service.StoreService;


@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired StoreService storeService;
	
	
	@GetMapping("/")
	public String store(Model model) {

		model.addAttribute("store", new Store());
		return "layouts/Master/StoreMaster";
	}

	@PostMapping("/")
	public String addStore(@ModelAttribute("store") Store store) {

		storeService.addStore(store);

		return "redirect:/store/";
	}

	@GetMapping("/list")
	public String viewStoreList(Model model) {

		List<Store> storeList =storeService.getAllStore();

		if (storeList != null) {
			model.addAttribute("storeList", storeList);
		}
		return "layouts/listview/listofstore";
	}

	@GetMapping("/edit/{id}")
	public String editStore(@PathVariable("id") String storeCode, Model model) {

		System.out.println("module code is : " + storeCode);
		

		Optional<Store> store = storeService.editStore(storeCode);
		model.addAttribute("store", store);
		return "layouts/editview/editStore";
	}

	@GetMapping("/delete/{id}")
	public String deleteStore(@PathVariable("id") String storeCode, Model model) {
		storeService.deleteStore(storeCode);
		return "redirect:/store/list";
	}

}
