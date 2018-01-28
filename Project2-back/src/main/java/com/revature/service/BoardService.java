package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AsbUserDao;
import com.revature.dao.BoardDao;
import com.revature.dao.UserBoardRelationDao;
import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.UserBoardRelation;

@Service
public class BoardService implements BoardServiceContract{

	@Autowired
	BoardDao boardDao;
	
	@Autowired
	AsbUserDao aDao;
	
	@Autowired
	UserBoardRelationDao relationDao;
	
	public void createBoard(Board board) {
		
		boardDao.save(board);
	}

	@Override
	public void deleteBoard(int bid) 
	{
		boardDao.delete(bid);
	}

	

	@Override
	public void saveBoard(Board b) {
		boardDao.save(b);
		
	}


	@Override
	public Board ueserToBoard(int bId, int uId) {
		AsbUser u = aDao.findOne(uId);
		Board b = boardDao.findOne(bId);
//		b.getUserBoards().add()
		return b;
		
	}

	@Override
	public List<Board> getAllBoards(List<UserBoardRelation> userBoardRelation) 
	{
		List<Board> boards = new ArrayList<>();
		for (UserBoardRelation ub : userBoardRelation)
			 boards.add(ub.getBoard());
		return boards;
	}

	@Override
	public List<Board> getAllBoardsForLoggedInUser(int userId) 
	{
		List<Board> boards = new ArrayList<>();
		List<UserBoardRelation> relations = relationDao.findByUser(aDao.findOne(userId));
		for (UserBoardRelation r: relations)
			boards.add(r.getBoard());
		return boards;
	}
	
	

}
