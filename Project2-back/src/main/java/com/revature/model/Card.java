package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CARD")
public class Card {
	
	
	
	@Id
	@Column(name="C_ID")
	@SequenceGenerator(sequenceName="CARD_SEQ", name="CARD_SEQ")
	@GeneratedValue(generator="CARD_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	private int difficulty;
	
	@Column(name="C_TITLE")
	private String title;
	
	@Column(name="C_DESC")
	private String description;
	
	@Column(name="C_ORDER")
	private int order;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="C_ID")	
	private List<Task> tasks;
	

	public Card() {
		this.tasks = new ArrayList<Task>();
	}

	public Card(int id, int difficulty, String title, String description, SwimLane swimLane, List<Task> tasks) {
		this.id = id;
		this.difficulty = difficulty;
		this.title = title;
		this.description = description;
		this.tasks = tasks;
	}
	
	public Card(int difficulty, String title, String description, int order) {
		super();
		this.difficulty = difficulty;
		this.title = title;
		this.description = description;
		this.order = order;
		this.tasks = new ArrayList<Task>();
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

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", difficulty=" + difficulty + ", title=" + title + ", description=" + description
				+ ", order=" + order + ", tasks=" + tasks + "]";
	}

}