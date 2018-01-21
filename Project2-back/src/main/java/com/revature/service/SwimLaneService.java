package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardDao;
import com.revature.dao.SwimLaneDao;
import com.revature.model.Board;
import com.revature.model.SwimLane;
import com.revature.serviceInterface.SwimLaneSer;

@Service
public class SwimLaneService implements SwimLaneSer{

	@Autowired
	SwimLaneDao swimLaneDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public void createSwimLane(String swimLaneName, int boardId) {

		SwimLane swimLane = new SwimLane();
		swimLane.setName(swimLaneName);
		swimLaneDao.save(swimLane);
		
		Board selectedBoard = boardDao.findOne(boardId);
		List<SwimLane> swimLaneList = selectedBoard.getSwimLanes();
		swimLaneList.add(swimLane);
		selectedBoard.setSwimLanes(swimLaneList);
		boardDao.save(selectedBoard);
		
	}

}
