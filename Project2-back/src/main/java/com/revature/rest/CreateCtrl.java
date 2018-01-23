package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.service.BoardServiceContract;
import com.revature.service.CardServiceContract;
import com.revature.service.SwimLaneServiceContract;
import com.revature.service.TaskServiceContract;

@RestController
public class CreateCtrl {
	
	@Autowired
	TaskServiceContract taskService;
	
	@PostMapping("/createTask")
	public void createTask(int cId, String description) {
		taskService.createTask(cId, description);
	}
	
	@Autowired
	BoardServiceContract boardSer;
	
	@PostMapping("/createBoard")
	public void makeBoard(@RequestBody Board board) {
		
		boardSer.createBoard(board);
	}
	
	@Autowired
	SwimLaneServiceContract swimLaneSer;
	
	@PostMapping("/createSwimLane")
	public void makeSwimLane(String swimLaneName, int boardId) {
		
		swimLaneSer.createSwimLane(swimLaneName, boardId);
	}
	
	@Autowired
	CardServiceContract cardSer;
	
	@PostMapping("/createCard/{id}")
	public void makeCard(@RequestBody Card card, @PathVariable int id) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "+card);
		cardSer.createCard(card, id);
	}


}