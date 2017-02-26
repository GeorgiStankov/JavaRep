package com.hackbulgaria.bugtracking.dao;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Message;

public interface MessageDao {
	public List<Message> getListOfMessages();
	public boolean add(Message msg);
	public boolean delete(int ID);
	public boolean edit(Message msg);
	public Message getMessage(int id);
}
