package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.AsbUser;
import com.revature.service.AsbUserServiceContract;

@RestController
public class RegisterCtrl {

	@Autowired
	AsbUserServiceContract userService;
	
	@PostMapping("/register")
	public ResponseEntity<AsbUser> registerUser(@RequestBody AsbUser u ) {
		u = userService.registerAsbUser(u);
		return new ResponseEntity<AsbUser>(u, HttpStatus.CREATED);
	}
	
	
}
