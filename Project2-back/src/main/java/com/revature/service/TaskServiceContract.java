package com.revature.service;

import com.revature.model.Task;

public interface TaskServiceContract {
	
	public Task createTask(int cId, String description);

	void deleteTask(int tid);

}
