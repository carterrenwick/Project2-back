package com.revature.service;

import com.revature.model.Board;

public interface BoardServiceContract 
{
	void deleteBoard(int bid);
	
	
	Board ueserToBoard(int bId, int uId) ;
	
	
	void saveBoard( Board b);
}
