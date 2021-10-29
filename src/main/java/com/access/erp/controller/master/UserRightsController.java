package com.access.erp.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.master.Category;
import com.access.erp.model.master.ModuleMaster;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Program;
import com.access.erp.model.master.SubModuleMaster;
import com.access.erp.model.master.UserRights;
import com.access.erp.model.master.UserRole;
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
		
		userRightsservice.addUserRights(userRights);
		
		
		return "redirect:/userrights/";
	}
}
