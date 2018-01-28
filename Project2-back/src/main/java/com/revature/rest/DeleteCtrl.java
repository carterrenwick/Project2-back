package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.BoardService;
import com.revature.service.CardService;
import com.revature.service.SwimLaneService;
import com.revature.service.TaskService;

@CrossOrigin
@RestController
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
	
	
	@GetMapping("/delete/board/{bid}")
	public void deleteBoard(@PathVariable int bid)
	{
		boardService.deleteBoard(bid);
	}
	
	@GetMapping("/delete/swimlane/{swid}")
	public void deleteSwimLane(@PathVariable int swid)
	{
		swimLaneService.deleteSwimLane(swid);
	}
	
	@GetMapping("/delete/card/{cid}")
	public void deleteCard(@PathVariable int cid)
	{
		cardService.deleteCard(cid);
	}
	
	@GetMapping("/delete/task/{tid}")
	public void deleteTask(@PathVariable int tid)
	{
		taskService.deleteTask(tid);
	}
}