package com.hackbulgaria.bugtracking.services;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Issue;

public interface IssueService {
	public List<Issue> getIssues();
	
	public boolean createIssue(Issue issue);

	public boolean deleteIssue(int id);

	public boolean editIssue(Issue id);
	// TODO search by ...
	// public boolean searchIssue();
}
