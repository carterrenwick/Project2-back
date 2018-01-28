package com.revature.service;

import java.util.List;

import com.revature.model.Task;

public interface TaskServiceContract 
{
	void deleteTask(Task t, int cardId);

	boolean checkedTask(int tId);
	
	void saveTask(Task t);
	
	Task createTask(String description,int cId);
	
	public List<Task> getAllTask(int cId);
  
}
