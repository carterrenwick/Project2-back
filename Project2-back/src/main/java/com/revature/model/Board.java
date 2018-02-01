package com.revature.model;

import java.io.Serializable;
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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="BOARD")
@JsonSerialize
public class Board implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8147105293044242411L;

	@Id
	@Column(name="B_ID")
	@SequenceGenerator(sequenceName="BOARD_SEQ", name="BOARD_SEQ")
	@GeneratedValue(generator="BOARD_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="B_NAME")
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy="board",orphanRemoval = true)
	@JsonIgnore
	private List<UserBoardRelation> userBoardRelations = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="B_ID")
	@OrderBy("order ASC")
	private List<SwimLane> swimLanes;

	public Board( ) {
		this.swimLanes =new ArrayList<SwimLane>();
	}

	public Board(String name) {
		super();
		this.name = name;
		this.swimLanes =new ArrayList<SwimLane>();
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

	public List<SwimLane> getSwimLanes() {
		return swimLanes;
	}

	public void setSwimLanes(List<SwimLane> swimLanes) {
		this.swimLanes = swimLanes;
	}

	public List<UserBoardRelation> getUserBoardRelations() {
		return userBoardRelations;
	}

	public void setUserBoardRelations(List<UserBoardRelation> userBoardRelations) {
		this.userBoardRelations = userBoardRelations;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + ", userBoardRelations=" + userBoardRelations + ", swimLanes="
				+ swimLanes + "]";
	}
}