package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.CardDao;
import com.revature.model.Task;

public class TaskService implements TaskServiceContract {

	@Autowired
	CardDao cardDao;
	
	@Override
	public void createTask(int cId, String description) {
		Task t = new Task(description, 0, false);
		//getTasks().add(t);
	}

}
