package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.SwimLaneService;

@RestController
public class MoveCtrl {
	
	@Autowired
	SwimLaneService sServ;
	
	@GetMapping("/move/card/{cid}&{sId1}&{sId2}")
	public void addUserToBoard(@PathVariable int cId, @PathVariable int sId1, @PathVariable int sId2) {
		sServ.moveCard(cId, sId1, sId2);
	}
	
	

}
