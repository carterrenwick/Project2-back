package com.revature.model;

import java.util.List;

//Lists could be changed to a Set (no order/no duplicates)
public class SwimLane {
	
	private int id;
	private String name;
	
	//@ManyToOne
	private Board board;
	
	//@OneToMany
	private List<Card> cards;

	public SwimLane() {}

	public SwimLane(int id, String name, Board board, List<Card> cards) {
		super();
		this.id = id;
		this.name = name;
		this.board = board;
		this.cards = cards;
	}

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

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "SwimLane [id=" + id + ", name=" + name + ", board=" + board + ", cards=" + cards + "]";
	}
}
