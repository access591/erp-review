package com.access.erp.controller.master;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Program;
import com.access.erp.model.master.SubModuleMaster;
import com.access.erp.model.master.UserRights;
import com.access.erp.repo.MyUserRepo;
import com.access.erp.repo.UserRightRepo;
import com.access.erp.repo.UserRoleRepo;
import com.access.erp.service.ModuleMasterService;
import com.access.erp.service.MyUserService;
import com.access.erp.service.ProgramService;
import com.access.erp.service.SubModuleMasterService;
import com.access.erp.service.UserRightsService;

@Controller
@RequestMapping("userrights")
public class UserRightsController {

	@Autowired UserRoleRepo userRoleRepo;
	@Autowired MyUserService myUserService;
	@Autowired ModuleMasterService moduleService;
	@Autowired SubModuleMasterService subModuleService;
	@Autowired ProgramService programService;
	@Autowired UserRightsService userRightsservice;
	@Autowired UserRightRepo userRightRepo;
	
	
	
	@GetMapping("/")
	public String userRights(Model model) {
		
		model.addAttribute("userRights", new UserRights());
		
		List<MyUser> listMyUser = myUserService.getAllMyUser();
		model.addAttribute("listMyUser", listMyUser);
		
		List<ModuleMaster> listModule = moduleService.getAllModule();
		model.addAttribute("listModule", listModule);
		
		
		List<SubModuleMaster> listSubModule = subModuleService.getAllSubModule();
		model.addAttribute("listSubModule", listSubModule);
		
		List<Program> listProgram = programService.getAllProgram();
		model.addAttribute("listProgram", listProgram);
		
		
		
		
		return "layouts/Master/userRights";
		
	}
	
	
	@PostMapping("/")
	public String addUserRights(@ModelAttribute("userRights") UserRights userRights) {
		
		
		MyUser myUser = myUserService.editMyUser(userRights.getMyUser().getUserCode()).get();
		Program program = programService.editProgram(userRights.getPrgCode().getProgramCode()).get();
		
		boolean isUserRightExist = userRightRepo.existsByMyUserAndPrgCode(myUser, program);
		
		System.out.println("is user rights exists : " + isUserRightExist);
		
		if(!isUserRightExist) {
			userRightsservice.addUserRights(userRights);
		}
	
		
		
		return "redirect:/userrights/";
	}
	
	
	
	@GetMapping("/list")
	public String viewUserRight(Model model) {
		
		List<UserRights> userRightsyList = userRightsservice.getAllUserRights();
		
		if(userRightsyList != null) {
			model.addAttribute("userRightsyList", userRightsyList);
		}
		return "layouts/listview/listofUserRight";
	}
	
	@GetMapping("/edit/{id}")
	public String editUserRight(@PathVariable("id") Long usrRightCode,Model model) {
		
		List<MyUser> listMyUser = myUserService.getAllMyUser();
		model.addAttribute("listMyUser", listMyUser);
		
		List<ModuleMaster> listModule = moduleService.getAllModule();
		model.addAttribute("listModule", listModule);
		
		
		List<SubModuleMaster> listSubModule = subModuleService.getAllSubModule();
		model.addAttribute("listSubModule", listSubModule);
		
		List<Program> listProgram = programService.getAllProgram();
		model.addAttribute("listProgram", listProgram);
		
		
		UserRights userRight = userRightsservice.editUserRights(usrRightCode).get();
		model.addAttribute("userRights", userRight);
		return "layouts/editview/editUserRight";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUserRight(@PathVariable("id") Long usrRightCode,Model model,RedirectAttributes redirectAttributes) {
		userRightsservice.deleteUserRights(usrRightCode);
		
		redirectAttributes.addFlashAttribute("message", "Category  has been deleted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success"); 
		
		return "redirect:/userrights/list";
	}
}
