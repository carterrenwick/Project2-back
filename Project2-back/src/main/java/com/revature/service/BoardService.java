package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardDao;
import com.revature.model.Board;
import com.revature.serviceInterface.BoardSer;

@Service
public class BoardService implements BoardSer{

	@Autowired
	BoardDao boardDao;
	
	public void createBoard(String boardName) {
		
		Board board = new Board();
		board.setName(boardName);
		boardDao.save(board);
	}
}
