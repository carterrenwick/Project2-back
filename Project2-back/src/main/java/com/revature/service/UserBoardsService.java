package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AsbUserDao;
import com.revature.dao.BoardDao;
import com.revature.dao.BoardUserRoleDao;
import com.revature.dao.UserBoardRelationDao;
import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.BoardUserRole;
import com.revature.model.UserBoardRelation;

@Service
public class UserBoardsService implements UserBoardsServiceContract
{
	@Autowired
	UserBoardRelationDao relationDao;
	
	@Autowired
	AsbUserDao userDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired 
	BoardUserRoleDao burDao;

	@Override
	public Board saveBoard(Board board, int userId) 
	{
		// Role id for admin = 3050
		BoardUserRole admin = new BoardUserRole();
		admin.setId(3050);
		
		boardDao.save(board);
		
		UserBoardRelation rel = new UserBoardRelation(
				userDao.findOne(userId),
				board,
				admin
				);
		relationDao.save(rel);
		return board;
	}
	
	@Override
	public UserBoardRelation addUserToBoard(int uId, int bId, BoardUserRole bur){
		AsbUser user = new AsbUser();
		user.setId(uId);
		Board board = new Board();
		board.setId(bId);
		try {
		if(relationDao.existsByUserAndBoard(user, board)) {
			// this user/board combo already exists so don't add to UserBoardRelation Table
			return null;
		}
			
		BoardUserRole existingRole = burDao.findByCreateCardAndMoveCardAndEditCardAndInviteUserAndCreateSwimLane(
				bur.isCreateCard(), bur.isMoveCard(), bur.isEditCard(), bur.isInviteUser(), bur.isCreateSwimLane());
		if(existingRole != null) {
			// if role already exists, get id of that role and save userboardrelation
			bur.setId(existingRole.getId());
			return relationDao.save(new UserBoardRelation(user,board,bur));
		} else {
			// if role doesn't exist, save that new role along with userboardrelation
			bur = burDao.save(bur);
			return relationDao.save(new UserBoardRelation(user,board,bur));
		}
		} catch (NonUniqueResultException e) {
			return null;
		}
	}

	@Override
	public List<AsbUser> getMembersOfBoard(int boardId) {
		List<AsbUser> boardMembers = new ArrayList<>();
		List<UserBoardRelation> relations = relationDao.findByBoard(boardDao.findOne(boardId));
		for (UserBoardRelation r: relations)
			boardMembers.add(r.getUser());
		return boardMembers;
	}

}
