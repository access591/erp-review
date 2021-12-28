package com.access.erp.reportCode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.access.erp.model.ItemOpening;
import com.access.erp.model.master.Item;
import com.access.erp.repo.ItemOpeningRepo;
import com.access.erp.repo.ItemRepo;
import com.access.erp.report.utility.ItemItemOpening;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class ItemStockReport {

	@Autowired
	ItemOpeningRepo itemOpeningrepo;
	
	@Autowired
	ItemRepo itemRepo;

	public void createItemStockReport(HttpServletResponse response, HttpServletRequest request) throws IOException {

		String itemCode = "EB-0001-0022";

		Item item = itemRepo.findById(itemCode).get();
		
		ItemOpening itemOpening = itemOpeningrepo.findById(itemCode).get();

		ItemItemOpening itemItemOpening = new ItemItemOpening();

		itemItemOpening.setItem(item);
		itemItemOpening.setItemOpening(itemOpening);

		String reportFileName = "itemStock"; // report name

		String sourceFileName = request.getSession().getServletContext()
				.getRealPath("resources/" + reportFileName + ".jrxml");

		try {

			JasperCompileManager.compileReportToFile(sourceFileName);

			sourceFileName = request.getSession().getServletContext()
					.getRealPath("/resources/" + reportFileName + ".jasper");
			Map<String, Object> parameters = new HashMap<>();
			/*
			 * parameters.put("compName", company.getCompName()); parameters.put("compCode",
			 * company.getCompCode());
			 * 
			 * parameters.put("dirName", company.getDirName()); parameters.put("caddr1",
			 * company.getcAddr1()); parameters.put("tGstNo", company.gettGstNo());
			 * parameters.put("panNumber", company.getPanNumber());
			 */
			/*
			 * if (company.getcCity() == null) System.out.print("-"); else
			 * parameters.put("City", company.getcCity().getCityName());
			 * 
			 * parameters.put("cPhone1", company.getcPhone1());
			 */
			/*
			 * parameters.put("cstDate", company.getCstDate());
			 *  parameters.put("tin", company.getTin());
			 *                        
			 * 
			 * parameters.put("tin", company.getTin());
			 * 
			 * parameters.put("eccNumber",company.getEccNumber());
			 * parameters.put("taxPayerTradeName", company.getTaxPayerTradeName());
			 * 
			 * parameters.put("tdTaxPayerLegalName", company.getTaxPayerLegalName());
			 * parameters.put("tdFillingDate", company.getTdFillingDate());
			 */

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
