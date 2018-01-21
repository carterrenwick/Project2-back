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
@Table(name="SWIM_LANE")
public class SwimLane {
	
	
	
	@Id
	@Column(name="SL_ID")
	@SequenceGenerator(sequenceName="SWIMLANE_SEQ", name="SWIMLANE_SEQ")
	@GeneratedValue(generator="SWIMLANE_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	
	
	@Column(name="SL_NAME")
	private String name;
	
	@Column(name="SL_ORDER")
	private int order;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="SL_ID")	
	private List<Card> cards;

	public SwimLane() {
		this.cards = new ArrayList<Card>();
	}

	public SwimLane(int id, String name, Board board, List<Card> cards) {
		super();
		this.id = id;
		this.name = name;
		
		this.cards = cards;
	}
	
	public SwimLane(String name, int order) {
		super();
		this.name = name;
		this.order = order;
		this.cards = new ArrayList<Card>();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "SwimLane [id=" + id + ", name=" + name + ", order=" + order + ", cards=" + cards + "]";
	}

}
