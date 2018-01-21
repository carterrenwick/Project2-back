package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AsbUserDao;
import com.revature.dao.BoardDao;

import com.revature.model.AsbUser;
import com.revature.model.Board;

@Service
public class BoardService implements BoardServiceContract{

	@Autowired
	BoardDao boardDao;
	
	@Autowired
	AsbUserDao aDao;
	
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
		b.getUsers().add(u);
		return b;
		
	}
	
	

}
