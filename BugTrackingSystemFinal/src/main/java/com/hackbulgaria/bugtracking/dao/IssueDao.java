package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Issue;
import com.hackbulgaria.bugtracking.entities.Issue.IssueStatus;

public interface IssueDao {

	List<Issue> getListOfIssues();

	public boolean add(Issue issue);

	public boolean delete(int id);

	public boolean edit(Issue issue);
	// TODO search by
	// public boolean search(?);

	List<Issue> getListOfIssuesByStatus(IssueStatus status);

	int getResolvedIssuesCount();

	List<Issue> getListOfActiveIssues();

	void assign(int id, int uid);

}
