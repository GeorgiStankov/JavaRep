package com.hackbulgaria.bugtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackbulgaria.bugtracking.dao.IssueDao;
import com.hackbulgaria.bugtracking.entities.Issue;
import com.hackbulgaria.bugtracking.entities.Issue.IssueStatus;

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

	@Override
	public Issue getIssue(int id) {
		// TODO Auto-generated method stub
		for (Issue i : getIssues()) {
			if (i.getId() == id)
				return i;
		}

		return null;
	}

	@Override
	public List<Issue> getIssuesByStatus(IssueStatus status) {
		return IssueDao.getListOfIssuesByStatus(status);
	}
	
	@Override
	public List<Issue> getActiveIssues() {
		return IssueDao.getListOfActiveIssues();
	}

	@Override
	public void assignIssue(int id, int uid) {
		IssueDao.assign(id,uid);
		
	}

}
