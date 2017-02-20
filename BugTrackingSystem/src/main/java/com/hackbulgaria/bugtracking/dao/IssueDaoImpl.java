package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hackbulgaria.bugtracking.entities.Developer;
import com.hackbulgaria.bugtracking.entities.Issue;

@Repository
public class IssueDaoImpl implements IssueDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Issue> getListOfIssues() {
		TypedQuery<Issue> query = entityManager.createQuery("SELECT i FROM Issue i", Issue.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean add(Issue issue) {
		entityManager.merge(issue);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		String sql = "SELECT i FROM Issue i WHERE id=" + id + "";
		List<Issue> issueToRemove = entityManager.createQuery(sql).getResultList();
		for (Issue d : issueToRemove) {
			entityManager.remove(d);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean edit(Issue issue) {
		Issue issuee = entityManager.find(Issue.class, issue.getId());

		issuee.setTitle(issue.getTitle());
		issuee.setDate(issue.getDate());
		issuee.setDescription(issue.getDescription());
		issuee.setPriority(issue.getPriority());
		issuee.setStatus(issue.getStatus());
		issuee.setType(issue.getType());
		issuee.setOwner(issue.getOwner());
		issuee.setOwner(issue.getOwner());
		return true;
	}

}
