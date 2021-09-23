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

import com.access.erp.model.master.UOM;
import com.access.erp.service.UOMService;

@Controller
@RequestMapping("uom")
public class UomController {
	
	@Autowired UOMService uomService;
	
	@GetMapping("/")
	public String UOM(Model model) {
		
		model.addAttribute("uom", new UOM());
		return "layouts/Master/UOM";
	}
	
	@PostMapping("/")
	public String addUOM(@ModelAttribute("uom") UOM uom) {
		
		uomService.addUOM(uom);
		
		return "redirect:/uom/";
	}
	
	@GetMapping("/list")
	public String viewUOMList(Model model) {
		
		List<UOM> uomList = uomService.getAllUOM();
		
		if(uomList != null) {
			model.addAttribute("uomList", uomList);
		}
		return "layouts/listview/listofuom";
	}
	
	@GetMapping("/edit/{id}")
	public String editUOM(@PathVariable("id") String uomCode,Model model) {
		
		System.out.println("uom code is : "+ uomCode);
		
		Optional<UOM> uom = uomService.editUOM(uomCode);
		model.addAttribute("uom", uom);
		return "layouts/editview/editUom";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUOM(@PathVariable("id") String uomCode,Model model) {
		uomService.deleteUOM(uomCode);
		return "redirect:/uom/list";
	}

}