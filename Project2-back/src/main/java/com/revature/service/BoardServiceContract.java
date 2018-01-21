package com.revature.service;

import com.revature.model.Board;

public interface BoardServiceContract 
{
	void deleteBoard(int bid);
	public void createBoard(Board board);

}
