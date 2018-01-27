package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.model.Board;
import com.revature.model.UserBoardRelation;

@Service
public interface BoardServiceContract 
{
	void deleteBoard(int bid);

	Board ueserToBoard(int bId, int uId);

	void saveBoard( Board b);
  
	public void createBoard(Board board);
	
	public List<Board> getAllBoards(List<UserBoardRelation> userBoardRelation);

	public List<Board> getAllBoardsForLoggedInUser(int userId);

}
