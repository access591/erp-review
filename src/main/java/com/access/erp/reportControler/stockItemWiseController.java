package com.access.erp.reportControler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.access.erp.reportCode.stockItemWiseReport;

@Controller

public class stockItemWiseController {
	
	
	
	@Autowired stockItemWiseReport repo;
	
	
	
	@GetMapping("/Stockview")
	
	public String itemWise(Model model) {
	
	return"layouts/reportview/StockItemWise";
	
	}
	
	@PostMapping("/stockitem")
	public String addStockItemWise(HttpServletRequest request) {
		
		
		System.out.println("hstock controller");
		System.out.println("Category : " + request.getParameter("category"));
		System.out.println("From Date : " + request.getParameter("fromDate"));
		System.out.println("To Date: " + request.getParameter("toDate"));
		System.out.println("Item Name: " + request.getParameter("Item"));
		
	

		
		return "";
				

	}
	
	
	
	
	
    @GetMapping("/ItemwiseReport")
	public String getstockItemWiseReport(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
    	 repo.createStockItemWiseReport(res,req);
		return null;
		
		
	}
	
	
}
