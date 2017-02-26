package com.hackbulgaria.bugtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackbulgaria.bugtracking.dao.ProjectDao;
import com.hackbulgaria.bugtracking.entities.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public List<Project> getProjects() {
		return projectDao.getListOfProjects();
	}

	@Override
	public boolean addProject(Project project) {
		projectDao.add(project);
		return true;
	}

	@Override
	public boolean deleteProject(int id) {
		projectDao.delete(id);
		return true;
	}

	@Override
	public boolean editProject(Project project) {
		projectDao.edit(project);
		return true;
	}

	@Override
	public Project getProject(int id) {
		return projectDao.getProject(id);
	}

}
