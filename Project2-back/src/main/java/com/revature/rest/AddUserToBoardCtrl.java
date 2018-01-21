package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.BoardService;


@RestController
public class AddUserToBoardCtrl {
	
	@Autowired
	BoardService bServ;
	
	@GetMapping("/addUB/{bId}&{uId}")
	public void addUserToBoard(@PathVariable int bId, @PathVariable int uId) {
	
		bServ.saveBoard(bServ.ueserToBoard(bId, uId));
	}
	
	

}
