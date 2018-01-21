package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.revature.serviceInterface.SwimLaneSer;

@RestController
public class SwimLaneCtrl {
	
	@Autowired
	SwimLaneSer swimLaneSer;
	
	public void makeSwimLane(String swimLaneName, int boardId) {
		
		swimLaneSer.createSwimLane(swimLaneName, boardId);
	}

}
