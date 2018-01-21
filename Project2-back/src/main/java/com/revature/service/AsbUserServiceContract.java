package com.revature.service;

import com.revature.model.AsbUser;

public interface AsbUserServiceContract {

	public AsbUser registerAsbUser(AsbUser u);
	
	public AsbUser validateUser(String username, String password);
  
}
