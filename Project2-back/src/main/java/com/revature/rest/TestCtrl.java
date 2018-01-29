package com.revature.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.AsbUserDao;
import com.revature.dao.BoardDao;
import com.revature.dao.UserBoardRelationDao;
import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.BoardUserRole;
import com.revature.model.UserBoardRelation;
import com.revature.service.BoardService;

@RestController
public class TestCtrl {
	@Autowired
	AsbUserDao userDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	BoardService bService;
	
	@Autowired
	UserBoardRelationDao ubDao;
	
	@PostMapping("/person")
	public AsbUser makePerson(@RequestBody AsbUser U ) {
		
		return U;
	}

	@GetMapping("/C/{candy}")
	public String newReq(@PathVariable String candy ) {
		
		return "I love candy" + candy;
	}
	
	@GetMapping("/newBobbert")
	public AsbUser newReq() {
		
		AsbUser u = userDao.save(new AsbUser("Bobbert","123","Bob","Bert"));
		return u;
	}
	
	@GetMapping("/getBobbert")
	public AsbUser getReq() {
		
		AsbUser u = userDao.findOne(1050);
		return u;
	}
	
	@GetMapping("/getAll")
	public List<AsbUser> getAll()
	{
		return userDao.findAll();
	}
	
	@GetMapping("/getAllBoards")
	public List<Board> getAllBoards()
	{
		List<UserBoardRelation> ub = ubDao.findAll();
		return bService.getAllBoards(ub);
	}
	
	@GetMapping("/getABoards")
	public List<UserBoardRelation> getABoards()
	{
		return ubDao.findAll();
	}
	
	@GetMapping("/getARelation")
	public UserBoardRelation getARelation()
	{
		List<UserBoardRelation> ub = ubDao.findAll();
		
		for (UserBoardRelation u : ub)
			if (u.getUser().getId() == 1050)
				return u;
		return null;
	}
  
}