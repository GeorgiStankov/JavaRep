package com.hackbulgaria.bugtracking.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hackbulgaria.bugtracking.constant.UrlConstants;
import com.hackbulgaria.bugtracking.entities.Developer;
import com.hackbulgaria.bugtracking.entities.Issue;
import com.hackbulgaria.bugtracking.entities.Issue.IssueStatus;
import com.hackbulgaria.bugtracking.entities.Issue.Priority;
import com.hackbulgaria.bugtracking.entities.Issue.Type;
import com.hackbulgaria.bugtracking.services.IssueService;

@Controller
public class IssuesController {

	@Autowired
	private IssueService issueService;

	@RequestMapping(value = "/issues", method = RequestMethod.GET)
	public String getIssues(Model model) {
		model.addAttribute("Issues", issueService.getIssues());
		return "issues";
	}
	
	@RequestMapping(value = UrlConstants.RESOLVED_ISSUES, method = RequestMethod.GET)
	public String getResolvedIssues(Model model) {
		model.addAttribute("Issues", issueService.getIssuesByStatus(IssueStatus.RESOLVED));
		return "issues"; 
	}
	
	@RequestMapping(value = UrlConstants.ASSIGNED_ISSUES, method = RequestMethod.GET)
	public String getAssignedIssues(Model model) {
		model.addAttribute("Issues", issueService.getIssuesByStatus(IssueStatus.PROGRESSING));
		return "issues"; 
	}
	
	@RequestMapping(value = UrlConstants.ACTIVE_ISSUES, method = RequestMethod.GET)
	public String getActiveIssues(Model model) {
		model.addAttribute("Issues", issueService.getActiveIssues());
		return "issues"; 
}
	
	@RequestMapping(value = UrlConstants.ADD_ISSUE, method = RequestMethod.GET)
	public String addDev() {
		return "add_issue";
	}

	@RequestMapping(value = UrlConstants.ADD_ISSUE, method = RequestMethod.POST)
	public String addDeveloperSave(HttpSession session, Model model, @ModelAttribute(value = "SpringWeb") Issue issue) {
		issue.setDate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date()));
		issue.setCreator(1);
		issue.setOwner(1);
		issue.setStatus(IssueStatus.NEW);
		issue.setPriority(Priority.MEDIUM);
		issue.setType(Type.DEFECT);
		
		issueService.createIssue(issue);

		model.addAttribute("Issues", issueService.getIssues());

		return "redirect:/issues";
	}
	
	@RequestMapping(value = UrlConstants.DELETE_ISSUE + "/{id}", method = RequestMethod.GET)
	public String deleteIssue(@PathVariable int id, Model model) {
		issueService.deleteIssue(id);
		model.addAttribute("Issue", issueService.getIssues());
		return "redirect:/issues";
	}
	
	@RequestMapping(value = UrlConstants.EDIT_ISSUE + "/{id}", method = RequestMethod.GET)
	public String editIssue(@PathVariable int id, Model model) {
		Issue issue = issueService.getIssue(id);
		
		if (issue != null){
			model.addAttribute("issue",issue);
			return "edit_issue";
		}
		
		return "error";
	}
	
	@RequestMapping(value = UrlConstants.EDIT_ISSUE + "/{id}" + "/{cid}" + "/{oid}" + "{/type}" + "/{status}" + "/{priority}", method = RequestMethod.POST)
	public String editDeveloperSave(@PathVariable int id, 
			@PathVariable int cid,
			@PathVariable int oid, 
			@PathVariable String type,
			@PathVariable String status,
			@PathVariable String priority, Model model, @ModelAttribute(value = "SpringWeb") Issue issue) {
		issue.setType(Type.valueOf(type));
		issue.setStatus(IssueStatus.valueOf(status));
		issue.setPriority(Priority.valueOf(priority));
		issue.setCreator(cid);
		issue.setOwner(oid);
		issue.setId(id);
		issueService.editIssue(issue);
		model.addAttribute("Issue", issueService.getIssues());

		return "redirect:/issues";
	}

	@RequestMapping (value = UrlConstants.ASSIGN_ISSUE + "/{id}", method = RequestMethod.GET)
	public String assignIssue(@PathVariable int id, Model model) {
		issueService.assignIssue(id,1);
		return "redirect:/issues";
	}
/*	@RequestMapping(value = UrlConstants.R, method = RequestMethod.GET)
	public String removeDeveloperSave(Model model, String id) {

		if (issueService.deleteIssue(Integer.parseInt(id))) {
			issueService.deleteIssue(Integer.parseInt(id));
			model.addAttribute("Devs", issueService.getIssues());

			return "IssuesRegistry";
		} else
			return "error";
	}

	
	}*/

}