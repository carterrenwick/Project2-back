package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CardDao;
import com.revature.dao.TaskDao;
import com.revature.model.Card;
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
	public Task createTask(int cId, String description) {
		int tOrder = 1;
		Card c = cardDao.findOne(cId);
		
		for(Task t : c.getTasks()) {
			if(t.getOrder() > tOrder)
				tOrder = t.getOrder();
		}
		
		Task newTask = new Task(description, tOrder+1, false);
		
		c.getTasks().add(newTask);
		cardDao.save(c);
		
		return newTask;
	}

}
