package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.master.MyCaptcha;
import com.access.erp.utility.CaptchaUtil;


import cn.apiclub.captcha.Captcha;

//import cn.apiclub.captcha.Captcha;

@Controller
public class IndexController {

	@GetMapping("/login")
	public String loginPage(Model model) {

		System.out.println("welcome");
		
		MyCaptcha myCaptcha = new MyCaptcha();
		getCaptcha(myCaptcha);
		
		System.out.println("retrun captcha");
		model.addAttribute("myCaptcha", myCaptcha);
		
		
		return "layouts/login";
	}

	
	private void getCaptcha(MyCaptcha myCaptcha) {
		
		Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
		myCaptcha.setHiddenCaptcha(captcha.getAnswer());

		myCaptcha.setCaptcha(""); // value entered by the User
		myCaptcha.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));

	}
	
	

}
