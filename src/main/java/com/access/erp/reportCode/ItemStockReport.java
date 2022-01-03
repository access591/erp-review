package com.access.erp.reportCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.access.erp.model.ItemOpening;
import com.access.erp.model.master.Category;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.Item;
import com.access.erp.repo.CategoryRepo;
import com.access.erp.repo.ItemOpeningRepo;
import com.access.erp.repo.ItemRepo;
import com.access.erp.report.utility.ItemCategory;
import com.access.erp.report.utility.ItemItemOpening;

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
public class ItemStockReport {

	@Autowired
	ItemOpeningRepo itemOpeningrepo;

	@Autowired
	ItemRepo itemRepo;

	@Autowired
	CategoryRepo categoryRepo;

	public void createItemStockReport(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<Item> itemList = itemRepo.findAll();

		List<ItemCategory> itemCategoryList = new ArrayList<>();

		List<ItemOpening> itemOpeningList = itemOpeningrepo.findAll();

		ItemItemOpening itemItemOpening = new ItemItemOpening();

		for (Item item : itemList) {

			System.out.println("item : " + item.getItemCode());
			
			ItemCategory itemCategory = new ItemCategory();
			itemCategory.setItem(item);
			
			Category category = categoryRepo.findById(item.getCategory().getCategCode()).get();
			itemCategory.setCategory(category);

			boolean exists = itemOpeningrepo.existsByItemCode(item.getItemCode());
			System.out.println("exist : " + exists);
			ItemOpening itemOpening = new ItemOpening();

			if (exists) {

				itemOpening = itemOpeningrepo.findById(item.getItemCode()).get();
				itemCategory.setItemOpening(itemOpening);
			}else {
				
				itemOpening.setCurrentStock("-");
				itemOpening.setOpeningRate("-");
				
			}

			itemCategoryList.add(itemCategory);

			

			// ItemOpening itemOpening = itemOpeningrepo.findById(
			// item.getItemCode()).get();

		}

		System.out.println("item list size : " + itemCategoryList.size());

		String reportFileName = "itemStock1"; // report name

		String sourceFileName = request.getSession().getServletContext()
				.getRealPath("resources/" + reportFileName + ".jrxml");

		try {

			JasperCompileManager.compileReportToFile(sourceFileName);

			sourceFileName = request.getSession().getServletContext()
					.getRealPath("/resources/" + reportFileName + ".jasper");

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(itemCategoryList);
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("itemStock", beanColDataSource);
			parameters.put("newDate",new Date());

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
