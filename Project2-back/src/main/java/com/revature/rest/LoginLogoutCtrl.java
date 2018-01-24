package com.revature.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.AsbUser;
import com.revature.service.AsbUserService;

@CrossOrigin
@RestController
public class LoginLogoutCtrl 
{
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	AsbUserService userService;
	
	@GetMapping("/logout")
	public void logout()
	{
		httpSession.invalidate();
	}
	
	@PostMapping("/login")
	public AsbUser login(@RequestBody AsbUser u)
	{
		AsbUser user = userService.validateUser(u.getUsername(), u.getPassword());
		return user;
	}
}
	
	