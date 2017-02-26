package com.hackbulgaria.bugtracking.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hackbulgaria.bugtracking.constant.UrlConstants;
import com.hackbulgaria.bugtracking.entities.Developer;
import com.hackbulgaria.bugtracking.services.DeveloperService;
import com.mysql.jdbc.log.Log;

@Controller
public class LoginController {
	
	@Autowired
	private DeveloperService devService;
	
	@RequestMapping(value = UrlConstants.LOGIN, method = RequestMethod.GET)
	public String showLoginForm(){
		return "login";
	}
	
	@RequestMapping(value = UrlConstants.LOGIN, method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userName, 
			@RequestParam String password, HttpSession session, Model model) {
		Developer developer = devService.loginDeveloper(userName.replaceAll("\\+", " "), password);
		if (developer == null) {
			model.addAttribute("loginError","Error logging in. Please try again");
			return "login";
		}
		
		session.setAttribute("loggedInUser", developer);
		return "login";	
	}
	
	@RequestMapping(value = UrlConstants.LOGOUT, method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("loggedInUser");
		return "login";
	}
}
