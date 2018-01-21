package com.revature.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//Lists could be changed to a Set (no order/no duplicates)
@Entity
@Table(name="BOARD")
public class Board {

	@Id
	@Column(name="B_ID")
	@SequenceGenerator(sequenceName="BOARD_SEQ", name="BOARD_SEQ")
	@GeneratedValue(generator="BOARD_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="B_NAME")
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="USER_BOARDS",
		joinColumns=@JoinColumn(name="B_ID"),
		inverseJoinColumns= @JoinColumn(name="U_ID"))
	@JsonManagedReference
	private Set<AsbUser> users;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="B_ID")
	private List<SwimLane> swimLanes;

	public Board( ) {
		this.swimLanes =new ArrayList<SwimLane>();
		this.users = new HashSet<AsbUser>();
	}

	public Board(int id, String name, Set<AsbUser> users, List<SwimLane> swimLanes) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.swimLanes = swimLanes;
	}
	
	

	public Board(String name) {
		super();
		this.name = name;
		this.swimLanes =new ArrayList<SwimLane>();
		this.users = new HashSet<AsbUser>();
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

	public Set<AsbUser> getUsers() {
		return users;
	}

	public void setUsers(Set<AsbUser> users) {
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
		return "Board [id=" + id + ", name=" + name + ", swimLanes=" + swimLanes + "]";
	}
}
