package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CardDao;
import com.revature.dao.TaskDao;
import com.revature.model.Card;
import com.revature.model.SwimLane;
import com.revature.model.Task;

@Service
@Transactional
public class TaskService implements TaskServiceContract
{
	@Autowired
	TaskDao taskDao;
	
	@Autowired
	CardDao cardDao;

	public void deleteTask(Task task, int cardId) 
	{
		taskDao.delete(task);
		Card c = cardDao.findOne(cardId);
		List<Task> tList = c.getTasks();
		boolean correctOrder = true;
		CheckOrder: for (int i = 1; i <= tList.size()+1; i++)
		{
			for (Task t : tList)
			{
				if (t.getOrder()==i) 
				{
					if (!correctOrder) 
					{
						t.setOrder(i-1);
						taskDao.save(t);
					}
					continue CheckOrder;
				}
				correctOrder = false;
			}
		}
	}
	
	@Override
	public Task createTask(String description,int cId) {
		int tOrder = 0;
		Card c = cardDao.findOne(cId);
		
		for(Task t : c.getTasks()) {
			if(t.getOrder() > tOrder)
				tOrder = t.getOrder();
		}
		
		Task newTask = new Task(description, tOrder+1, false);
		newTask = taskDao.save(newTask);
		c.getTasks().add(newTask);
		Card c1 = cardDao.save(c);
		
		return newTask;
	}

	@Override
	public void checkedTask(Task t) 
	{
		t = taskDao.findOne(t.getId());
		t.setCompleted(!t.getCompleted());
	}
	
	@Override
	public void saveTask(Task t) {
		
	taskDao.save(t);
		
	}

	@Override
	public List<Task> getAllTask(int cId) {
		Card c = cardDao.findOne(cId);
		
	
		List<Task> task = (List<Task>) taskDao.findAll();
		
		for (Task t: task) {
			for(Task ct: c.getTasks()) {
				
				if(t.getId() == ct.getId()) {
					
					return c.getTasks();
				}
				
			}
		}
		
		return null;
	}
}
