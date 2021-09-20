package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/requestquotation")
public class RfQuotationController {

	@GetMapping("/")
	public String requestQuotation() {
		
		return "layouts/Master/requestForQuotation";
	}
}
