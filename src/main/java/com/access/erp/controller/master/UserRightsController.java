package com.access.erp.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.UserRole;
import com.access.erp.repo.UserRoleRepo;
import com.access.erp.service.ModuleMasterService;
import com.access.erp.service.MyUserService;

@Controller
@RequestMapping("userrights")
public class UserRightsController {

	@Autowired UserRoleRepo userRoleRepo;
	@Autowired MyUserService myUserService;
	@Autowired ModuleMasterService moduleService;
	
	@GetMapping("/")
	public String userRights(Model model) {
		
		model.addAttribute("userRole", new UserRole());
		
		List<MyUser> listMyUser = myUserService.getAllMyUser();
		model.addAttribute("listMyUser", listMyUser);
		
		List<ModuleMaster> listModule = moduleService.getAllModule();
		model.addAttribute("listModule", listModule);
		
		
		
		
		
		
		
		return "layouts/Master/userRights";
		
	}
}
