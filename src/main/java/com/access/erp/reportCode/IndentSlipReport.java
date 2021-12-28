package com.access.erp.reportCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.OpenIndentDetail;
import com.access.erp.repo.OpenIndentDetailRepo;
import com.access.erp.repo.OpenIndentRepo;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class IndentSlipReport {

	@Autowired
	OpenIndentDetailRepo openIndentDetailRepo;
	@Autowired
	OpenIndentRepo openIndentRepo;

	public void createIndentSlipreport(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		  String indentNumber = "EB-IND-0018";
		  
		  OpenIndent openIndent = openIndentRepo.findById(indentNumber).get();
		 
		List<OpenIndentDetail> IndentList = openIndent.getOpeIndentDetail();

		String reportFileName = "indentReport";

		// String value1 = indentList.getname;

		String sourceFileName = request.getSession().getServletContext()
				.getRealPath("resources/" + reportFileName + ".jrxml");

		System.out.println("arms licenses report : ");
		try {

			JasperCompileManager.compileReportToFile(sourceFileName);
			sourceFileName = request.getSession().getServletContext()
					.getRealPath("/resources/" + reportFileName + ".jasper");
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(IndentList);

			Map<String, Object> parameters = new HashMap<>();
			
			
			  parameters.put("indentNumber", openIndent.getIndentNumber());
			  
			  parameters.put("indentDate",openIndent.getIndentDate());
			  
			  parameters.put("indentType",openIndent.getIndentType()); 
			  parameters.put("deptCode",openIndent.getDeptCode());
			 
			  parameters.put("indentSlip", beanColDataSource);
			  
			 	// parameters.put("runBy", "Run By : " + runBy);
			// parameters.put("runDate", "Run Date : " + new Date().toString());

			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

			if (jasperPrint != null) {
				byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				response.reset();
				response.setContentType("application/pdf");
				response.setHeader("Cache-Control", "no-store");
				response.setHeader("Cache-Control", "private");
				response.setHeader("Pragma", "no-store");
				response.setContentLength(pdfReport.length);

				response.getOutputStream().write(pdfReport);
				response.getOutputStream().flush();
				response.getOutputStream().close();

			}
		} catch (JRException e) {
			e.printStackTrace();

		}

	}
}
