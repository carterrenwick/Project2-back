package com.revature.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_BOARDS")
public class UserBoardRelation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1201226001254420329L;

	
	@Id
	@Column(name="REL_ID")
	@SequenceGenerator(sequenceName="REL_SEQ", name="REL_SEQ")
	@GeneratedValue(generator="REL_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int relationId;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "U_ID")
	private AsbUser user;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "B_ID")
	private Board board;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "BUR_ID")
	private BoardUserRole role;
	
	public UserBoardRelation() {}

	public UserBoardRelation(AsbUser user, Board board, BoardUserRole role) {
		super();
		this.user = user;
		this.board = board;
		this.role = role;
	}

	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}

	public AsbUser getUser() {
		return user;
	}

	public void setUser(AsbUser user) {
		this.user = user;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public BoardUserRole getRole() {
		return role;
	}

	public void setRole(BoardUserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserBoardRelation [relationId=" + relationId + "]";
	}
}
