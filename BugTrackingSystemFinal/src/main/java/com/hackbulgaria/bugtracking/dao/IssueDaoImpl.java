package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hackbulgaria.bugtracking.entities.Developer;
import com.hackbulgaria.bugtracking.entities.Issue;
import com.hackbulgaria.bugtracking.entities.Issue.IssueStatus;

@Repository
public class IssueDaoImpl implements IssueDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Issue> getListOfIssues() {
		TypedQuery<Issue> query = entityManager.createQuery("SELECT i FROM Issue i order by i.date desc", Issue.class);
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
	
	@Override
	public List<Issue> getListOfIssuesByStatus(IssueStatus status) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Issue> criteriaQuery = criteriaBuilder.createQuery(Issue.class);
		Root<Issue> from = criteriaQuery.from(Issue.class);
		
		if(status != null) {
			criteriaQuery.where(from.get("status").in(status));
		}
		criteriaQuery.select(from);
		TypedQuery<Issue> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@Override
	public List<Issue> getListOfActiveIssues() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Issue> criteriaQuery = criteriaBuilder.createQuery(Issue.class);
		Root<Issue> from = criteriaQuery.from(Issue.class);
//		Predicate equal = criteriaBuilder.notEqual(from.get("owner"), from.get("creator"));
		Predicate active = criteriaBuilder.equal(from.get("status"), IssueStatus.NEW);
		if(!getListOfIssues().isEmpty()) {
			criteriaQuery.where(active);
		}
		criteriaQuery.select(from);
		TypedQuery<Issue> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public int getResolvedIssuesCount() {
		return getListOfIssuesByStatus(IssueStatus.RESOLVED).size();
	}

	@Override
	@Transactional
	public void assign(int id, int uid) {
		Issue issue = entityManager.find(Issue.class, id);
		issue.setOwner(uid);
		issue.setStatus(IssueStatus.PROGRESSING);
	}
}
