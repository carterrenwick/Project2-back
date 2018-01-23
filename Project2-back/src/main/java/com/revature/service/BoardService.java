package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AsbUserDao;
import com.revature.dao.BoardDao;
import com.revature.model.AsbUser;
import com.revature.model.Board;

@Service
public class BoardService implements BoardServiceContract 
{
	@Autowired
	BoardDao dao;
	
	@Autowired
	AsbUserDao aDao;

	@Override
	public void deleteBoard(int bid) 
	{
		dao.delete(bid);
	}

	

	@Override
	public void saveBoard(Board b) {
		dao.save(b);
		
	}


	@Override
	public Board ueserToBoard(int bId, int uId) {
		AsbUser u = aDao.findOne(uId);
		Board b = dao.findOne(bId);
		b.getUsers().add(u);
		return b;
		
	}
	
	

}
