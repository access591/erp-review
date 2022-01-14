package com.access.erp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.OpenIndentDetail;
import com.access.erp.model.RfQuotation;
import com.access.erp.model.master.City;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.State;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.model.master.UOM;
import com.access.erp.repo.ItemRepo;
import com.access.erp.repo.OpenIndentDetailRepo;
import com.access.erp.repo.OpenIndentRepo;
import com.access.erp.repo.SupplierRepo;
import com.access.erp.service.CityService;
import com.access.erp.service.OpenIndentDetailService;
import com.access.erp.service.OpenIndentService;
import com.access.erp.service.PartyMasterService;
import com.access.erp.service.RfQuotationService;
import com.access.erp.service.StateService;
import com.access.erp.service.UOMService;
import com.access.erp.singleton.GlobalParameter;
import com.access.erp.utility.ItemListOfIndent;
import com.access.erp.utility.ItemUom;
import com.access.erp.utility.PartyStateCity;

/*request for quotation*/

@Controller
@RequestMapping("/requestquotation")
public class RfQuotationController {

	@Autowired
	OpenIndentService openIndentService;
	@Autowired
	OpenIndentDetailService openIndentDetailService;
	@Autowired
	ItemRepo itemRepo;
	@Autowired
	OpenIndentRepo openIndentRepo;
	@Autowired
	SupplierRepo supplierRepo;
	@Autowired
	RfQuotationService rfQuotationService;
	@Autowired
	UOMService uomService;
	@Autowired
	PartyMasterService partyMasterService;
	@Autowired
	StateService stateService;
	@Autowired
	CityService cityService;
	@Autowired
	OpenIndentDetailRepo openIndentDetailRepo;
	@Autowired GlobalParameter globalParameter;

	@GetMapping("/")
	public String requestQuotation(Model model) {

		List<OpenIndent> aprovedOpenIndentList = openIndentService.findIndentNotInRfq();
		model.addAttribute("aprovedOpenIndentList", aprovedOpenIndentList);

		model.addAttribute("rFQuotation", new RfQuotation());

		// List<SupplierMaster> listSupplierMaster = supplierRepo.findAll();
		// model.addAttribute("listSupplier", listSupplierMaster);

		// Suplier == Party Master which containing S in pk
		List<PartyMaster> listSupplierMaster = partyMasterService.findByPartyCodeContaining("S");

		model.addAttribute("listSupplier", listSupplierMaster);

		List<City> listCity = cityService.getAllCity();
		model.addAttribute("listCity", listCity);

		List<State> listStates = stateService.getAllState();
		model.addAttribute("listStates", listStates);

		return "layouts/Master/requestForQuotation";
	}

