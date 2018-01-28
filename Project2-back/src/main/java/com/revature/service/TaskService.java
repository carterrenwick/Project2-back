package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CardDao;
import com.revature.dao.TaskDao;
import com.revature.model.Card;
import com.revature.model.Task;

@Service
@Transactional
public class TaskService implements TaskServiceContract
{
	@Autowired
	TaskDao dao;
	
	@Autowired
	CardDao cardDao;

	public void deleteTask(Task t) 
	{
		dao.delete(t);
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
		
		c.getTasks().add(newTask);
		Card c1 = cardDao.save(c);
		
		List<Task> tasks = c1.getTasks();
		Task temp = new Task(0,"",0,false);
		for(Task tsk: tasks) {
			if(tsk.getId() > temp.getId()){
				temp = tsk;
			}
		}
		return temp;
	}

	@Override
	public boolean checkedTask(int tId) {
		Task t = dao.findOne(tId);
		if(t.getCompleted() == true) {
			return true;	
		}else {
			return false;
		}
		
	}
	
	@Override
	public void saveTask(Task t) {
		
	dao.save(t);
		
	}

	@Override
	public List<Task> getAllTask(int cId) {
		Card c = cardDao.findOne(cId);
		
	
		List<Task> task = (List<Task>) dao.findAll();
		
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
