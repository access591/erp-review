package com.access.erp.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item-master")
public class ItemMasterController {
	
	
	@GetMapping("/")
	public String itemMaster() {
		return "layouts/Master/itemMaster" ;
	}

}
