package com.hackbulgaria.bugtracking.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hackbulgaria.bugtracking.entities.Message;

@Repository
public class MessageDaoImpl implements MessageDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Message> getListOfMessages() {
		TypedQuery<Message> msgQuery = entityManager.createQuery("Select msg from Message msg", Message.class);
		return msgQuery.getResultList();
	}

	@Override
	@Transactional
	public boolean add(Message msg) {
		java.util.Date dt= new java.util.Date();
		java.text.SimpleDateFormat sdf = 
				new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime =sdf.format(dt);
		msg.setTimestamp(currentTime);
		entityManager.persist(msg);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(int ID) {
		String sql = "SELECT msg FROM Message msg WHERE id=" + ID + "";
		List<Message> messageToRemove = entityManager.createQuery(sql).getResultList();
		for (Message msg : messageToRemove) {
			entityManager.remove(msg);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean edit(Message msg) {
		Message message = entityManager.find(Message.class, msg.getId());
		message.setDev_id(msg.getDev_id());
		message.setMessage(msg.getMessage());
		message.setTimestamp(msg.getTimestamp());
		message.setTitle(msg.getTitle());
		return true;
	}

	@Override
	public Message getMessage(int id) {
		return entityManager.find(Message.class, id);
	}

}
