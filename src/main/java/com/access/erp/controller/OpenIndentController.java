package com.access.erp.controller;

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

import com.access.erp.model.OpenIndent;
import com.access.erp.service.OpenIndentService;

@Controller
@RequestMapping("/openindent")
public class OpenIndentController {
	
	@Autowired OpenIndentService openIndentService;
	
	@GetMapping("/")
	public String openIndent(Model model) {
		
		model.addAttribute("openIndent", new OpenIndent());
		return "layouts/Master/openindent";
	}
	
	@PostMapping("/")
	public String addOpenIndent(@ModelAttribute("openIndent") OpenIndent openIndent) {
		
		System.out.println(" testing : "+
		openIndent.getOpeIndentDetail().get(0).getTotalValue());
		openIndentService.addOpenIndent(openIndent);
		
		return "redirect:/openindent/";
	}
	
	@GetMapping("/list")
	public String viewOpenIndentList(Model model) {
		
		List<OpenIndent> openIndentList = openIndentService.getAllOpenIndent();
		
		if(openIndentList != null) {
			model.addAttribute("openIndentList", openIndentList);
		}
		return "layouts/listview/listofopenIndent";
	}
	
	@GetMapping("/edit/{id}")
	public String editOpenIndent(@PathVariable("id") String indentCode,Model model) {
		
		Optional<OpenIndent> openIndent = openIndentService.editOpenIndent(indentCode);
		
		openIndent.ifPresent(indent
				->model.addAttribute("openIndent", indent));
		
		
		
		
		return "layouts/editview/editOpenIndent";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteOpenIndent(@PathVariable("id") String openIndent,Model model) {
		openIndentService.deleteOpenIndent(openIndent);
		return "redirect:/openindent/list";
	}

}
