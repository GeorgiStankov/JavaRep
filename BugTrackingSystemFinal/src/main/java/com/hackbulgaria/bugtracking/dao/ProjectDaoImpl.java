package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hackbulgaria.bugtracking.entities.Developer;
import com.hackbulgaria.bugtracking.entities.Issue;
import com.hackbulgaria.bugtracking.entities.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Project> getListOfProjects() {
		TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM Project p", Project.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean add(Project project) {
		entityManager.persist(project);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		String sql = "SELECT p FROM Project p WHERE id=" + id + "";
		List<Project> projectsToRemove = entityManager.createQuery(sql).getResultList();
		for (Project p : projectsToRemove) {
			entityManager.remove(p);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean edit(Project project) {

		Project _project = entityManager.find(Project.class, project.getId());

		_project.setDate(project.getDate());
		_project.setName(project.getName());
		_project.setTeadLeadID(project.getTeadLeadID());
		return true;
	}

	@Override
	@Transactional
	public Project getProject(int id) {
		return entityManager.find(Project.class, id);
	}

}
