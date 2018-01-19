package com.revature.model;

import java.util.List;

//Lists could be changed to a Set (no order/no duplicates)
public class Card {
	
	private int id;
	private int difficulty;
	private String title;
	private String description;
	
	//ManyToOne
	private SwimLane swimLane;
	
	//OneToMany
	private List<Task> tasks;
	
	public Card() {}

	public Card(int id, int difficulty, String title, String description, SwimLane swimLane, List<Task> tasks) {
		this.id = id;
		this.difficulty = difficulty;
		this.title = title;
		this.description = description;
		this.swimLane = swimLane;
		this.tasks = tasks;
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

	public SwimLane getSwimLane() {
		return swimLane;
	}

	public void setSwimLane(SwimLane swimLane) {
		this.swimLane = swimLane;
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
				+ ", swimLane=" + swimLane + ", tasks=" + tasks + "]";
	}	
}
