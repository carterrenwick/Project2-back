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

	public Board saveBoard(Board board) 
	{
		httpSession.setAttribute("user", userDao.findOne(1050)); // remove once loggin feature implemented
		AsbUser user = (AsbUser) httpSession.getAttribute("user");
		UserBoardRelation rel = new UserBoardRelation(user,board,new BoardUserRole("Admin",true,true,true,true,true));
//		board.getUserBoardRelations().add(rel);
//		board = boardDao.save(board);
		relationDao.save(rel);
		return board;
	}

}
