package com.access.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.RfQuotation;
import com.access.erp.service.OpenIndentService;



/*request for quotation*/



@Controller
@RequestMapping("/requestquotation")
public class RfQuotationController {

	@Autowired  OpenIndentService openIndentService;
	
	@GetMapping("/")
	public String requestQuotation(Model model) {
		
		List<OpenIndent> aprovedOpenIndentList = openIndentService.approvedOpenIndent();
		model.addAttribute("aprovedOpenIndentList", aprovedOpenIndentList);
		
		model.addAttribute("rFQuotation", new RfQuotation());
		
		return "layouts/Master/requestForQuotation";
	}
}
