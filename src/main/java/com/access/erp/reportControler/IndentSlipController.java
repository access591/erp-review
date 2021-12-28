package com.access.erp.reportControler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.access.erp.reportCode.IndentSlipReport;

@Controller
public class IndentSlipController {

	@Autowired IndentSlipReport repo;
	@GetMapping("/indentreport")
	public String getIndentSlipreport(HttpServletRequest req,HttpServletResponse res) throws IOException {
		 System.out.println("hello");
     repo.createIndentSlipreport(res,req);
		
		
		return null;
		
		
		
	}
}
