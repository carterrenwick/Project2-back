package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.BoardUserRole;
import com.revature.model.UserBoardRelation;
import com.revature.service.UserBoardsServiceContract;

@CrossOrigin
@RestController
public class AddUserToBoardCtrl {
	
//	@Autowired
//	BoardService bServ;
	
//	@GetMapping("/addUB/{bId}&{uId}")
//	public void addUserToBoard(@PathVariable int bId, @PathVariable int uId) {
//	
////		bServ.saveBoard(bServ.ueserToBoard(bId, uId)); throwing error
//	}
	
	@Autowired
	UserBoardsServiceContract ubService;
	
	@PostMapping("/addUB/{uId}&{bId}")
	public ResponseEntity<UserBoardRelation> addUserToBoard(@PathVariable int uId, @PathVariable int bId, @RequestBody BoardUserRole bur) {
		UserBoardRelation ubr = ubService.addUserToBoard(uId, bId, bur);
		return new ResponseEntity<UserBoardRelation>(ubr, HttpStatus.CREATED);
	}

}