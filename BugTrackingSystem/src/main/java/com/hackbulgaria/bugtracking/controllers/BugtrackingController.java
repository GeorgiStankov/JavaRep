package com.hackbulgaria.bugtracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hackbulgaria.bugtracking.entities.Developer;
import com.hackbulgaria.bugtracking.services.DeveloperService;


@Controller
public class BugtrackingController {

	@Autowired
	private DeveloperService devService;

	@RequestMapping(value = "/DevsRegistry", method = RequestMethod.GET)
	public String getDevelopers(Model model) {
		model.addAttribute("Devs", devService.getDevelopers());
		return "DevsRegistry";
	}
	@RequestMapping(value = "/addDeveloper", method = RequestMethod.GET)
	public String addDev() {
		return "addDeveloper";
	}
	@RequestMapping(value = "/addDeveloperSave", method = RequestMethod.POST)
	public String addPersonSave(Model model, @ModelAttribute(value = "SpringWeb") Developer dev) {
		devService.addDeveloper(dev);

		model.addAttribute("Devs", devService.getDevelopers());

		return "DevsRegistry";
	}
}
