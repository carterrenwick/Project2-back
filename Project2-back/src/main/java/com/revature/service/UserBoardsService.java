package com.revature.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AsbUserDao;
import com.revature.dao.BoardDao;
import com.revature.dao.UserBoardRelationDao;
import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.BoardUserRole;
import com.revature.model.UserBoardRelation;

@Service
public class UserBoardsService implements UserBoardsServiceContract
{
	@Autowired
	UserBoardRelationDao relationDao;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	AsbUserDao userDao;
	
	@Autowired
	BoardDao boardDao;

	public Board saveBoard(Board board, int userId) 
	{
		UserBoardRelation rel = new UserBoardRelation(
				userDao.findOne(userId),
				board,
				new BoardUserRole("Admin",true,true,true,true,true)
				);
		relationDao.save(rel);
		return board;
	}

}
