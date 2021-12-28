package com.access.erp.reportCode;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.access.erp.model.master.Store;
import com.access.erp.model.master.UserRights;
import com.access.erp.repo.StoreRepo;

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
public class StoreReport {
	
	
	@Autowired StoreRepo storeRepo;
	
	public void createStoreReport(HttpServletResponse response,HttpServletRequest request) throws IOException {
		
		List<Store>StoreList = storeRepo.findAll();
		
		
		String reportFileName = "StoreReport";
		

		String sourceFileName = request.getSession().getServletContext()
				.getRealPath("resources/" + reportFileName + ".jrxml");

		
				
				
				
				
				
				
				System.out.println("arms licenses report : ");
		try {

			JasperCompileManager.compileReportToFile(sourceFileName);
			sourceFileName = request.getSession().getServletContext()
					.getRealPath("/resources/" + reportFileName + ".jasper");
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(StoreList);

			Map<String, Object> parameters = new HashMap<>();

			parameters.put("storeReport", beanColDataSource);
			
			
			//parameters.put("runBy", "Run By : " + runBy);
			//parameters.put("runDate", "Run Date : " + new Date().toString());

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
	
	public ByteArrayInputStream generateExcel(List<Store> StoreList) {

		String[] columns = { "Sr.No", "Store Code", "Description", "Status", "Location"};

		try {
			Workbook workBook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Sheet sheet = workBook.createSheet("Store");

			Font headerFont = workBook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workBook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < columns.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);

			}

			int rowIndex = 1;

			for (Store store : StoreList) {

				Row row = sheet.createRow(rowIndex++);

				row.createCell(0).setCellValue(rowIndex); //
				
				
				
			//	  row.createCell(1).setCellValue(store.getStoreType());

				  row.createCell(1).setCellValue(store.getStoreCode());
				  row.createCell(2).setCellValue(store.getDescription());

				  
				  System.out.println("f value : " + store.getStoreStatus());
				  if(store.getStoreStatus().equals("F")) {
					  row.createCell(3).setCellValue("Functional");
				  }else {
					  row.createCell(3).setCellValue("Non-Functional");
				  }
				  
				  
				  
 
				 
				  row.createCell(4).setCellValue(store.getLocation());
					/*
					 * row.createCell(4).setCellValue(store.setStoreStatus(null));
					 * if(userRights.getActive().equals("Y")) {
					 * row.createCell(5).setCellValue("Active"); }else {
					 * row.createCell(5).setCellValue("Inactive"); }
					 * 
					 *///row.createCell(6).setCellValue(userRights.getcAddr1());
				// row.createCell(7).setCellValue(emp.getBatchYear());

			}
			workBook.write(out);
			workBook.close();
			return new ByteArrayInputStream(out.toByteArray());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		// return null;

	}
	
	
	

}
