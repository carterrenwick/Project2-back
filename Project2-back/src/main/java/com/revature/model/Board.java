package com.revature.model;

import java.util.List;

//Lists could be changed to a Set (no order/no duplicates)
public class Board {

	private int id;
	private String name;
	
	//@ManyToMany
	private List<AsbUser> users;
	
	//@OneToMany
	private List<SwimLane> swimLanes;

	public Board() {}

	public Board(int id, String name, List<AsbUser> users, List<SwimLane> swimLanes) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.swimLanes = swimLanes;
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

	public List<AsbUser> getUsers() {
		return users;
	}

	public void setUsers(List<AsbUser> users) {
		this.users = users;
	}

	public List<SwimLane> getSwimLanes() {
		return swimLanes;
	}

	public void setSwimLanes(List<SwimLane> swimLanes) {
		this.swimLanes = swimLanes;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + ", users=" + users + ", swimLanes=" + swimLanes + "]";
	}
}
