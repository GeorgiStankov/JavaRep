package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Developer;

public interface DevDao {

	List<Developer> getListOfDevs();

	public boolean add(Developer dev);

	public boolean delete(int id);

	public boolean edit(int id);
	// TODO search by
	// public boolean search(?);

}
