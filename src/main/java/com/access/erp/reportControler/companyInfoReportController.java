package com.access.erp.reportControler;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.core.io.InputStreamResource;
import com.access.erp.model.master.Company;
import com.access.erp.repo.CompanyRepo;
import com.access.erp.reportCode.companyInfoReport;






@Controller
public class companyInfoReportController {

	
	@Autowired companyInfoReport  companyInfoRepo;
	@Autowired CompanyRepo companyRepo;
	
	@GetMapping("/report1")
	public String getCompanyReport(HttpServletRequest req,HttpServletResponse res)  throws IOException {
		
		
		System.out.println("hello");
		companyInfoRepo.createCompanyInfoReport(res,req);
		return null;
		
		
		
		
		
	}
	
	
	
	@GetMapping("/companyExcelsheet")
	public ResponseEntity<InputStreamResource> createExcelsheet(HttpServletRequest req, HttpServletResponse re) {

		List<Company> companyList = companyRepo.findAll();
		
		
		ByteArrayInputStream in = companyInfoRepo.generateExcel(companyList);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment ; filename=company.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	
	
	
	
	
}
