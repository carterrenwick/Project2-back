package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardDao;
import com.revature.model.Board;

@Service
public class BoardService implements BoardServiceContract{

	@Autowired
	BoardDao boardDao;
	
	public void createBoard(Board board) {
		
		boardDao.save(board);
	}


	@Override
	public void deleteBoard(int bid) 
	{
		boardDao.delete(bid);
	}

}
