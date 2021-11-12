package com.access.erp.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/party")
public class PartyMasterController {
	
	@GetMapping("/")
	public String party() {
		
		return "layouts/Master/partyMaster";
	}

}
