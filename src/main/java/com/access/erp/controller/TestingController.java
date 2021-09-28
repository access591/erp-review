package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestingController {
	
	
	/*
	 * @GetMapping("financialyear") public String financialYearPage(Model model) {
	 * return "layouts/financialyear"; }
	 */
	
	@GetMapping("financialactiveyear")
	public String financialActiveYearPage(Model model) {
		return "layouts/financialActiveYear";
	}

}
