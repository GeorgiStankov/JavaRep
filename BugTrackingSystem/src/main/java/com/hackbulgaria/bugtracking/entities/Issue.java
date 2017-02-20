package com.hackbulgaria.bugtracking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "issues")
public class Issue {

	public enum Type {
		DEFECT, TASK
	}

	public enum Priority {
		LOW, MEDIUM, HIGH, BLOCKER
	}

	public enum IssueStatus {
		NEW, IN_PROGRESS, RESOLVED, INVALID

	}

	@Id
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "date_creation")
	private String date;
	@Column(name = "type")
	private Type type;
	@Column(name = "description")
	private String description;
	@Column(name = "priority")
	private Priority priority;
	@Column(name = "issue_status")
	private IssueStatus status;
	@ManyToOne(optional=false)
	@JoinColumn(name="id",referencedColumnName="id",insertable=false,updatable=false)
	private Developer owner;
	@Column(name = "creator")
	private int creator;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public IssueStatus getStatus() {
		return status;
	}

	public void setStatus(IssueStatus status) {
		this.status = status;
	}


	public Developer getOwner() {
		return owner;
	}

	public void setOwner(Developer owner) {
		this.owner = owner;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public boolean equals(Issue issue) {
		if (!(issue instanceof Issue)) {
			return false;
		}

		Issue that = (Issue) issue;

		// Custom equality check here.
		return this.id == (that.id) && this.title.equals(that.title);
	}
}
