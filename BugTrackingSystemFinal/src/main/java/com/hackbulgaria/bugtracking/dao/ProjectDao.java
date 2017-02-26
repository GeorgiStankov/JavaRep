package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Project;

public interface ProjectDao {

		List<Project> getListOfProjects();

		public boolean add(Project project);

		public boolean delete(int id);

		public boolean edit(Project project);
		
		public Project getProject(int id);
}
