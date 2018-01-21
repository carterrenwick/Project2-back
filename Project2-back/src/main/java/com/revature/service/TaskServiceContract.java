package com.revature.service;

public interface TaskServiceContract {
	
	public void createTask(int cId, String description);

	void deleteTask(int tid);

}