	@PostMapping("/")
	public String addrFQuotation(@ModelAttribute("rFQuotation") RfQuotation rfQuotation,RedirectAttributes redirectAttributes) {

		System.out.println(" add rf Quotation method ");
		rfQuotation.setcCode(globalParameter.getGlobalCompany());
		rfQuotation.setFyCode(globalParameter.getGlobalFinanceYear());
		rfQuotation.setuCode(globalParameter.getGlobaluser());
		
		rfQuotationService.addRfQuotation(rfQuotation);
		
		redirectAttributes.addFlashAttribute("message", "Record  has been saved successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/requestquotation/";
	}
	
	
	@PostMapping("/update")
	public String updateRFQuotation(@ModelAttribute("rFQuotation") RfQuotation rfQuotation,RedirectAttributes redirectAttributes) {

		System.out.println(" update rf Quotation method ");
		
		
		rfQuotationService.updateRfQuotation(rfQuotation);
		
		redirectAttributes.addFlashAttribute("message", "Record  has been updated successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/requestquotation/";
	}
	
	

	@GetMapping("/list")
	public String viewRequestQuotation(Model model) {

		List<RfQuotation> rfqList = rfQuotationService.findAllByOrderByRfqNoDsc();

		if (rfqList != null) {
			model.addAttribute("rfqList", rfqList);
		}
		return "layouts/listview/listofrequestForQuotation"; // listofrequestForQuotation.html
	}

	@GetMapping("/edit/{id}")
	public String editRequestQuotation(@PathVariable("id") String rfqCode, Model model) {

		System.out.println("rfqCode code is : " + rfqCode);

		List<OpenIndent> aprovedOpenIndentList = openIndentService.approvedOpenIndent();
		model.addAttribute("aprovedOpenIndentList", aprovedOpenIndentList);

		List<PartyMaster> listSupplierMaster = partyMasterService.findByPartyCodeContaining("S");
		model.addAttribute("listSupplier", listSupplierMaster);

		Optional<RfQuotation> rFQuotation = rfQuotationService.editRfQuotation(rfqCode);

		// openIndent.ifPresent(indent -> model.addAttribute("openIndent", indent));

		rFQuotation.ifPresent(quotation -> model.addAttribute("rFQuotation", quotation));

		List<City> listCity = cityService.getAllCity();
		model.addAttribute("listCity", listCity);

		List<State> listStates = stateService.getAllState();
		model.addAttribute("listStates", listStates);

		// model.addAttribute("rFQuotation", rFQuotation);
		return "layouts/editview/editRequestForQuotation";
	}

	@GetMapping("/delete/{id}")
	public String deleteRequestQuotation(@PathVariable("id") String rfqCode, Model model,RedirectAttributes redirectAttributes) {
		rfQuotationService.deleteRfQuotation(rfqCode);
		
		redirectAttributes.addFlashAttribute("message", "Record  has been Deleted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/requestquotation/list";
	}

	
	
	@ResponseBody
	@GetMapping("/itemdetail/{indentNumber}")
	public ItemListOfIndent getItemListBehalfOfIndentNumber(@PathVariable(value = "indentNumber") String indentNumber,
			Model model) {

		System.out.println("employee iinfo : " + indentNumber);

		OpenIndent openIndent = new OpenIndent();
		openIndent.setIndentNumber(indentNumber);

		ItemListOfIndent itemListOfIndent = new ItemListOfIndent();

		List<OpenIndentDetail> listOpenIndentDetail = openIndentDetailService
				.findOpenIndentDetailByOpenIndent(openIndent);

		OpenIndent indent = openIndentRepo.findByIndentNumber(indentNumber);

		List<Item> listItem = new ArrayList<>();

		for (OpenIndentDetail indentDetail : listOpenIndentDetail) {

			Item item = itemRepo.findByItemCode(indentDetail.getIndItemCode());
			System.out.println("item info : " + item.getDescription());
			System.out.println("item info : " + item.getItemCode());
			listItem.add(item);
		}

		itemListOfIndent.setIndentDate(indent.getIndentDate());
		itemListOfIndent.setListItem(listItem);

		return itemListOfIndent;

	}

	@ResponseBody
	@GetMapping("/itemdetail1/{itemCode}/{indentNumber}")
	public ItemUom getItemDetail(@PathVariable(value = "itemCode") String itemCode,
			@PathVariable(value = "indentNumber") String indentNumber, Model model) {

		System.out.println("item iinfo : " + itemCode + "and indent number : " + indentNumber);

		Item item = itemRepo.findByItemCode(itemCode);

		UOM uom = uomService.editUOM(item.getUom().getUomCode()).get();

		// OpenIndentDetail openIndentDetail =
		// openIndentDetailRepo.findByIndItemCode(itemCode);

		
		OpenIndentDetail openIndentDetail = null;
		
		if(!indentNumber.equals("IND")) {
			
			OpenIndent openIndent = openIndentService.editOpenIndent(indentNumber).get();		
			openIndentDetail = openIndentDetailRepo.findByIndItemCodeAndOpenIndent(itemCode, openIndent);
			
		}
		

		ItemUom itemUom = new ItemUom();
		itemUom.setItem(item);
		itemUom.setUom(uom);
		itemUom.setOpenIndentDetail(openIndentDetail);

		System.out.println("uom code info is : " + item.getUom().getUomCode());

		return itemUom;

	}

	@ResponseBody
	@GetMapping("/supplierdetail/{supplierCode}")
	public PartyStateCity supplierDetail(@PathVariable(value = "supplierCode") String supplierCode, Model model) {

		System.out.println("supplierCode iinfo : belongs to party master which has pk containing 'S' " + supplierCode);

		PartyStateCity partStateCity = new PartyStateCity();

		// SupplierMaster supllier =
		// supplierRepo.findBySupplierId(Long.valueOf(supplierCode).longValue());
		PartyMaster partyMaster = partyMasterService.editPartyMaster(supplierCode).get();
		State state = stateService.editState(partyMaster.getStateCode()).get();
		City city = cityService.editCity(partyMaster.getLclAddrCityCode()).get();

		partStateCity.setPartyMaster(partyMaster);
		partStateCity.setState(state);
		partStateCity.setCity(city);

		return partStateCity;

	}

	@ResponseBody
	@GetMapping("/indentinfo")
	public List<OpenIndent> indentInfo() {

		System.out.println("indent info handler ");
		List<OpenIndent> aprovedOpenIndentList = openIndentService.approvedOpenIndent();
		return aprovedOpenIndentList;

	}

	@ResponseBody
	@GetMapping("/supplierlist")
	public List<PartyMaster> supplierList(Model model) {

		List<PartyMaster> listSupplierMaster = partyMasterService.findByPartyCodeContaining("S");
		System.out.println("list of supplier size is : " + listSupplierMaster.size());
		return listSupplierMaster;

	}
	
	
	@ResponseBody
	@GetMapping("/itemlist")
	public List<Item> itemList(Model model) {

		List<Item> itemList = itemRepo.findAll();
		System.out.println("list of supplier size is : " + itemList.size());
		return itemList;

	}
}
