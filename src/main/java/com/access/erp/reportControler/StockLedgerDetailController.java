package com.access.erp.reportControler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.access.erp.reportCode.StockLedgerDetail;

@Controller
public class StockLedgerDetailController {

	@Autowired
	StockLedgerDetail repo;

	@GetMapping("/ledgerview")
	public String ledgerDetails(Model model) {

		return "layouts/reportview/stockLedgerDetails";
	}

	
	
	@PostMapping("/ledgerDetail")
	public String addStockLedgerDetail(HttpServletRequest request) {
		
		
		
		System.out.println("name : " + request.getParameter("fromDate"));
		System.out.println("name : " + request.getParameter("toDate"));
		System.out.println("name : " + request.getParameter("format"));

		
		
		return "";
	}
	
	
	
	@GetMapping("/stockLedger")
	public String getStockLedgerReport(HttpServletRequest req, HttpServletResponse res) throws IOException {
		repo.createStockLedgerReport(res, req);
		return null;

	}

}
