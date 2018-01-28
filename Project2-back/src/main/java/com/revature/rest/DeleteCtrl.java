package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.model.SwimLane;
import com.revature.model.Task;
import com.revature.service.BoardService;
import com.revature.service.CardService;
import com.revature.service.SwimLaneService;
import com.revature.service.TaskService;

@RestController
@CrossOrigin
public class DeleteCtrl 
{
	@Autowired
	BoardService boardService;
	
	@Autowired
	SwimLaneService swimLaneService;
	
	@Autowired
	CardService cardService;
	
	@Autowired
	TaskService taskService;
	
	
	@PostMapping("/delete/board")
	public void deleteBoard(@RequestBody Board b)
	{
		boardService.deleteBoard(b);
	}
	
	@PostMapping("/delete/swimlane/{boardId}")
	public void deleteSwimLane(@RequestBody SwimLane s,@PathVariable int boardId)
	{
		swimLaneService.deleteSwimLane(s, boardId);
	}
	
	@PostMapping("/delete/card/{slid}")
	public void deleteCard(@RequestBody Card c, @PathVariable int slid)
	{
		cardService.deleteCard(c, slid);
	}
	
	@PostMapping("/delete/task/{cardId}")
	public void deleteTask(@RequestBody Task t, @PathVariable int cardId)
	{
		taskService.deleteTask(t, cardId);
	}
}