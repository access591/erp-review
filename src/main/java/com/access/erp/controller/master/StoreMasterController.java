package com.access.erp.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("store")
public class StoreMasterController {
	
	@GetMapping("/")
	public String storeMaster() {
		return "layouts/Master/StoreMaster";
	}

}
