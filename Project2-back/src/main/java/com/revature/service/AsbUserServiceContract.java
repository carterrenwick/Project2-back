package com.revature.service;

import com.revature.model.AsbUser;

public interface AsbUserServiceContract 
{
	public AsbUser validateUser(String username, String password);
}
