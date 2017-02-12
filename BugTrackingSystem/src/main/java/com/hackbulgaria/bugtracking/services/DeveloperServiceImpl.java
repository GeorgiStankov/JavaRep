package com.hackbulgaria.bugtracking.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackbulgaria.bugtracking.dao.DevDao;
import com.hackbulgaria.bugtracking.entities.Developer;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	private DevDao DevDao;

	@Override
	public boolean addDeveloper(Developer dev) {
		DevDao.add(dev);
		return true;
	}

	@Override
	public boolean deleteDeveloper(int id) {
		DevDao.delete(id);
		return true;
	}

	@Override
	public boolean editDeveloper(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Developer> getDevelopers() {
		return DevDao.getListOfDevs();
	}

}
