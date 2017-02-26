package com.hackbulgaria.bugtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackbulgaria.bugtracking.dao.MessageDao;
import com.hackbulgaria.bugtracking.entities.Message;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageDao msgDao;

	@Override
	public List<Message> getMessages() {
		return msgDao.getListOfMessages();
	}

	@Override
	public boolean addMessage(Message msg) {
		msgDao.add(msg);
		return true;
	}

	@Override
	public boolean removeMessage(int ID) {
		msgDao.delete(ID);
		return true;
	}

	@Override
	public boolean editMessage(Message msg) {
		msgDao.edit(msg);
		return true;
	}

	@Override
	public Message getMessage(int id) {
		return msgDao.getMessage(id);
	}

}
