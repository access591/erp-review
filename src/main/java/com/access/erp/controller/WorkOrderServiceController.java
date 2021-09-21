package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("workorderservice")
public class WorkOrderServiceController {
	
	@GetMapping("/")
	public String workOrderService() {
		return "layouts/Master/WorkOrderService";
	}

}
