package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CardDao;
import com.revature.dao.TaskDao;
import com.revature.model.Task;

@Service
public class TaskService implements TaskServiceContract
{
	@Autowired
	TaskDao dao;
	
	@Autowired
	CardDao cardDao;

	public void deleteTask(int tid) 
	{
		dao.delete(tid);
	}
	
	@Override
	public void createTask(int cId, String description) {
		Task t = new Task(description, 0, false);
		//getTasks().add(t);
	}

}
