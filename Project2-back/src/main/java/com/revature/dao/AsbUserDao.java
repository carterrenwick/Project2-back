package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.AsbUser;

public interface AsbUserDao extends JpaRepository<AsbUser,Integer> {

	public boolean existsByUsername(String username);
  
	AsbUser findByUsername(String username);

}