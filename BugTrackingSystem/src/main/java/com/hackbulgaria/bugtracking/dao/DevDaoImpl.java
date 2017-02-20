package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hackbulgaria.bugtracking.entities.Developer;

@Repository
public class DevDaoImpl implements DevDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Developer> getListOfDevs() {
		TypedQuery<Developer> query = entityManager.createQuery("SELECT s FROM Developer s", Developer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean add(Developer dev) {
		entityManager.merge(dev);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		String sql = "SELECT d FROM Developer d WHERE id=" + id + "";
		List<Developer> personToRemove = entityManager.createQuery(sql).getResultList();
		for (Developer d : personToRemove) {
			entityManager.remove(d);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean edit(Developer dev) {
		Developer developer = entityManager.find(Developer.class, dev.getId());
		
		developer.setName(dev.getName());
		developer.setRole(dev.getRole());
		developer.setDate(dev.getDate());
		developer.setTeadLeadID(dev.getTeadLeadID());
		return true;
	}

}
