/*
 * package com.access.erp.controller;
 * 
 * import java.io.BufferedOutputStream; import java.io.FileOutputStream; import
 * java.util.List;
 * 
 * import javax.servlet.ServletContext; import javax.servlet.http.HttpSession;
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
 * org.springframework.web.servlet.mvc.support.RedirectAttributes;
 * 
 * import com.access.erp.model.ItemOpening; import
 * com.access.erp.model.MaterialRequisitionMaster; import
 * com.access.erp.model.master.Department; import
 * com.access.erp.model.master.Employee; import
 * com.access.erp.model.master.Item; import com.access.erp.model.master.Store;
 * import com.access.erp.service.DepartmentService; import
 * com.access.erp.service.EmployeeService; import
 * com.access.erp.service.ItemOpeningService; import
 * com.access.erp.service.ItemService; import
 * com.access.erp.service.MaterialRequisitionMasterService; import
 * com.access.erp.service.StoreService; import
 * com.access.erp.singleton.GlobalParameter; import
 * com.access.erp.utility.Item_itemOpening;
 * 
 * @Controller
 * 
 * @RequestMapping("/materialrequisition") public class
 * MaterialRequisitionController {
 * 
 * @Autowired EmployeeService employeeService;
 * 
 * @Autowired StoreService storeService;
 * 
 * @Autowired DepartmentService departmentService;
 * 
 * @Autowired MaterialRequisitionMasterService materialRequisitionMasterService;
 * 
 * @Autowired ItemService itemService;
 * 
 * @Autowired ItemOpeningService itemOpeningService;
 * 
 * @Autowired GlobalParameter globalParameter;
 * 
 * private static final String UPLOAD_DIRECTORY = "/img/requisition/uploads";
 * 
 * @GetMapping("/") public String materialRequisition(Model model) {
 * 
 * List<Employee> employeeList = employeeService.getAllEmployee();
 * model.addAttribute("employeeList", employeeList);
 * 
 * List<Store> storeList = storeService.getAllStore();
 * model.addAttribute("storeList", storeList);
 * 
 * List<Item> itemList = itemService.getAllItem();
 * model.addAttribute("itemList", itemList);
 * 
 * model.addAttribute("materialRequisition", new MaterialRequisitionMaster());
 * return "layouts/Master/materialRequisition"; }
 * 
 * @PostMapping("/") public String addMaterialRequisitionMaster(
 * 
 * @ModelAttribute("materialRequisition") MaterialRequisitionMaster
 * materialRequisition,HttpSession session,
 * 
 * @RequestParam("requisitionFile") MultipartFile file, RedirectAttributes
 * redirectAttributes) {
 * 
 * // boolean exists = companyRepo.existsById(company.getCompCode());
 * 
 * 
 * if (!exists) {
 * 
 * companyService.addCompany(company);
 * redirectAttributes.addFlashAttribute("message",
 * "Company  has been saved successfully! ");
 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
 * 
 * } else {
 * 
 * redirectAttributes.addFlashAttribute("message",
 * "Company Code Allready exists! Please try another One !!");
 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); }
 * 
 * 
 * ServletContext context = session.getServletContext(); String path =
 * context.getRealPath(UPLOAD_DIRECTORY);
 * 
 * 
 * String filename = file.getOriginalFilename();
 * 
 * if(file.isEmpty()) { materialRequisition.setDocFile("default");
 * 
 * }else {
 * 
 * try { byte barr[] = file.getBytes();
 * 
 * BufferedOutputStream bout = new BufferedOutputStream(new
 * FileOutputStream(path + "/" + filename)); bout.write(barr);
 * 
 * materialRequisition.setDocFile(filename);
 * 
 * bout.flush(); bout.close();
 * 
 * }
 * 
 * catch (Exception e) { System.out.println(e); }
 * 
 * }
 * 
 * materialRequisition.setFyYear(globalParameter.getFyYear());
 * materialRequisition.setMyUser(globalParameter.getMyUser());
 * materialRequisition.setcCode(globalParameter.getGlobalCompany());
 * 
 * materialRequisitionMasterService.addMaterialRequisitionMaster(
 * materialRequisition);
 * 
 * return "redirect:/materialrequisition/"; }
 * 
 * 
 * @PostMapping("/update") public String updateMaterialRequisitionMaster(
 * 
 * @ModelAttribute("materialRequisition") MaterialRequisitionMaster
 * materialRequisition,HttpSession session,
 * 
 * @RequestParam("requisitionFile") MultipartFile file, RedirectAttributes
 * redirectAttributes) {
 * 
 * ServletContext context = session.getServletContext(); String path =
 * context.getRealPath(UPLOAD_DIRECTORY);
 * 
 * 
 * String filename = file.getOriginalFilename();
 * 
 * if (!materialRequisition.getDocFile().equals(file.getOriginalFilename())) {
 * System.out.println(" not equal.."); if
 * (materialRequisition.getDocFile().isEmpty() &&
 * !file.getOriginalFilename().isEmpty()) { // add new file try { byte barr[] =
 * file.getBytes();
 * 
 * BufferedOutputStream bout = new BufferedOutputStream(new
 * FileOutputStream(path + "/" + filename)); bout.write(barr);
 * 
 * materialRequisition.setDocFile(filename);
 * 
 * bout.flush(); bout.close();
 * 
 * } catch (Exception e) { System.out.println(e); } } else if
 * (!materialRequisition.getDocFile().isEmpty() &&
 * !file.getOriginalFilename().isEmpty()) { // update document // remove old one
 * 
 * try { byte barr[] = file.getBytes();
 * 
 * BufferedOutputStream bout = new BufferedOutputStream(new
 * FileOutputStream(path + "/" + filename)); bout.write(barr);
 * 
 * materialRequisition.setDocFile(filename);
 * 
 * bout.flush(); bout.close();
 * 
 * } catch (Exception e) { System.out.println(e); } } } else {
 * System.out.println("equal.."); }
 * 
 * 
 * materialRequisition.setFyYear(globalParameter.getFyYear());
 * materialRequisition.setMyUser(globalParameter.getMyUser());
 * materialRequisition.setcCode(globalParameter.getGlobalCompany());
 * 
 * materialRequisitionMasterService.addMaterialRequisitionMaster(
 * materialRequisition);
 * 
 * return "redirect:/materialrequisition/"; }
 * 
 * 
 * @GetMapping("/list") public String viewMaterialRequisitionList(Model model) {
 * 
 * List<MaterialRequisitionMaster> listMaterialRequisition =
 * materialRequisitionMasterService .getAllMaterialRequisitionMaster();
 * 
 * if (listMaterialRequisition != null) {
 * model.addAttribute("listMaterialRequisition", listMaterialRequisition); }
 * return "layouts/listview/listofmaterialrequisition"; }
 * 
 * @GetMapping("/edit/{id}") public String
 * editMaterialRequisition(@PathVariable("id") String requisitionNo, Model
 * model) {
 * 
 * MaterialRequisitionMaster materialRequisition =
 * materialRequisitionMasterService
 * .editMaterialRequisitionMaster(requisitionNo).get();
 * model.addAttribute("materialRequisition", materialRequisition);
 * 
 * return "layouts/editview/editMaterialRequisition"; }
 * 
 * @GetMapping("/delete/{id}") public String
 * deleteMaterialRequisition(@PathVariable("id") String requisitionNo, Model
 * model) {
 * 
 * materialRequisitionMasterService.deleteMaterialRequisitionMaster(
 * requisitionNo); return "redirect:/materialrequisition/list"; }
 * 
 * @GetMapping("/approval") public String materialRequisitionApproval(Model
 * model) {
 * 
 * // materialRequisitionMasterService.deleteMaterialRequisitionMaster(
 * requisitionNo);
 * 
 * List<MaterialRequisitionMaster> materialRequisition =
 * materialRequisitionMasterService .getAllMaterialRequisitionMaster();
 * model.addAttribute("requisition", materialRequisition);
 * 
 * return "layouts/Master/materialRequisitionApproval"; }
 * 
 * @GetMapping("/approved/{reqNum}/{status}") public String
 * approvedMaterialRequisition(@PathVariable(value = "reqNum") String reqNum,
 * 
 * @PathVariable(value = "status") String status, Model model) {
 * 
 * System.out.println("requisition number : " + reqNum);
 * 
 * System.out.println("status is : " + status);
 * 
 * materialRequisitionMasterService.materialRequisitionApproval(reqNum, status);
 * 
 * // List<MaterialRequisitionMaster> materialRequisition = //
 * materialRequisitionMasterService.getAllMaterialRequisitionMaster(); //
 * model.addAttribute("requisition", materialRequisition);
 * 
 * return "redirect:/materialrequisition/approval"; }
 * 
 * @ResponseBody
 * 
 * @GetMapping("/employeeinfo/{id}") public Department
 * getDeptByEmp(@PathVariable(value = "id") String empCode) {
 * 
 * Employee employee = employeeService.editEmployee(empCode).get();
 * 
 * Department department = new Department();
 * 
 * if (employee.getDepartment() != null) {
 * 
 * department.setDeptCode(employee.getDepartment().getDeptCode());
 * department.setDeptName(employee.getDepartment().getDeptName()); }
 * 
 * return department; }
 * 
 * @ResponseBody
 * 
 * @GetMapping("/itemInfo/{id}") public Item_itemOpening
 * getItemInfo(@PathVariable(value = "id") String itemCode) {
 * 
 * Item item = itemService.editItem(itemCode).get(); ItemOpening itemOpening =
 * itemOpeningService.editItemOpening(itemCode).get();
 * 
 * Item_itemOpening itemItemOpening = new Item_itemOpening();
 * itemItemOpening.setItem(item); itemItemOpening.setItemOpening(itemOpening);
 * return itemItemOpening; }
 * 
 * }
 */