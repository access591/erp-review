package com.access.erp.reportControler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.access.erp.reportCode.StockRegisterReport;

@Controller
public class StockRegisterController {
	
	
	@Autowired StockRegisterReport repo;

	@GetMapping("/")
	public String getStockRegisterReport(HttpServletRequest req ,HttpServletResponse res) throws IOException {
		
		repo.createStockRegisterReport(res, req);
		return null;
		
		
		
	}
	
	
	
	
}
