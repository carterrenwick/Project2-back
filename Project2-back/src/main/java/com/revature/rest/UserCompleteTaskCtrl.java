package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Task;
import com.revature.service.TaskService;

@RestController
public class UserCompleteTaskCtrl {

	
	@Autowired
	TaskService tServ;
	
	@PostMapping("/checkTask")
	public ResponseEntity<Boolean> userCheckTask(@RequestBody Task t) {
	
		tServ.saveTask(t);
				
	return	new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
	}
	
	
}