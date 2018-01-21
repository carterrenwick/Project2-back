package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.serviceInterface.BoardSer;

@RestController
public class BoardCtrl {
	
	@Autowired
	BoardSer boardSer;
	
	@PostMapping("/createBoard")
	public void makeBoard(String boardName) {
		
		boardSer.createBoard(boardName);
	}

}
