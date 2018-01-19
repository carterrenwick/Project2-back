package com.revature.model;

/*
 * boolean instance variables may need to be changed to type int
 * in order to reflect DB schema
 * 
 * permissions in this class are subject to change
 */

public class BoardUserRole {

	private int id;
	private String roleName;
	private boolean createCard;
	private boolean moveCard;
	private boolean editCard;
	private boolean inviteUser;
	private boolean createSwimLane;
	
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

	@Override
	public String toString() {
		return "BoardUserRole [id=" + id + ", roleName=" + roleName + ", createCard=" + createCard + ", moveCard="
				+ moveCard + ", editCard=" + editCard + ", inviteUser=" + inviteUser + ", createSwimLane="
				+ createSwimLane + "]";
	}	
}
