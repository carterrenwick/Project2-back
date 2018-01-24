package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.UserBoardRelation;

public interface UserBoardRelationDao extends JpaRepository<UserBoardRelation, Integer> {
	
	UserBoardRelation findByUserAndBoard(AsbUser user, Board board);
	
}
