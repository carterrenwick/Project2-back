package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	
	@PostMapping("/delete/board/")
	public void deleteBoard(@RequestBody Board b)
	{
		boardService.deleteBoard(b);
	}
	
	@PostMapping("/delete/swimlane/")
	public void deleteSwimLane(@RequestBody SwimLane s)
	{
		swimLaneService.deleteSwimLane(s);
	}
	
	@PostMapping("/delete/card")
	public void deleteCard(@RequestBody Card c)
	{
		System.out.println("delete this card" + c);
		cardService.deleteCard(c);
	}
	
	@PostMapping("/delete/task/")
	public void deleteTask(@RequestBody Task t)
	{
		taskService.deleteTask(t);
	}
}