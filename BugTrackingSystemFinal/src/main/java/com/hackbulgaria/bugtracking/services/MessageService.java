package com.hackbulgaria.bugtracking.services;

import java.util.List;

import com.hackbulgaria.bugtracking.entities.Message;

public interface MessageService {
	public List<Message> getMessages();
	public boolean addMessage(Message msg);
	public boolean removeMessage(int ID);
	public boolean editMessage(Message msg);
	public Message getMessage(int id);
	
}
