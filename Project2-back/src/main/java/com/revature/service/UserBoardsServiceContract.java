package com.revature.service;

import com.revature.model.Board;
import com.revature.model.BoardUserRole;
import com.revature.model.UserBoardRelation;

public interface UserBoardsServiceContract 
{
	public Board saveBoard(Board board, int userId);
	public UserBoardRelation addUserToBoard(int uId, int bId, BoardUserRole bur);
}
