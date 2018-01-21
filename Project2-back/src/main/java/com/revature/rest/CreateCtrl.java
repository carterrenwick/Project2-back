package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.model.SwimLane;
import com.revature.service.BoardServiceContract;
import com.revature.service.CardServiceContract;
import com.revature.service.SwimLaneServiceContract;

@RestController
public class CreateCtrl {
	
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
	
	@PostMapping("/createCard")
	public void makeCard(String cardName, int swimLaneId, int difficulty, String description) {
		
		cardSer.createCard(cardName, swimLaneId, difficulty, description);
	}

}
