package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Card;

public interface CardDao extends JpaRepository<Card,Integer> {

}
