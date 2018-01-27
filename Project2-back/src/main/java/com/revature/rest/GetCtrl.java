package com.revature.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Board;
import com.revature.model.Task;
import com.revature.service.BoardService;
import com.revature.service.BoardUserRoleServiceContract;
import com.revature.service.TaskService;

@CrossOrigin
@RestController
public class GetCtrl {
	
	@Autowired
	BoardUserRoleServiceContract burService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	TaskService taskService;
	
	//Can be optimized by sending AsbUser & Board objects
//	@GetMapping("/get/BoardUserRole/{uId}&{bId}")
//	public BoardUserRole getBoardUserRole(@PathVariable int uId, @PathVariable int bId)
//	{
////		return burService.getBoardUserRole(uId, bId);
//	}
	
	@GetMapping("/get/boards")
	public List<Board> getBoards()
	{
		return boardService.getAllBoardsForLoggedInUser();
	}
	
	
	@GetMapping("/get/tasks/{id}")
	public List<Task> getTasks(@PathVariable int id ){
		return taskService.getAllTask(id);
	}
	

}
