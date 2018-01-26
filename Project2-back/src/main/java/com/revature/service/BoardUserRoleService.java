package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardUserRoleDao;
import com.revature.dao.UserBoardRelationDao;
import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.BoardUserRole;
import com.revature.model.UserBoardRelation;

@Service
public class BoardUserRoleService implements BoardUserRoleServiceContract {
	
	@Autowired
	BoardUserRoleDao burDao;
	
	@Autowired
	UserBoardRelationDao ubrDao;
	
	

}