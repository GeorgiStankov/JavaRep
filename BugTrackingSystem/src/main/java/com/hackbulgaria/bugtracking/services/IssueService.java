package com.hackbulgaria.bugtracking.services;

import com.hackbulgaria.bugtracking.entities.Developer;

public interface IssueService {
	public boolean createIssue(Developer dev);

	public boolean deleteIssue(int id);

	public boolean editIssue(int id);
	// TODO search by ...
	// public boolean searchIssue();
}
