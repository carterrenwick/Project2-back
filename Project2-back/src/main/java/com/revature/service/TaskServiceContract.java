package com.revature.service;

import com.revature.model.Task;

public interface TaskServiceContract 
{
	void deleteTask(int tid);

	boolean checkedTask(int tId);
	
	void saveTask(Task t);
	
	void createTask(int cId, String description);
  
}
