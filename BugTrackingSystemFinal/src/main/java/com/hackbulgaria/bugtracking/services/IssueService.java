package com.hackbulgaria.bugtracking.services;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Issue;
import com.hackbulgaria.bugtracking.entities.Issue.IssueStatus;

public interface IssueService {
	public List<Issue> getIssues();

	public Issue getIssue(int id);

	public boolean createIssue(Issue issue);

	public boolean deleteIssue(int id);

	public boolean editIssue(Issue id);
	// TODO search by ...
	// public boolean searchIssue();

	List<Issue> getActiveIssues();

	List<Issue> getIssuesByStatus(IssueStatus status);

	public void assignIssue(int id, int uid);
}
