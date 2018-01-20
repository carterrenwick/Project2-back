package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AsbUserDao;
import com.revature.model.AsbUser;

@Service
public class AsbUserService implements AsbUserServiceContract {

	@Autowired
	AsbUserDao userDao;
	
	@Override
	public AsbUser registerAsbUser(AsbUser u) {
		if(userDao.existsByUsername(u.getUsername())) {
			System.out.println("User entered a username that already exists");
			return null;
		}
		return userDao.save(u);
	}
	
	

}
