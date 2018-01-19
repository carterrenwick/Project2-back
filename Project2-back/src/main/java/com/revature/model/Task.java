package com.revature.model;

//Lists could be changed to a Set (no order/no duplicates)
public class Task {

	private int id;
	private String description;
	private int completed;	//originally was a boolean, but DB schema has this as either 0 or 1
	
	//@ManyToOne
	private Card card;

	public Task() {}

	public Task(int id, String description, int completed, Card card) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
		this.card = card;
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

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", completed=" + completed + ", card=" + card + "]";
	}
}
