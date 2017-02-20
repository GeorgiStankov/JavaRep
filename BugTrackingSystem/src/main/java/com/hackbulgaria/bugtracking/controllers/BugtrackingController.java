package com.hackbulgaria.bugtracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hackbulgaria.bugtracking.constant.UrlConstants;
import com.hackbulgaria.bugtracking.entities.Developer;
import com.hackbulgaria.bugtracking.services.DeveloperService;

@Controller
public class BugtrackingController {

	@Autowired
	private DeveloperService devService;
	
	@RequestMapping(value = UrlConstants.DEVS_REGISTER_URL, method = RequestMethod.GET)
	public String getDevelopers(Model model) {
		model.addAttribute("Devs", devService.getDevelopers());
		return "DevsRegistry";
	}

	@RequestMapping(value = UrlConstants.ACTIONS_URL, method = RequestMethod.GET)
	public String addDev() {
		return "actionsDeveloper";
	}

	@RequestMapping(value = UrlConstants.ADD_DEV_SAVE_URL, method = RequestMethod.POST)
	public String addDeveloperSave(Model model, @ModelAttribute(value = "SpringWeb") Developer dev) {
		devService.addDeveloper(dev);

		model.addAttribute("Devs", devService.getDevelopers());

		return "actionsDeveloper";
	}

	@RequestMapping(value = UrlConstants.REMOVE_DEV_SAVE_URL, method = RequestMethod.GET)
	public String removeDeveloperSave(Model model, String id) {

		if (devService.deleteDeveloper(Integer.parseInt(id))) {
			devService.deleteDeveloper(Integer.parseInt(id));
			model.addAttribute("Devs", devService.getDevelopers());

			return "DevsRegistry";
		} else
			return "error";
	}

	@RequestMapping(value = UrlConstants.EDIT_DEV_SAVE_URL, method = RequestMethod.POST)
	public String editDeveloperSave(Model model, @ModelAttribute(value = "SpringWeb") Developer dev) {
		devService.editDeveloper(dev);

		model.addAttribute("Devs", devService.getDevelopers());

		return "actionsDeveloper";
	}


}
