package com.access.erp.reportControler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.access.erp.reportCode.StockLedgerDetail;

@Controller
public class StockLedgerDetailController {

	@Autowired StockLedgerDetail repo;
	@GetMapping("/stockLedger")
	public String getStockLedgerReport(HttpServletRequest req,HttpServletResponse res) throws IOException {
		repo.createStockLedgerReport(res,req);
		return null;
		
	}
	
}
