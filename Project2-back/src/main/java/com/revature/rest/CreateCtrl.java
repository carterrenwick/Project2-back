package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.model.SwimLane;
import com.revature.service.BoardServiceContract;
import com.revature.service.CardServiceContract;
import com.revature.service.SwimLaneServiceContract;
import com.revature.service.TaskServiceContract;
import com.revature.service.UserBoardsService;

@RestController
public class CreateCtrl {
	
	@Autowired
	TaskServiceContract taskService;
	
	@Autowired
	BoardServiceContract boardSer;
	
	@Autowired
	UserBoardsService relationService;
	
	@PostMapping("/createTask")
	public void createTask(int cId, String description) {
		taskService.createTask(cId, description);
	}
	
	@PostMapping("/create/board")
	public Board makeBoard(@RequestBody Board board) 
	{
		return relationService.saveBoard(board);
	}
	
	@Autowired
	SwimLaneServiceContract swimLaneSer;
	
	@PostMapping("/createSwimLane/{boardId}")
	public void makeSwimLane(@RequestBody SwimLane swimLane, @PathVariable int boardId) {
		
		swimLaneSer.createSwimLane(swimLane, boardId);
	}
	
	@Autowired
	CardServiceContract cardSer;

	@PostMapping("/createCard/{swimLaneId}")
	public void makeCard(@RequestBody Card card, @PathVariable int swimLaneId) {
		
		cardSer.createCard(card, swimLaneId);
	}


}
