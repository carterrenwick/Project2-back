package com.revature.model;

import java.util.List;

//Lists could be changed to a Set (no order/no duplicates)
public class AsbUser {
	
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	//@ManyToMany 
	private List<Board> boards;

	public AsbUser() {}

	public AsbUser(int id, String username, String password, String firstName, String lastName, List<Board> boards) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.boards = boards;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	@Override
	public String toString() {
		return "AsbUser [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", boards=" + boards + "]";
	}	
}
