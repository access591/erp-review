package com.access.erp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.helper.FileService;
import com.access.erp.model.GateEntry;
import com.access.erp.model.PurchaseOrder;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.service.GateEntryService;
import com.access.erp.service.PartyMasterService;
import com.access.erp.service.PurchaseOrderService;

@Controller
@RequestMapping("/gateout")
public class GateOutController {

	@Autowired
	PurchaseOrderService purchaseOrderService;
	@Autowired
	PartyMasterService partyMasterService;
	@Autowired
	GateEntryService gateEntryService;

	@GetMapping("/")
	public String gateOutPage(Model model) {

		List<GateEntry> listGateEntry = gateEntryService.getAllGateEntry();
		model.addAttribute("listGateEntry", listGateEntry);

		List<PurchaseOrder> listPurchaseOrder = purchaseOrderService.getApprovedPurchaseorder("Y");
		model.addAttribute("listPO", listPurchaseOrder);

		List<PartyMaster> partyMasterList = partyMasterService.findByPartyCodeContaining("S");
		model.addAttribute("partyMasterList", partyMasterList);

		model.addAttribute("gateEntry", new GateEntry());

		return "layouts/Master/gateOut";
	}

	@PostMapping("/")
	public String addGateOut(@RequestParam("file") MultipartFile file,
			@ModelAttribute("gateEntry") GateEntry gateEntry, RedirectAttributes redirectAttributes) {

		

		gateEntryService.addGateEntry(gateEntry);

		redirectAttributes.addFlashAttribute("message", "Gate Out  has been saved successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/gateout/";
	}

	@ResponseBody
	@GetMapping("/gateOutInfo/{gateId}")
	public GateEntry getGateEntryInfo(@PathVariable("gateId") String gateId) {

		GateEntry gateEntry = gateEntryService.editGateEntry(gateId).get();
		return gateEntry;
	}
}
