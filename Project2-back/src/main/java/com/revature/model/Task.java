package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TASK")
public class Task {

	
	@Id
	@Column(name="T_ID")
	@SequenceGenerator(sequenceName="TASK_SEQ", name="TASK_SEQ")
	@GeneratedValue(generator="TASK_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="T_DESC")
	private String description;
	
	@Column(name="T_ORDER")
	private int order;
	
	private boolean completed;	//may need to be changed to int to reflect DB schema

	public Task() {}

	public Task(int id, String description, int order, boolean completed) {
		super();
		this.id = id;
		this.description = description;
		this.order = order;
		this.completed = completed;
	}
	
	public Task(String description, int order, boolean completed) {
		super();
		this.description = description;
		this.order = order;
		this.completed = completed;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", completed=" + completed + "]";
	}



}