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

import com.access.erp.model.master.Company;
import com.access.erp.model.master.UserRights;
import com.access.erp.repo.UserRightRepo;
import com.access.erp.reportCode.UserRightReport;

@Controller
public class UserRightReportController {
	
	@Autowired UserRightReport userRightRepoReport;
	
	@Autowired UserRightRepo userRightRepo;
	
	
	@GetMapping("/report")
public String getUserReport(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
	System.out.println("hello");
	
	userRightRepoReport.createUserRightReport(res,req);
	return null;
	
}
	
	
	
	
	
	@GetMapping("/userRightExcelsheet")
	public ResponseEntity<InputStreamResource> createExcelsheet1(HttpServletRequest req, HttpServletResponse res) {

		List<UserRights> userRightList = userRightRepo.findAll();
		
		
		ByteArrayInputStream in = userRightRepoReport.generateExcel(userRightList);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment ; filename=UserRight.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	
	
	
	
	
	
	
	}
