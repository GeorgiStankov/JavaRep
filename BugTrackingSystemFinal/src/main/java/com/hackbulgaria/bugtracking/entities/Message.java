package com.hackbulgaria.bugtracking.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "timestamp")
	private String timestamp;
	
	@Column(name = "dev_id")
	private int dev_id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getDev_id() {
		return dev_id;
	}
	public void setDev_id(int dev_id) {
		this.dev_id = dev_id;
	}
	public String getFormattedTimestamp(){
		/*Date sdf;
		try {
			sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss.S")
					.parse(timestamp);
			return new SimpleDateFormat("HH:mm").format(sdf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Just now";*/
		return timestamp.split("\\s+")[1].substring(0,5);
	}
}
