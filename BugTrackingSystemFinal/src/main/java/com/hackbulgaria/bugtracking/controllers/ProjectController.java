package com.hackbulgaria.bugtracking.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hackbulgaria.bugtracking.constant.UrlConstants;
import com.hackbulgaria.bugtracking.entities.Project;
import com.hackbulgaria.bugtracking.services.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = UrlConstants.PROJECTS, method = RequestMethod.GET)
	public String getProjects(Model model) {
		model.addAttribute("Projects", projectService.getProjects());
		return "projects";
	}

	@RequestMapping(value = UrlConstants.ADD_PROJECT, method = RequestMethod.GET)
	public String addProject() {
		return "add_project";
	}
	

	@RequestMapping(value = UrlConstants.ADD_PROJECT, method = RequestMethod.POST)
	public String addProjectSave(Model model, @ModelAttribute(value = "SpringWeb") Project project) {
		project.setDate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date()));

		projectService.addProject(project);
		model.addAttribute("Projects", projectService.getProjects());

		return "projects";
	}

	@RequestMapping(value = UrlConstants.DELETE_PROJECT + "/{id}", method = RequestMethod.GET)
	public String removeProject(Model model, @PathVariable int id) {

		if (projectService.deleteProject(id)) {
			projectService.deleteProject(id);
			
			model.addAttribute("Projects", projectService.getProjects());
			return "redirect:/projects";
		} else
			return "error";
	}
	
	@RequestMapping(value = UrlConstants.EDIT_PROJECT + "/{id}", method = RequestMethod.GET)
	public String editProject(@PathVariable int id, Model model) {
		Project project = projectService.getProject(id);
		if (project != null){
			model.addAttribute("project", project);
			return "edit_project";
		}
		
		return "error";
	}

	@RequestMapping(value = UrlConstants.EDIT_PROJECT + "/{id}", method = RequestMethod.POST)
	public String editProject(@PathVariable int id, Model model, @ModelAttribute(value = "SpringWeb") Project project) {
		project.setId(id);
		project.setDate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date()));
		projectService.editProject(project);

		model.addAttribute("Projects", projectService.getProjects());

		return "projects";
	}
}
