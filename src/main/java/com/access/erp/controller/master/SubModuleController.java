package com.access.erp.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("submodule")
public class SubModuleController {
	
	@GetMapping("/")
	public String subModule() {
		return "layouts/Master/subModule";
	}

}
