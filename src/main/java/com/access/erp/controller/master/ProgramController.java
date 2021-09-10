package com.access.erp.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("program")
public class ProgramController {
	
	@GetMapping("/")
	public String program() {
		return "layouts/Master/program";
	}

}
