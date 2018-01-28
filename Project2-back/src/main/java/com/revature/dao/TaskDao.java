package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Task;

public interface TaskDao extends JpaRepository<Task,Integer> {

}
