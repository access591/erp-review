package com.access.erp.controller.master;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Program;
import com.access.erp.model.master.SubModuleMaster;
import com.access.erp.model.master.UserRights;
import com.access.erp.repo.ModuleMasterRepo;
import com.access.erp.repo.MyUserRepo;
import com.access.erp.repo.ProgramRepo;
import com.access.erp.repo.SubModuleRepo;
import com.access.erp.repo.UserRightRepo;
import com.access.erp.repo.UserRoleRepo;
import com.access.erp.service.ModuleMasterService;
import com.access.erp.service.MyUserService;
import com.access.erp.service.ProgramService;
import com.access.erp.service.SubModuleMasterService;
import com.access.erp.service.UserRightsService;
import com.access.erp.utility.SubModuleProgram;

@Controller
@RequestMapping("userrights")
public class UserRightsController {

	@Autowired
	UserRoleRepo userRoleRepo;
	@Autowired
	MyUserService myUserService;
	@Autowired
	ModuleMasterService moduleService;
	@Autowired
	SubModuleMasterService subModuleService;
	@Autowired
	ProgramService programService;
	@Autowired
	UserRightsService userRightsservice;
	@Autowired
	UserRightRepo userRightRepo;
	@Autowired
	MyUserRepo myUserRepo;
	@Autowired
	ModuleMasterRepo moduleMasterRepo;
	@Autowired
	SubModuleRepo subModuleRepo;
	@Autowired
	ProgramRepo programRepo;

	@GetMapping("/")
	public String userRights(Model model) {

		model.addAttribute("userRights", new UserRights());

		List<MyUser> listMyUser = myUserRepo.findByActive("Y");
		model.addAttribute("listMyUser", listMyUser);

		List<ModuleMaster> listModule = moduleMasterRepo.findByActive("Y");
		model.addAttribute("listModule", listModule);

		/*
		 * List<SubModuleMaster> listSubModule = subModuleService.getAllSubModule();
		 * model.addAttribute("listSubModule", listSubModule);
		 * 
		 * List<Program> listProgram = programService.getAllProgram();
		 * model.addAttribute("listProgram", listProgram);
		 */

		return "layouts/Master/userRights";

	}

	@PostMapping("/")
	public String addUserRights(HttpServletRequest request) {

		// @ModelAttribute("userRights") UserRights userRights

		String userCode = request.getParameter("userCode");
		String moduleCode = request.getParameter("moduleCode");
		String subModuleCode = request.getParameter("subModuleCode");
		String programCode = request.getParameter("programCode");

		System.out.println("user  typ : " + userCode);
		System.out.println("module typ : " + moduleCode);
		System.out.println("sub module  typ : " + subModuleCode);
		System.out.println("program typ : " + programCode);

		MyUser myUser = myUserService.editMyUser(userCode).get();
		ModuleMaster moduleMaster = moduleMasterRepo.findById(moduleCode).get();

		if (subModuleCode == "all" || subModuleCode.equals("all")) {
			System.out.println("all submodule from a module ");

			

			List<Program> programList = programRepo.findByModuleAndActive(moduleMaster, "Y");

			for (Program prog : programList) {

				boolean isUserRightExist = userRightRepo.existsByMyUserAndPrgCode(myUser, prog);

				if (!isUserRightExist) {

					UserRights uRight = new UserRights();
					uRight.setMyUser(myUser);
					uRight.setModule(moduleMaster);
					uRight.setPrgCode(prog);
					userRightsservice.addUserRights(uRight);

				}
			}
		}

		else if (programCode == "all" || programCode.equals("all")) {
			System.out.println("all program from a sub-module ");
			
			if(subModuleCode.equals("a")) {
				
				List<Program> programList = programRepo.findByModuleAndActive(moduleMaster, "Y");

				for (Program prog : programList) {

					boolean isUserRightExist = userRightRepo.existsByMyUserAndPrgCode(myUser, prog);

					if (!isUserRightExist) {

						UserRights uRight = new UserRights();
						uRight.setMyUser(myUser);
						uRight.setModule(moduleMaster);
						uRight.setPrgCode(prog);
						userRightsservice.addUserRights(uRight);

					}
				}
				
			
			}else {
				
				SubModuleMaster subModuleMaster = subModuleRepo.findById(subModuleCode).get();

				List<Program> programList = programRepo.findBySubModuleMasterAndActive(subModuleMaster, "Y");

				for (Program prog : programList) {

					boolean isUserRightExist = userRightRepo.existsByMyUserAndPrgCode(myUser, prog);

					if (!isUserRightExist) {

						UserRights uRight = new UserRights();
						uRight.setMyUser(myUser);
						uRight.setModule(moduleMaster);
						uRight.setPrgCode(prog);
						userRightsservice.addUserRights(uRight);

					}
				}
				
			}

			

		}

		else {
			System.out.println("single program code ");
			
			Program program = programRepo.findById(programCode).get();
			
			boolean isUserRightExist = userRightRepo.existsByMyUserAndPrgCode(myUser, program);
			
			if(!isUserRightExist) {
				
				UserRights uRight = new UserRights();
				uRight.setMyUser(myUser);
				
				
				uRight.setModule(moduleMaster);
				uRight.setPrgCode(program);
				userRightsservice.addUserRights(uRight);
				
			}
		}

		/*
		 * Program program =
		 * programService.editProgram(userRights.getPrgCode().getProgramCode()).get();
		 * 
		 * boolean isUserRightExist = userRightRepo.existsByMyUserAndPrgCode(myUser,
		 * program);
		 * 
		 * System.out.println("is user rights exists : " + isUserRightExist);
		 * 
		 * if (!isUserRightExist) { userRightsservice.addUserRights(userRights); }
		 */

		return "redirect:/userrights/";
	}

