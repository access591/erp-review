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

import com.access.erp.model.master.Item;
import com.access.erp.model.master.Store;
import com.access.erp.repo.ItemRepo;
import com.access.erp.reportCode.ItemMasterReport;

@Controller
public class ItemMasterController {
	
	
	
	@Autowired ItemMasterReport repo;
	@Autowired ItemRepo itemrepo;
	
	
	@GetMapping("/report4")
	public String getItemMasterReport(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		
		 System.out.println("hello");
		  
		 repo.createItemMasterReport(res, req);
			return null;
			
	}
	
	

	@GetMapping("/ItemExcelsheet")
	public ResponseEntity<InputStreamResource> createExcelsheet1(HttpServletRequest req, HttpServletResponse res) {

		List<Item> ItemList =itemrepo.findAll();
		
		
		ByteArrayInputStream in = repo.generateExcel(ItemList);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment ; filename=ItemMaster.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

}
