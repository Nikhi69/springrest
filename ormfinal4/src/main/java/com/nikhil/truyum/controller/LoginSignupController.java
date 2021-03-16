package com.nikhil.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nikhil.truyum.dao.LoginValidtion;


@Controller
public class LoginSignupController {
	@Autowired
	LoginValidtion loginValid;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String welcome(ModelMap model, @RequestParam String uname, @RequestParam String pwd) {
		String[] user = loginValid.validate(uname, pwd);
		if(user[0].equalsIgnoreCase("Admin")) {
			return "redirect:/adminlist";
		}
		else if(user[0].equalsIgnoreCase("User")) {
			return "redirect:/customerlist";
		}
		
		else {
			return "login";
		}
	}

	@RequestMapping("/signup")
	public String signupPage() {
		return "signup";
	}
	@RequestMapping(value="/signupsuccess",method=RequestMethod.POST)
	public String signupsuccessPage() {
		return "signupsuccess";
	}
	
}