	@GetMapping("/list")
	public String viewUserRight(Model model) {

		List<UserRights> userRightsyList = userRightsservice.getAllUserRights();

		if (userRightsyList != null) {
			model.addAttribute("userRightsyList", userRightsyList);
		}
		return "layouts/listview/listofUserRight";
	}

	@GetMapping("/edit/{id}")
	public String editUserRight(@PathVariable("id") Long usrRightCode, Model model) {

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
	public String deleteUserRight(@PathVariable("id") Long usrRightCode, Model model,
			RedirectAttributes redirectAttributes) {
		userRightsservice.deleteUserRights(usrRightCode);

		redirectAttributes.addFlashAttribute("message", "Category  has been deleted successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");

		return "redirect:/userrights/list";
	}

	// AJAX

	@ResponseBody
	@GetMapping("/getsubmodule/{moduleCode}")
	public SubModuleProgram getSubModuleAgainstModule(@PathVariable("moduleCode") String moduleCode) {

		ModuleMaster module = moduleMasterRepo.findById(moduleCode).get();

		List<SubModuleMaster> subModuleList = subModuleRepo.findByModuleMasterAndActive(module, "Y");

		SubModuleProgram subModuleProgram = new SubModuleProgram();
		subModuleProgram.setSubModuleList(subModuleList);

		List<Program> programMasterList = programRepo.findByModuleAndActive(module, "Y");

		subModuleProgram.setProgramList(programMasterList);

		return subModuleProgram;
	}

	@ResponseBody
	@GetMapping("/subModule/{subModuleCode}")
	public List<Program> getProgramAgainstSubModule(@PathVariable("subModuleCode") String subModuleCode) {

		System.out.println("submodule code is : " + subModuleCode);

		SubModuleMaster subModuleMaster = subModuleService.editSubModule(subModuleCode).get();
		System.out.println("sub module master is : " + subModuleMaster.getSubModuleCode());

		List<Program> programList = programRepo.findBySubModuleMasterAndActive(subModuleMaster, "Y");

		System.out.println("program list size  : " + programList.size());

		return programList;
	}
	
	
	
	@ResponseBody
	@GetMapping("/getprogam/{moduleCode}")
	public List<Program> getProgramAgainstModule(@PathVariable("moduleCode") String moduleCode) {
	
		ModuleMaster module = moduleMasterRepo.findById(moduleCode).get();
		
		List<Program> programMasterList = programRepo.findByModuleAndActive(module, "Y");

		return programMasterList;
	}

}
