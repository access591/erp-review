package com.access.erp.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/module")
public class ModuleController {
	
	@GetMapping("/")
	public String module() {
		
		return "layouts/Master/moduleMaster";
	}

}
