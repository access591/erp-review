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

import com.access.erp.model.master.Program;
import com.access.erp.model.master.SubModuleMaster;
import com.access.erp.service.ProgramService;
import com.access.erp.service.SubModuleMasterService;

@Controller
@RequestMapping("program")
public class ProgramController {

	@Autowired
	ProgramService programService;
	@Autowired SubModuleMasterService subModuleService;
	

	@GetMapping("/")
	public String program(Model model) {

		List<SubModuleMaster> listSubModule = subModuleService.getAllSubModule();
		model.addAttribute("listSubModule", listSubModule);
		model.addAttribute("program", new Program());
		return "layouts/Master/program";
	}

	@PostMapping("/")
	public String addProgram(@ModelAttribute("program") Program program) {

		programService.addProgram(program);

		return "redirect:/program/";
	}

	@GetMapping("/list")
	public String viewProgramList(Model model) {

		List<Program> listProgram = programService.getAllProgram();

		if (listProgram != null) {
			model.addAttribute("listProgram", listProgram);
		}
		return "layouts/listview/listofprogram";
	}

	@GetMapping("/edit/{id}")
	public String editProgram(@PathVariable("id") String programCode, Model model) {

		System.out.println("module code is : " + programCode);
		List<SubModuleMaster> listSubModule = subModuleService.getAllSubModule();
		model.addAttribute("listSubModule", listSubModule);
		Optional<Program> program = programService.editProgram(programCode);
		model.addAttribute("program", program);
		return "layouts/editview/editProgram";
	}

	@GetMapping("/delete/{id}")
	public String deleteProgram(@PathVariable("id") String programCode, Model model) {
		programService.deleteProgram(programCode);
		return "redirect:/program/list";
	}

}
