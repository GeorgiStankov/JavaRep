package com.hackbulgaria.bugtracking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "developers")
public class Developer {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "role")
	private String role;
	@Column(name = "startWorkingDate")
	private String date;
	@Column(name = "teamLead_id")
	private String teadLeadID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTeadLeadID() {
		return teadLeadID;
	}

	public void setTeadLeadID(String teadLeadID) {
		this.teadLeadID = teadLeadID;
	}

	public boolean equals(Developer dev) {
		if (!(dev instanceof Developer)) {
			return false;
		}

		Developer that = (Developer) dev;

		// Custom equality check here.
		return this.id == (that.id) && this.name.equals(that.name);
	}

}
