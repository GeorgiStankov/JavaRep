package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Issue;

public interface IssueDao {

		List<Issue> getListOfIssues();

		public boolean add(Issue issue);

		public boolean delete(int id);

		public boolean edit(Issue issue);
		// TODO search by
		// public boolean search(?);


}
