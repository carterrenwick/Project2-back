package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.BoardUserRole;

public interface BoardUserRoleDao  extends JpaRepository<BoardUserRole,Integer> {

}
