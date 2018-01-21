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
import com.revature.model.AsbUser;
import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.model.SwimLane;
import com.revature.model.Task;
import com.revature.service.TaskServiceContract;

@RestController
public class TestCtrl {
	@Autowired
	AsbUserDao userDao;
	
	@Autowired
	BoardDao boardDao;
	
	
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
	
	@GetMapping("/addToBobbert")
	public Board addToBobbert()
	{
		AsbUser u = userDao.findByUsername("Bobbert");
		u.getBoards().add(new Board("TestBoard"));
		u.getBoards().get(0).getSwimLanes().add(new SwimLane("TestLane",1));
		u.getBoards().get(0).getSwimLanes().get(0).getCards().add(new Card(10,"TestCard","This is a test", 1));
		u.getBoards().get(0).getSwimLanes().get(0).getCards().get(0).getTasks().add(new Task("Test Task",1,false));
		u = userDao.save(u);
		return u.getBoards().get(0);
	}
	
	@GetMapping("/getAll")
	public List<AsbUser> getAll()
	{
		return userDao.findAll();
	}
	
	@GetMapping("/getAllBoards")
	public List<Board> getAllBoards()
	{
		return boardDao.findAll();
	}
  
}
