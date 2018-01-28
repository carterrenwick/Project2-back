package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.UserBoardRelation;

public interface UserBoardRelationDao extends JpaRepository<UserBoardRelation, Integer> {
	
	List<UserBoardRelation> findByUser(AsbUser user);
	
	UserBoardRelation findByUserAndBoard(AsbUser user, Board board);
	
	boolean existsByUserAndBoard(AsbUser user, Board board);
	
	List<UserBoardRelation> findByBoard(Board board);
}
