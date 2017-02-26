package com.hackbulgaria.bugtracking.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hackbulgaria.bugtracking.constant.UrlConstants;
import com.hackbulgaria.bugtracking.entities.Developer;
import com.hackbulgaria.bugtracking.entities.Issue.IssueStatus;
import com.hackbulgaria.bugtracking.entities.Project;
import com.hackbulgaria.bugtracking.services.DeveloperService;
import com.hackbulgaria.bugtracking.services.IssueService;
import com.hackbulgaria.bugtracking.services.MessageService;

@Controller
public class DeveloperController {

	@Autowired
	private DeveloperService devService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private IssueService issueService;

	@RequestMapping(value = UrlConstants.HOME, method = RequestMethod.GET)
	public String getHome(HttpSession session, Model model) {
		session.setAttribute("commentsCount", messageService.getMessages().size());
		session.setAttribute("activeCount", issueService.getActiveIssues().size());
		session.setAttribute("progressingCount", issueService.getIssuesByStatus(IssueStatus.PROGRESSING).size());
		session.setAttribute("resolvedCount", issueService.getIssuesByStatus(IssueStatus.RESOLVED).size());
		model.addAttribute("messages", messageService.getMessages());
		return "home";
	}

	@RequestMapping(value = UrlConstants.DEVELOPERS, method = RequestMethod.GET)
	public String getDevelopers(Model model) {
		model.addAttribute("Devs", devService.getDevelopers());
		return "developers";
	}

	@RequestMapping(value = UrlConstants.VIEW_DEV + "/{uid}", method = RequestMethod.GET)
	public String viewDeveloper(@PathVariable int uid, Model model) {
		model.addAttribute("dev", devService.getDeveloper(uid));
		return "view_developer";
	}

	@RequestMapping(value = UrlConstants.ADD_DEV, method = RequestMethod.GET)
	public String addDeveloper() {
		return "add_developer";
	}

	@RequestMapping(value = UrlConstants.ADD_DEV, method = RequestMethod.POST)
	public String addDeveloperSave(Model model, @ModelAttribute(value = "SpringWeb") Developer dev) {
		dev.setDate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date()));
		devService.addDeveloper(dev);

		model.addAttribute("Devs", devService.getDevelopers());

		return "developers";
	}

	@RequestMapping(value = UrlConstants.DELETE_DEV + "/{id}", method = RequestMethod.GET)
	public String removeDeveloperSave(Model model, @PathVariable int id) {

		if (devService.deleteDeveloper(id)) {
			devService.deleteDeveloper(id);
			model.addAttribute("Devs", devService.getDevelopers());

			return "developers";
		} else
			return "error";
	}

	@RequestMapping(value = UrlConstants.EDIT_DEV + "/{id}", method = RequestMethod.GET)
	public String editDeveloper(Model model, @PathVariable int id) {
		Developer dev = devService.getDeveloper(id);
		if (dev != null) {
			model.addAttribute("developer", dev);
			return "edit_developer";
		}

		return "error";
	}

	@RequestMapping(value = UrlConstants.EDIT_DEV + "/{id}", method = RequestMethod.POST)
	public String editDeveloperSave(Model model, @ModelAttribute(value = "SpringWeb") Developer dev,
			@PathVariable int id) {
		dev.setId(id);
		dev.setDate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date()));
		devService.editDeveloper(dev);

		model.addAttribute("Devs", devService.getDevelopers());

		return "developers";
	}
}
