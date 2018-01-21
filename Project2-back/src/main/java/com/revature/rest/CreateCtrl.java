package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Task;
import com.revature.service.TaskServiceContract;

@RestController
public class CreateCtrl {
	
	@Autowired
	TaskServiceContract taskService;
	
	@GetMapping("/createTask/{cId}&{description}")
	public Task testCreateTask(@PathVariable int cId, @PathVariable String description) {
		return taskService.createTask(cId, description);
		
	}

}
