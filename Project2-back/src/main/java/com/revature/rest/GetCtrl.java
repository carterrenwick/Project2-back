package com.revature.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Board;
import com.revature.model.BoardUserRole;
import com.revature.service.BoardService;
import com.revature.service.BoardUserRoleServiceContract;

@CrossOrigin
@RestController
public class GetCtrl {
	
	@Autowired
	BoardUserRoleServiceContract burService;
	
	@Autowired
	BoardService boardService;
	
	//Can be optimized by sending AsbUser & Board objects
	@GetMapping("/get/BoardUserRole/{uId}&{bId}")
	public BoardUserRole getBoardUserRole(@PathVariable int uId, @PathVariable int bId)
	{
		return burService.getBoardUserRole(uId, bId);
	}
	
	@GetMapping("/get/boards/{userId}")
	public List<Board> getBoards(@PathVariable int userId)
	{
		return boardService.getAllBoardsForLoggedInUser(userId);
	}

}
