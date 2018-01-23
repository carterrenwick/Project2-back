package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CardDao;

@Service
public class CardService implements CardServiceContract
{
	@Autowired
	CardDao dao;

	public void deleteCard(int cid) 
	{
		dao.delete(cid);
	}

}
