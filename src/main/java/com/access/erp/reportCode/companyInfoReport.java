package com.access.erp.reportCode;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.UserRights;
import com.access.erp.repo.CompanyRepo;
import com.access.erp.repo.UserRightRepo;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.repo.InputStreamResource;

@Component
public class companyInfoReport {

	@Autowired
	CompanyRepo companyRepo;

	public void createCompanyInfoReport(HttpServletResponse response, HttpServletRequest request) throws IOException {

		String companyCode = "EB";

		Company company = companyRepo.findById(companyCode).get();

		System.out.println("company name : " + company.getCompName());

		// System.out.println("cCityName : " + company.getrCity().getCityName());

		String reportFileName = "CompanyInfo"; // report name

		// String sourceFileName = request.getSession().getServletContext()
		// .getRealPath("resources/" + reportFileName + ".jrxml");

		String sourceFileName = request.getSession().getServletContext()
				.getRealPath("resources/" + reportFileName + ".jrxml");
		try {

			JasperCompileManager.compileReportToFile(sourceFileName);

			sourceFileName = request.getSession().getServletContext()
					.getRealPath("/resources/" + reportFileName + ".jasper");
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("compName", company.getCompName());
			parameters.put("compCode", company.getCompCode());

			parameters.put("dirName", company.getDirName());
			parameters.put("caddr1", company.getcAddr1());
			parameters.put("tGstNo", company.gettGstNo());
			parameters.put("panNumber", company.getPanNumber());

			if (company.getcCity() == null)
				System.out.print("-");
			else
				parameters.put("City", company.getcCity().getCityName());

			parameters.put("cPhone1", company.getcPhone1());
			/*
			 * parameters.put("cstDate", company.getCstDate()); 
			 * parameters.put("tin",
			 *                        company.getTin());
			 * 
			 * parameters.put("tin", company.getTin());
			 */
			parameters.put("eccNumber",company.getEccNumber());
			parameters.put("taxPayerTradeName", company.getTaxPayerTradeName());

			parameters.put("tdTaxPayerLegalName", company.getTaxPayerLegalName());
			parameters.put("tdFillingDate", company.getTdFillingDate());

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

	public ByteArrayInputStream generateExcel(List<Company> companyList) {

		String[] columns = { "Sr.No","Company Code", "Company Name", "Director Name", "GST", "Pan", "Address","Phone No.","TaxPayerLegalName","TaxPayerTradeName","FillingDate" };

		try {
			Workbook workBook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Sheet sheet = workBook.createSheet("Company");

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

			for (Company company : companyList) {

				Row row = sheet.createRow(rowIndex++);

				row.createCell(0).setCellValue(rowIndex); //
				row.createCell(1).setCellValue(company.getCompCode());
				row.createCell(2).setCellValue(company.getCompName());
				row.createCell(3).setCellValue(company.getDirName());
				row.createCell(4).setCellValue(company.gettGstNo());
				row.createCell(5).setCellValue(company.getPanNumber());
				row.createCell(6).setCellValue(company.getcAddr1());
				row.createCell(7).setCellValue(company.getcPhone1());

				
				row.createCell(8).setCellValue(company.getTaxPayerLegalName());
				row.createCell(9).setCellValue(company.getTaxPayerTradeName());
				row.createCell(10).setCellValue(company.getTdFillingDate());
	

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
