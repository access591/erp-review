package com.access.erp.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryMasterController {
	
	@GetMapping("/")
	public String category() {
		return "layouts/Master/categoryMaster";
	}
	
	
	

}
