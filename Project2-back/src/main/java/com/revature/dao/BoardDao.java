package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Board;

public interface BoardDao  extends JpaRepository<Board,Integer>{

}
