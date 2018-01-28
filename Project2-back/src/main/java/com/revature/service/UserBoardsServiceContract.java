package com.revature.service;

import java.util.List;

import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.BoardUserRole;
import com.revature.model.UserBoardRelation;

public interface UserBoardsServiceContract 
{
	public Board saveBoard(Board board, int userId);
	public UserBoardRelation addUserToBoard(int uId, int bId, BoardUserRole bur);
	public List<AsbUser> getMembersOfBoard(int boardId);
}
