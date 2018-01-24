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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//Lists could be changed to a Set (no order/no duplicates)
@Entity
@Table(name="ASB_USER")
@JsonSerialize
public class AsbUser implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2328147144686504931L;


	@Id
	@Column(name="U_ID")
	@SequenceGenerator(sequenceName="ASBUSER_SEQ", name="ASBUSER_SEQ")
	@GeneratedValue(generator="ASBUSER_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	private String username;
	
	@Column(name="PASS")
	private String password;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	private List<UserBoardRelation> userBoardRelations = new ArrayList<>();

	public AsbUser() {
	}

	public AsbUser(int id, String username, String password, String firstName, String lastName, List<Board> boards) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public AsbUser(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public List<UserBoardRelation> getUserBoardRelations() {
		return userBoardRelations;
	}

	public void setUserBoardRelations(List<UserBoardRelation> userBoardRelations) {
		this.userBoardRelations = userBoardRelations;
	}

	@Override
	public String toString() {
		return "AsbUser [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userBoardRelations=" + userBoardRelations + "]";
	}
}
