package com.hackbulgaria.bugtracking.services;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Project;

public interface ProjectService {

	public List<Project> getProjects();
	
	public boolean addProject(Project project);

	public boolean deleteProject(int id);

	public boolean editProject(Project project);
	
	public Project getProject(int id);
}
