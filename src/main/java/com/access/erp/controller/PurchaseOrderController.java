/*
 * package com.access.erp.controller;
 * 
 * import java.io.BufferedOutputStream; import java.io.FileOutputStream; import
 * java.util.ArrayList; import java.util.List;
 * 
 * import javax.servlet.ServletContext; import
 * javax.servlet.ServletOutputStream; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.web.multipart.commons.CommonsMultipartFile; import
 * org.springframework.web.servlet.mvc.support.RedirectAttributes;
 * 
 * import com.access.erp.model.OpenIndent; import
 * com.access.erp.model.OpenIndentDetail; import
 * com.access.erp.model.PurchaseOrder; import
 * com.access.erp.model.QuotationDetail; import
 * com.access.erp.model.RfQuotation; import
 * com.access.erp.model.RfQuotationItem; import
 * com.access.erp.model.master.City; import
 * com.access.erp.model.master.CurrencyMaster; import
 * com.access.erp.model.master.Item; import
 * com.access.erp.model.master.PartyMaster; import
 * com.access.erp.model.master.State; import
 * com.access.erp.model.master.SupplierMaster; import
 * com.access.erp.repo.CurrencyRepo; import
 * com.access.erp.repo.OpenIndentDetailRepo; import
 * com.access.erp.repo.OpenIndentRepo; import
 * com.access.erp.repo.QuotationDetailRepo; import
 * com.access.erp.repo.RFQuotationRepo; import com.access.erp.repo.SupplierRepo;
 * import com.access.erp.service.CityService; import
 * com.access.erp.service.ItemService; import
 * com.access.erp.service.OpenIndentService; import
 * com.access.erp.service.PartyMasterService; import
 * com.access.erp.service.PurchaseOrderService; import
 * com.access.erp.service.StateService; import
 * com.access.erp.singleton.GlobalParameter; import
 * com.access.erp.utility.ItemOpenIndentDetail; import
 * com.access.erp.utility.PartyStateCity; import
 * com.access.erp.utility.QuotationPartyState;
 * 
 * @Controller
 * 
 * @RequestMapping("purchaseorder") public class PurchaseOrderController {
 * 
 * @Autowired QuotationDetailRepo quotationDetailRepo;
 * 
 * @Autowired SupplierRepo supplierRepo;
 * 
 * @Autowired CurrencyRepo currencyRepo;
 * 
 * @Autowired RFQuotationRepo rfQuotationRepo;
 * 
 * @Autowired OpenIndentService openIndentService;
 * 
 * @Autowired PurchaseOrderService purchaseOrderService;
 * 
 * @Autowired PartyMasterService partyMasterService;
 * 
 * @Autowired StateService stateService;
 * 
 * @Autowired OpenIndentRepo openIndentRepo;
 * 
 * @Autowired ItemService itemService;
 * 
 * @Autowired OpenIndentDetailRepo openIndentDetailRepo;
 * 
 * @Autowired CityService cityService;
 * 
 * @Autowired GlobalParameter globalParameter;
 * 
 * private static final String UPLOAD_DIRECTORY = "/img/uploads";
 * 
 * @GetMapping("/") public String purchaseOrder(Model model) {
 * 
 * // only quotation which is approved
 * 
 * List<QuotationDetail> lsitQuotationDetail =
 * quotationDetailRepo.findByApprovalStatus1("Y");
 * model.addAttribute("lsitQuotationDetail", lsitQuotationDetail);
 * 
 * List<PartyMaster> listParty =
 * partyMasterService.findByPartyCodeContaining("S");
 * model.addAttribute("listParty", listParty);
 * 
 * List<CurrencyMaster> listCurrency = currencyRepo.findAll();
 * model.addAttribute("listCurrency", listCurrency);
 * 
 * model.addAttribute("purchaseOrder", new PurchaseOrder());
 * 
 * List<State> stateList = stateService.getAllState();
 * model.addAttribute("stateList", stateList);
 * 
 * return "layouts/Master/purchaseOrder"; }
 * 
 * @PostMapping("/") public String
 * addPurchaseOrder(@ModelAttribute("purchaseOrder") PurchaseOrder po,
 * 
 * @RequestParam("poFile") MultipartFile file, HttpSession session,
 * RedirectAttributes attributes) {
 * 
 * ServletContext context = session.getServletContext(); String path =
 * context.getRealPath(UPLOAD_DIRECTORY); System.out.println("path is : " +
 * path); String filename = file.getOriginalFilename();
 * 
 * po.setcCode(globalParameter.getGlobalCompany());
 * po.setuCode(globalParameter.getGlobaluser());
 * po.setFyCode(globalParameter.getGlobalFinanceYear());
 * 
 * if (file.isEmpty()) {
 * 
 * po.setDocFile("default"); //
 * attributes.addFlashAttribute("message","Please select a file to upload."); //
 * // return "redirect:/"; } else { try { byte barr[] = file.getBytes();
 * 
 * BufferedOutputStream bout = new BufferedOutputStream(new
 * FileOutputStream(path + "/" + filename)); bout.write(barr);
 * 
 * po.setDocFile(filename);
 * 
 * bout.flush(); bout.close();
 * 
 * }
 * 
 * catch (Exception e) { System.out.println(e); }
 * 
 * }
 * 
 * purchaseOrderService.addPurchaseOrder(po); return "redirect:/purchaseorder/";
 * 
 * }
 * 
 * @PostMapping("/update") public String
 * updatePurchaseOrder(@ModelAttribute("purchaseOrder") PurchaseOrder po,
 * 
 * @RequestParam("poFile") MultipartFile file, HttpSession session,
 * RedirectAttributes attributes) {
 * 
 * ServletContext context = session.getServletContext(); String path =
 * context.getRealPath(UPLOAD_DIRECTORY); System.out.println("path is : " +
 * path); String filename = file.getOriginalFilename();
 * 
 * if (!po.getDocFile().equals(file.getOriginalFilename())) {
 * System.out.println(" not equal.."); if (po.getDocFile().isEmpty() &&
 * !file.getOriginalFilename().isEmpty()) { // add new file try { byte barr[] =
 * file.getBytes();
 * 
 * BufferedOutputStream bout = new BufferedOutputStream(new
 * FileOutputStream(path + "/" + filename)); bout.write(barr);
 * 
 * po.setDocFile(filename);
 * 
 * bout.flush(); bout.close();
 * 
 * } catch (Exception e) { System.out.println(e); } } else if
 * (!po.getDocFile().isEmpty() && !file.getOriginalFilename().isEmpty()) { //
 * update document // remove old one
 * 
 * try { byte barr[] = file.getBytes();
 * 
 * BufferedOutputStream bout = new BufferedOutputStream(new
 * FileOutputStream(path + "/" + filename)); bout.write(barr);
 * 
 * po.setDocFile(filename);
 * 
 * bout.flush(); bout.close();
 * 
 * } catch (Exception e) { System.out.println(e); } } } else {
 * System.out.println("equal.."); }
 * 
 * purchaseOrderService.updatePurchaseOrder(po); return
 * "redirect:/purchaseorder/";
 * 
 * }
 * 
 * 
 * @GetMapping("/downloadfile") public void downloadFile(@PathVariable("")String
 * filename, HttpServletResponse response,HttpSession session){
 * 
 * 
 * response.setContentType("application/octet-stream"); String headerKey =
 * "Content-Disposition"; String headerValue = "attachment; filename = " +
 * filename); response.setHeader(headerKey, headerValue); ServletOutputStream
 * outputStream = response.getOutputStream();
 * 
 * outputStream.write(student.getContent()); outputStream.close();
 * 
 * }
 * 
 * 
 * @GetMapping("/list") public String listPurchaseOrder(Model model) {
 * 
 * List<PurchaseOrder> listPurchaseOrder =
 * purchaseOrderService.findAllOrderBy();
 * 
 * if (listPurchaseOrder != null) { model.addAttribute("listPurchaseOrder",
 * listPurchaseOrder); } return "layouts/listview/listofPurchaseOrder"; }
 * 
 * @GetMapping("/edit/{id}") public String editPurchaseOrder(@PathVariable("id")
 * String poCode, Model model) {
 * 
 * System.out.println("po code is : " + poCode);
 * 
 * List<QuotationDetail> lsitQuotationDetail = quotationDetailRepo.findAll();
 * model.addAttribute("lsitQuotationDetail", lsitQuotationDetail);
 * 
 * List<PartyMaster> partyMasterList = partyMasterService.getAllpartyMaster();
 * model.addAttribute("listParty", partyMasterList);
 * 
 * List<State> stateList = stateService.getAllState();
 * model.addAttribute("stateList", stateList);
 * 
 * List<OpenIndent> listOpenIndent = openIndentService.getAllOpenIndent();
 * model.addAttribute("listOpenIndent", listOpenIndent);
 * 
 * List<Item> listItem = itemService.getAllItem();
 * model.addAttribute("listItem", listItem);
 * 
 * PurchaseOrder po = purchaseOrderService.editPurchaseOrder(poCode).get();
 * 
 * // System.out.println("get item list : " + //
 * po.get().getListPurchaseOrderItem().get(0).getPacking());
 * 
 * model.addAttribute("purchaseOrder", po);
 * 
 * return "layouts/editview/editPurchaseOrder"; }
 * 
 * @GetMapping("/view/{id}") public String viewPurchaseOrder(@PathVariable("id")
 * String poCode, Model model) {
 * 
 * System.out.println("po code is : " + poCode);
 * 
 * List<QuotationDetail> lsitQuotationDetail = quotationDetailRepo.findAll();
 * model.addAttribute("lsitQuotationDetail", lsitQuotationDetail);
 * 
 * List<PartyMaster> partyMasterList = partyMasterService.getAllpartyMaster();
 * model.addAttribute("listParty", partyMasterList);
 * 
 * List<State> stateList = stateService.getAllState();
 * model.addAttribute("stateList", stateList);
 * 
 * List<OpenIndent> listOpenIndent = openIndentService.getAllOpenIndent();
 * model.addAttribute("listOpenIndent", listOpenIndent);
 * 
 * List<Item> listItem = itemService.getAllItem();
 * model.addAttribute("listItem", listItem);
 * 
 * PurchaseOrder po = purchaseOrderService.editPurchaseOrder(poCode).get();
 * 
 * // System.out.println("get item list : " + //
 * po.get().getListPurchaseOrderItem().get(0).getPacking());
 * 
 * model.addAttribute("purchaseOrder", po);
 * 
 * return "layouts/view/viewPurchaseOrder"; }
 * 
 * @GetMapping("/delete/{id}") public String
 * deletePurchaseOrder(@PathVariable("id") String purchaseOrderCode, Model
 * model) {
 * 
 * purchaseOrderService.deletePurchaseOrder(purchaseOrderCode); return
 * "redirect:/purchaseorder/list"; }
 * 
 * // AJAX Request
 * 
 * @ResponseBody
 * 
 * @GetMapping("/supplierDetail/{id}") public SupplierMaster
 * getSupplierInfo(@PathVariable(value = "id") String id, Model model) {
 * 
 * SupplierMaster supplier = supplierRepo.findBySupplierId(Long.parseLong(id));
 * System.out.println("supplier detail : " + supplier.getSupplierState());
 * return supplier;
 * 
 * }
 * 
 * @ResponseBody
 * 
 * @GetMapping("/quotationDetail/{id}") public QuotationPartyState
 * getQuotationInfo(@PathVariable(value = "id") String quotId, Model model) {
 * 
 * QuotationDetail quotationDetail = quotationDetailRepo.findById(quotId).get();
 * System.out.println("quotation detail : " + quotationDetail.getQuotDate());
 * PartyMaster party = null; if (quotationDetail.getSuplierCode() != null ||
 * quotationDetail.getSuplierCode() != "") {
 * 
 * party =
 * partyMasterService.editPartyMaster(quotationDetail.getSuplierCode()).get();
 * 
 * } QuotationPartyState quotationPartyState = new QuotationPartyState();
 * quotationPartyState.setQuotationDetail(quotationDetail);
 * quotationPartyState.setPartyMaster(party);
 * 
 * return quotationPartyState;
 * 
 * }
 * 
 * // Against Quotation Through
 * 
 * // list of indent against quotation
 * 
 * @ResponseBody
 * 
 * @GetMapping("/indentlist/{id}") public List<String>
 * getIndentList(@PathVariable(value = "id") String quotationId, Model model) {
 * 
 * System.out.println("get indent detail info"); QuotationDetail quotationDetail
 * = quotationDetailRepo.findById(quotationId).get();
 * 
 * // get RFQ from quotationdetail
 * 
 * System.out.println("rfq from quotation detauil : " +
 * quotationDetail.getRfqNo()); String rfqCode = quotationDetail.getRfqNo();
 * 
 * RfQuotation rfQuotation = rfQuotationRepo.findById(rfqCode).get();
 * 
 * List<String> listRfQuotationItem = new ArrayList<>();
 * 
 * for (RfQuotationItem rfquotationItem : rfQuotation.getListRFQuotation()) {
 * 
 * listRfQuotationItem.add(rfquotationItem.getOpenIndent().getIndentNumber());
 * // System.out.println("item spec : " + rfquotationItem.getItemSpec()); }
 * 
 * return listRfQuotationItem;
 * 
 * }
 * 
 * // detail of indent
 * 
 * @ResponseBody
 * 
 * @GetMapping("/indentdetail/{id}") public OpenIndent
 * getIndentDetail(@PathVariable(value = "id") String indentNum, Model model) {
 * 
 * OpenIndent openIndent = openIndentService.editOpenIndent(indentNum).get();
 * 
 * return openIndent;
 * 
 * }
 * 
 * // list of item against indent number
 * 
 * @ResponseBody
 * 
 * @GetMapping("/itemList/{indentNumber}") public List<Item>
 * ItemInfoByIndentNumber(@PathVariable(value = "indentNumber") String
 * indentNumber, Model model) {
 * 
 * System.out.println("indent number iinfo : " + indentNumber);
 * 
 * 
 * 1- get Open Indent Detail 2- fetch indent Detail from openIndent 2- get Item
 * Code which is in Indent Detail Entity by string formate
 * 
 * 
 * List<Item> listItem = new ArrayList<>(); OpenIndent openIndent =
 * openIndentRepo.findByIndentNumber(indentNumber);
 * 
 * for (OpenIndentDetail detail : openIndent.getOpeIndentDetail()) {
 * 
 * String itemCode = detail.getIndItemCode();
 * System.out.println("Item code is : " + itemCode);
 * 
 * Item item = itemService.editItem(itemCode).get();
 * 
 * System.out.println(" Item Info : " + item.getItemCode()); listItem.add(item);
 * }
 * 
 * return listItem;
 * 
 * }
 * 
 * // item list for in case of without indent and without quotation
 * 
 * @ResponseBody
 * 
 * @GetMapping("/itemList") public List<Item> itemList() {
 * 
 * System.out.println("item list handler  : ");
 * 
 * List<Item> itemList = itemService.getAllItem();
 * 
 * return itemList;
 * 
 * }
 * 
 * // item info which is in open indent detail table...
 * 
 * @ResponseBody
 * 
 * @GetMapping("/itemInfo/{itemCode}/{indentCode}") public ItemOpenIndentDetail
 * ItemInfoByItemCode(@PathVariable(value = "itemCode") String itemCode,
 * 
 * @PathVariable(value = "indentCode") String indentCode, Model model) {
 * 
 * System.out.println("item  iinfo : " + itemCode);
 * System.out.println("indent   iinfo : " + indentCode);
 * 
 * OpenIndent openIndent = openIndentService.editOpenIndent(indentCode).get();
 * 
 * // OpenIndentDetail findByIndItemCodeAndOpenIndent(String //
 * indentItemCode,OpenIndent openIndent); OpenIndentDetail openIndentDetail =
 * openIndentDetailRepo.findByIndItemCodeAndOpenIndent(itemCode, openIndent);
 * 
 * Item item = itemService.editItem(itemCode).get();
 * 
 * ItemOpenIndentDetail itemOpenIndentDetail = new ItemOpenIndentDetail();
 * 
 * itemOpenIndentDetail.setItem(item);
 * itemOpenIndentDetail.setOpenIndentDetail(openIndentDetail);
 * 
 * return itemOpenIndentDetail;
 * 
 * }
 * 
 * // in case of po == 'YES'
 * 
 * @ResponseBody
 * 
 * @GetMapping("/itemInfo/{id}") public Item itemInfo(@PathVariable("id") String
 * itemCode) {
 * 
 * Item item = itemService.editItem(itemCode).get();
 * 
 * System.out.println("item rate against item : " + item.getItemRate());
 * System.out.println("item dol from master : " + item.getDol()); return item;
 * 
 * }
 * 
 * // working // Against indent through
 * 
 * @ResponseBody
 * 
 * @GetMapping("/indent/indentdetail/") public List<String>
 * getIndentDetailByPurchaseThroughIndent() {
 * 
 * List<OpenIndent> listOpenIndent = openIndentService.getAllOpenIndent();
 * 
 * List<String> indentList = new ArrayList<>();
 * 
 * for (OpenIndent indent : listOpenIndent) {
 * 
 * indentList.add(indent.getIndentNumber()); //
 * System.out.println("item spec : " + rfquotationItem.getItemSpec()); }
 * 
 * return indentList; }
 * 
 * // get sipplier list/ party against quotation which is approved
 * 
 * // get supplier info by id
 * 
 * @ResponseBody
 * 
 * @GetMapping("/supplierInfo/{id}") public PartyStateCity
 * getPartyMasterAgainstQuotation(@PathVariable(value = "id") String partyId) {
 * 
 * // QuotationDetail quotation = PartyMaster partyMaster =
 * partyMasterService.editPartyMaster(partyId).get(); State state = null; City
 * city = null; if (partyMaster.getStateCode() != null ||
 * partyMaster.getStateCode() != "") { state =
 * stateService.editState(partyMaster.getStateCode()).get(); }
 * 
 * if (partyMaster.getCityCode() != null || partyMaster.getCityCode() != "") {
 * city = cityService.editCity(partyMaster.getCityCode()).get(); }
 * 
 * PartyStateCity partyStateCity = new PartyStateCity();
 * partyStateCity.setPartyMaster(partyMaster); partyStateCity.setState(state);
 * partyStateCity.setCity(city);
 * 
 * return partyStateCity; }
 * 
 * // Ajax for edit mode
 * 
 * @ResponseBody
 * 
 * @GetMapping("/edit/quotationDetail/{id}") public QuotationPartyState
 * getQuotationInfoEdit(@PathVariable(value = "id") String quotId, Model model)
 * {
 * 
 * QuotationDetail quotationDetail = quotationDetailRepo.findById(quotId).get();
 * System.out.println("quotation detail : " + quotationDetail.getQuotDate());
 * PartyMaster party = null; if (quotationDetail.getSuplierCode() != null ||
 * quotationDetail.getSuplierCode() != "") {
 * 
 * party =
 * partyMasterService.editPartyMaster(quotationDetail.getSuplierCode()).get();
 * 
 * } QuotationPartyState quotationPartyState = new QuotationPartyState();
 * quotationPartyState.setQuotationDetail(quotationDetail);
 * quotationPartyState.setPartyMaster(party);
 * 
 * return quotationPartyState;
 * 
 * }
 * 
 * @ResponseBody
 * 
 * @GetMapping("/edit/indentlist/{id}") public List<String>
 * getIndentListEdit(@PathVariable(value = "id") String quotationId, Model
 * model) {
 * 
 * System.out.println("get indent detail info"); QuotationDetail quotationDetail
 * = quotationDetailRepo.findById(quotationId).get();
 * 
 * // get RFQ from quotationdetail
 * 
 * System.out.println("rfq from quotation detauil : " +
 * quotationDetail.getRfqNo()); String rfqCode = quotationDetail.getRfqNo();
 * 
 * RfQuotation rfQuotation = rfQuotationRepo.findById(rfqCode).get();
 * 
 * List<String> listRfQuotationItem = new ArrayList<>();
 * 
 * for (RfQuotationItem rfquotationItem : rfQuotation.getListRFQuotation()) {
 * 
 * listRfQuotationItem.add(rfquotationItem.getOpenIndent().getIndentNumber());
 * // System.out.println("item spec : " + rfquotationItem.getItemSpec()); }
 * 
 * return listRfQuotationItem;
 * 
 * }
 * 
 * @ResponseBody
 * 
 * @GetMapping("/edit/supplierDetail/{id}") public SupplierMaster
 * getSupplierInfoEdit(@PathVariable(value = "id") String id, Model model) {
 * 
 * SupplierMaster supplier = supplierRepo.findBySupplierId(Long.parseLong(id));
 * System.out.println("supplier detail : " + supplier.getSupplierState());
 * return supplier;
 * 
 * }
 * 
 * @ResponseBody
 * 
 * @GetMapping("/edit/supplierInfo/{id}") public PartyStateCity
 * getPartyMasterAgainstQuotationEdit(@PathVariable(value = "id") String
 * partyId) {
 * 
 * // QuotationDetail quotation = PartyMaster partyMaster =
 * partyMasterService.editPartyMaster(partyId).get(); State state = null; City
 * city = null; if (partyMaster.getStateCode() != null ||
 * partyMaster.getStateCode() != "") { state =
 * stateService.editState(partyMaster.getStateCode()).get(); }
 * 
 * if (partyMaster.getCityCode() != null || partyMaster.getCityCode() != "") {
 * city = cityService.editCity(partyMaster.getCityCode()).get(); }
 * 
 * PartyStateCity partyStateCity = new PartyStateCity();
 * partyStateCity.setPartyMaster(partyMaster); partyStateCity.setState(state);
 * partyStateCity.setCity(city);
 * 
 * return partyStateCity; }
 * 
 * @ResponseBody
 * 
 * @GetMapping("/edit/indent/indentdetail/") public List<String>
 * getIndentDetailByPurchaseEditThroughIndent() {
 * 
 * List<OpenIndent> listOpenIndent = openIndentService.getAllOpenIndent();
 * 
 * List<String> indentList = new ArrayList<>();
 * 
 * for (OpenIndent indent : listOpenIndent) {
 * 
 * indentList.add(indent.getIndentNumber()); //
 * System.out.println("item spec : " + rfquotationItem.getItemSpec()); }
 * 
 * return indentList; }
 * 
 * /// Ajax for view mode
 * 
 * @ResponseBody
 * 
 * @GetMapping("/view/quotationDetail/{id}") public QuotationPartyState
 * getQuotationInfoView(@PathVariable(value = "id") String quotId, Model model)
 * {
 * 
 * QuotationDetail quotationDetail = quotationDetailRepo.findById(quotId).get();
 * System.out.println("quotation detail : " + quotationDetail.getQuotDate());
 * PartyMaster party = null; if (quotationDetail.getSuplierCode() != null ||
 * quotationDetail.getSuplierCode() != "") {
 * 
 * party =
 * partyMasterService.editPartyMaster(quotationDetail.getSuplierCode()).get();
 * 
 * } QuotationPartyState quotationPartyState = new QuotationPartyState();
 * quotationPartyState.setQuotationDetail(quotationDetail);
 * quotationPartyState.setPartyMaster(party);
 * 
 * return quotationPartyState;
 * 
 * }
 * 
 * @ResponseBody
 * 
 * @GetMapping("/view/indentlist/{id}") public List<String>
 * getIndentListView(@PathVariable(value = "id") String quotationId, Model
 * model) {
 * 
 * System.out.println("get indent detail info"); QuotationDetail quotationDetail
 * = quotationDetailRepo.findById(quotationId).get();
 * 
 * // get RFQ from quotationdetail
 * 
 * System.out.println("rfq from quotation detauil : " +
 * quotationDetail.getRfqNo()); String rfqCode = quotationDetail.getRfqNo();
 * 
 * RfQuotation rfQuotation = rfQuotationRepo.findById(rfqCode).get();
 * 
 * List<String> listRfQuotationItem = new ArrayList<>();
 * 
 * for (RfQuotationItem rfquotationItem : rfQuotation.getListRFQuotation()) {
 * 
 * listRfQuotationItem.add(rfquotationItem.getOpenIndent().getIndentNumber());
 * // System.out.println("item spec : " + rfquotationItem.getItemSpec()); }
 * 
 * return listRfQuotationItem;
 * 
 * }
 * 
 * 
 * @ResponseBody
 * 
 * @GetMapping("/view/supplierInfo/{id}") public PartyStateCity
 * getPartyMasterAgainstQuotationView(@PathVariable(value = "id") String
 * partyId) {
 * 
 * // QuotationDetail quotation = PartyMaster partyMaster =
 * partyMasterService.editPartyMaster(partyId).get(); State state = null; City
 * city = null; if (partyMaster.getStateCode() != null ||
 * partyMaster.getStateCode() != "") { state =
 * stateService.editState(partyMaster.getStateCode()).get(); }
 * 
 * if (partyMaster.getCityCode() != null || partyMaster.getCityCode() != "") {
 * city = cityService.editCity(partyMaster.getCityCode()).get(); }
 * 
 * PartyStateCity partyStateCity = new PartyStateCity();
 * partyStateCity.setPartyMaster(partyMaster); partyStateCity.setState(state);
 * partyStateCity.setCity(city);
 * 
 * return partyStateCity; }
 * 
 * }
 */