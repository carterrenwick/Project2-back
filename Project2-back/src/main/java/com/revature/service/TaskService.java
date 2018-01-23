package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.TaskDao;
import com.revature.model.Board;
import com.revature.model.Task;

@Service
@Transactional
public class TaskService implements TaskServiceContract
{
	@Autowired
	TaskDao dao;

	public void deleteTask(int tid) 
	{
		dao.delete(tid);
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

	
}
