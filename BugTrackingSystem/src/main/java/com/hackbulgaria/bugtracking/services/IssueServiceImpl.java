package com.hackbulgaria.bugtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackbulgaria.bugtracking.dao.IssueDao;
import com.hackbulgaria.bugtracking.entities.Issue;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueDao IssueDao;

	@Override
	public boolean createIssue(Issue issue) {
		IssueDao.add(issue);
		return true;
	}

	@Override
	public boolean deleteIssue(int id) {
		IssueDao.delete(id);
		return true;
	}

	@Override
	public boolean editIssue(Issue issue) {
		IssueDao.edit(issue);
		return true;
	}

	@Override
	public List<Issue> getIssues() {

		return IssueDao.getListOfIssues();
	}

}
