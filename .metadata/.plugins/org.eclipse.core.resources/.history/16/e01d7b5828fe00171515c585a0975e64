package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AsbUserDao;
import com.revature.model.AsbUser;

@Service
public class AsbUserService implements AsbUserServiceContract
{
	@Autowired
	AsbUserDao userDao;
	
	@Override
	public AsbUser validateUser(String username, String password) 
	{
		AsbUser user = userDao.findByUsername(username);
		System.out.println(user);
		if (user != null && user.getPassword().equals(password))
		{
			return user;
		}
		else return null;
	}

}
