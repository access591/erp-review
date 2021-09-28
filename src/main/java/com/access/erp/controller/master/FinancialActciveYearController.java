/*
 * package com.access.erp.controller.master;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.access.erp.model.master.FinancialActiveYear; import
 * com.access.erp.model.master.FinancialYear; import
 * com.access.erp.service.FinancialActiveYearService; import
 * com.access.erp.service.FinancialYearService;
 * 
 * @Controller
 * 
 * @RequestMapping("/financialactiveyear") public class
 * FinancialActciveYearController {
 * 
 * @Autowired FinancialActiveYearService financialActiveYearService;
 * 
 * 
 * 
 * @GetMapping("/") public String financialActiveYear(Model model) {
 * 
 * model.addAttribute("financialActiveYear", new FinancialActiveYear()); return
 * "layouts/Master/financialactiveyear"; }
 * 
 * @PostMapping("/") public String
 * addFinancialActiveYear(@ModelAttribute("financialActiveYear")
 * FinancialActiveYear financialActiveYear) {
 * 
 * financialActiveYearService.addFinancialActiveYear(financialActiveYear);
 * 
 * return "redirect:/financialactiveyear/"; }
 * 
 * @GetMapping("/list") public String viewFinancialActiveYear(Model model) {
 * 
 * List<FinancialActiveYear> financialActiveYearList =
 * financialActiveYearService.getAllFinancialActiveYear();
 * if(financialActiveYearList != null) {
 * model.addAttribute("financialActiveYearList", financialActiveYearList); }
 * return "layouts/listview/listofFinancialyear"; }
 * 
 * @GetMapping("/edit/{id}") public String
 * editFinancialActiveYear(@PathVariable("id") String financialCode,Model model)
 * {
 * 
 * 
 * 
 * Optional<FinancialActiveYear> financialActiveYear =
 * financialActiveYearService.editFinancialActiveYear(financialCode);
 * model.addAttribute("financialActiveYear", financialActiveYear); return
 * "layouts/editview/editfinancialyear"; }
 * 
 * @GetMapping("/delete/{id}") public String
 * deleteFianncialActiveYear(@PathVariable("id") String financialCode,Model
 * model) { financialActiveYearService.deleteFinanciaActivelYear(financialCode);
 * 
 * 
 * 
 * return "redirect:/financialactiveyear/list";
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 */