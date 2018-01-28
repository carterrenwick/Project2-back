package com.revature.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * boolean instance variables may need to be changed to type int
 * in order to reflect DB schema
 * 
 * permissions in this class are subject to change
 */

@Entity
@Table(name="BOARD_USER_ROLE")
public class BoardUserRole implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2150537145470910788L;

	@Id
	@Column(name="BUR_ID")
	@SequenceGenerator(sequenceName="BUR_SEQ", name="BUR_SEQ")
	@GeneratedValue(generator="BUR_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	@Column(name="CREATE_C")
	private boolean createCard;
	
	@Column(name="MOVE_C")
	private boolean moveCard;
	
	@Column(name="EDIT_C")
	private boolean editCard;
	
	@Column(name="INVITE_U")
	private boolean inviteUser;
	
	@Column(name="CREATE_S")
	private boolean createSwimLane;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="BUR_ID")
	@JsonIgnore
	private Set<UserBoardRelation> userBoardRelations = new HashSet<>();
	
	public BoardUserRole() {}

	public BoardUserRole(int id, String roleName, boolean createCard, boolean moveCard, boolean editCard,
			boolean inviteUser, boolean createSwimLane) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.createCard = createCard;
		this.moveCard = moveCard;
		this.editCard = editCard;
		this.inviteUser = inviteUser;
		this.createSwimLane = createSwimLane;
	}

	public BoardUserRole(String roleName, boolean createCard, boolean moveCard, boolean editCard, boolean inviteUser,
			boolean createSwimLane) {
		super();
		this.roleName = roleName;
		this.createCard = createCard;
		this.moveCard = moveCard;
		this.editCard = editCard;
		this.inviteUser = inviteUser;
		this.createSwimLane = createSwimLane;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isCreateCard() {
		return createCard;
	}

	public void setCreateCard(boolean createCard) {
		this.createCard = createCard;
	}

	public boolean isMoveCard() {
		return moveCard;
	}

	public void setMoveCard(boolean moveCard) {
		this.moveCard = moveCard;
	}

	public boolean isEditCard() {
		return editCard;
	}

	public void setEditCard(boolean editCard) {
		this.editCard = editCard;
	}

	public boolean isInviteUser() {
		return inviteUser;
	}

	public void setInviteUser(boolean inviteUser) {
		this.inviteUser = inviteUser;
	}

	public boolean isCreateSwimLane() {
		return createSwimLane;
	}

	public void setCreateSwimLane(boolean createSwimLane) {
		this.createSwimLane = createSwimLane;
	}

	public Set<UserBoardRelation> getUserBoardRelations() {
		return userBoardRelations;
	}

	public void setUserBoardRelations(Set<UserBoardRelation> userBoardRelations) {
		this.userBoardRelations = userBoardRelations;
	}

	@Override
	public String toString() {
		return "BoardUserRole [id=" + id + ", roleName=" + roleName + ", createCard=" + createCard + ", moveCard="
				+ moveCard + ", editCard=" + editCard + ", inviteUser=" + inviteUser + ", createSwimLane="
				+ createSwimLane + ", userBoardRelations=" + userBoardRelations + "]";
	}
}
