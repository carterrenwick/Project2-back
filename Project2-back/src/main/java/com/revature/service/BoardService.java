package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardDao;

@Service
public class BoardService implements BoardServiceContract 
{
	@Autowired
	BoardDao dao;

	@Override
	public void deleteBoard(int bid) 
	{
		dao.delete(bid);
	}

}
