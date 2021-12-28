package com.access.erp.reportControler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.ItemOpening;
import com.access.erp.model.master.Item;
import com.access.erp.reportCode.ItemStockReport;
import com.access.erp.service.ItemOpeningService;
import com.access.erp.service.ItemService;
import com.access.erp.service.impl.ItemOpeningServiceImpl;
import com.access.erp.service.impl.ItemServiceImpl;

@Controller
public class ItemStockController {

	@Autowired
	ItemStockReport repo;
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemOpeningService itemopeningService;

	@GetMapping("/itemStockReport")	
	public String itemStock(Model model) {

		return "layouts/reportview/itemStock";

	}
	/*
	 * @PostMapping("/") public String addItemStock(@ModelAttributes("itemOpening")
	 * ItemOpening itemOpening)
	 * 
	 * @GetMapping("/report5")
	 * 
	 * public String getItemStockReport(HttpServletRequest req, HttpServletResponse
	 * res) throws IOException {
	 * 
	 * repo.createItemStockReport(res, req); return null;
	 * 
	 * }
	 */
}