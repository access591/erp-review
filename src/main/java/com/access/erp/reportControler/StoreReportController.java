package com.access.erp.reportControler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.access.erp.model.master.Store;
import com.access.erp.model.master.UserRights;
import com.access.erp.repo.StoreRepo;
import com.access.erp.reportCode.StoreReport;

@Controller
public class StoreReportController {
	
	
	
	@Autowired StoreReport repo;
	@Autowired StoreRepo storeRepo;
	
	@GetMapping("/report2")
	
	public String getStoreReport(HttpServletRequest req,HttpServletResponse res) throws IOException {
	 System.out.println("hello");
	  
	 repo.createStoreReport(res, req);
		return null;
		
		
		
		
		
	}
	
	@GetMapping("/createExcelsheet2")
	public ResponseEntity<InputStreamResource> createExcelsheet1(HttpServletRequest req, HttpServletResponse res) {

		List<Store> StoreList =storeRepo.findAll();
		
		
		ByteArrayInputStream in = repo.generateExcel(StoreList);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment ; filename=store.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	

	
	
	
	
}
