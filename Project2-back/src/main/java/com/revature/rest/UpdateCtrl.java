package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.AsbUser;
import com.revature.model.SwimLane;
import com.revature.service.SwimLaneService;

@CrossOrigin
@RestController
public class UpdateCtrl 
{
	@Autowired
	SwimLaneService service;
	
	@PostMapping("/update/swimLane")
	public ResponseEntity updateSwimLane(@RequestBody SwimLane swimLane)
	{
		service.updateSwimLane(swimLane);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
}
