package com.revature.service;

import com.revature.model.Board;

public interface UserBoardsServiceContract 
{
	public Board saveBoard(Board board, int userId);
}
