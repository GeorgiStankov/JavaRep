package com.hackbulgaria.bugtracking.services;

import java.util.List;


import com.hackbulgaria.bugtracking.entities.Developer;

public interface DeveloperService {
	public List<Developer> getDevelopers();
	public boolean addDeveloper(Developer dev);

	public boolean deleteDeveloper(int id);

	public boolean editDeveloper(Developer dev);
	// TODO search by ...
	// public boolean searchDeveloper();

}
