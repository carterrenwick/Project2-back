package com.revature.service;

public interface TaskServiceContract {
	
	void createTask(int cId, String description);

	void deleteTask(int tid);

}
