package com.access.erp.reportControler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.access.erp.reportCode.stockCategoryWiseReport;

@Controller
public class stockcategorywiseController {

	
	@Autowired stockCategoryWiseReport repo;
	
	
	@GetMapping("/categoryview")
	
	public String categoryWise(Model model) {
	   return "layouts/reportview/stockCategoryWise";
	
	}
	@PostMapping("/categoryWise")
	public String addCategoryWise(HttpServletRequest request) {
		System.out.println("Date1  " +	request.getParameter("fromDate"));
		System.out.println("Date2 :  " +	request.getParameter("toDate"));
		
		System.out.println("formate : " + request.getParameter("desRecord"));
		return"";
	}
	
	
	
	
	@GetMapping("/Categorywisereport")
	public String getStockCategorywiseReport(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		repo.createStockCategoryWiseReport(res,req);
		return null;
	}
	
}
