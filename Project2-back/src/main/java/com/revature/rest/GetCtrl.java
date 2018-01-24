package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.BoardUserRole;
import com.revature.service.BoardUserRoleServiceContract;

@RestController
public class GetCtrl {
	
	@Autowired
	BoardUserRoleServiceContract burService;
	
	//Can be optimized by sending AsbUser & Board objects
	@GetMapping("/get/BoardUserRole/{uId}&{bId}")
	public BoardUserRole getBoardUserRole(@PathVariable int uId, @PathVariable int bId)
	{
		return burService.getBoardUserRole(uId, bId);
	}

}
