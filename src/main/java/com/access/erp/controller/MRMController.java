package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.MRN;

@Controller
@RequestMapping("mrn")
public class MRMController {

	@GetMapping("/")
	public String mrmPage(Model model) {
		
		
		model.addAttribute("mrn", new MRN());
		
		return "layouts/Master/mrn";
	}
}
