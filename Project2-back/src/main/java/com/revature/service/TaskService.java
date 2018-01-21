package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.TaskDao;

@Service
public class TaskService implements TaskServiceContract
{
	@Autowired
	TaskDao dao;

	public void deleteTask(int tid) 
	{
		dao.delete(tid);
	}

}
