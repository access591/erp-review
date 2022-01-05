package com.access.erp.reportControler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.access.erp.reportCode.stockLedgerSummaryreport;

@Controller
public class stockLedgerSummaryController {
	
	
	@Autowired stockLedgerSummaryreport repo;
	
	
	
	
	
	@GetMapping("ledgerSummaryview")
	public String ledgerSummary(Model model) {
		
		return"layouts/reportview/stockLedgerSummary";
		
	}
	
	@PostMapping("/summary")
	public String addledgerSummary(HttpServletRequest request) {
		
	System.out.println("name :  " +	request.getParameter("fromDate"));
	System.out.println("name :  " +	request.getParameter("toDate"));
	System.out.println("name :  " +	request.getParameter("DesFormat"));

	return"";
	}
	
	
	
	
	
	
	
	
	@GetMapping("/stockledgersumery")
	public String getStockLedgerSummaryReport(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		repo.createStockLedgerReport(res,req);
		return null;
	}
	

}
