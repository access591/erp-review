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

import com.access.erp.model.master.Employee;
import com.access.erp.model.master.MyUser;
import com.access.erp.service.EmployeeService;
import com.access.erp.service.MyUserService;

@Controller
@RequestMapping("/user")
public class MyUserController {
	
	@Autowired EmployeeService employeeService;
	@Autowired MyUserService userService;
	
	
	@GetMapping("/")
	public String user(Model model) { 
		
		//List<MyUser> userList = userService.getAllMyUser();
		//model.addAttribute("userList", userList);
		
		List<Employee> listEmployee = employeeService.getAllEmployee();
		
		System.out.println("employee info is : " + listEmployee.get(0).getEmpName());
		model.addAttribute("listEmployee", listEmployee);
		
		model.addAttribute("user", new MyUser());
		return "layouts/Master/userMaster";
	}
	
	@PostMapping("/")
	public String addUser(@ModelAttribute("user") MyUser user) {
		
		System.out.println("add method of my user controller");
		userService.addMyUSer(user);
		
		return "redirect:/user/";
	}
	
	@GetMapping("/list")
	public String viewUserList(Model model) {
		
		List<MyUser> userList = userService.getAllMyUser();
		
		if(userList != null) {
			model.addAttribute("listMyUser", userList);
		}
		return "layouts/listview/listofuser";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id") String userCode,Model model) {
		
		System.out.println("module code is : "+ userCode);
		

		Optional<MyUser> user = userService.editMyUser(userCode);
		model.addAttribute("user", user);
		return "layouts/editview/editUser";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") String userCode,Model model) {
		userService.deleteMyUser(userCode);
		return "redirect:/user/list";
	}

}
