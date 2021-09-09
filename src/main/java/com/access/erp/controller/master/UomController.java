package com.access.erp.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("uom")
public class UomController {
	
	
	@GetMapping("/")
	public String Uom() {
		return "layouts/Master/UOM";
	}

}
