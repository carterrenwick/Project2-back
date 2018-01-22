package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardDao;
import com.revature.dao.SwimLaneDao;
import com.revature.model.Board;
import com.revature.model.SwimLane;

@Service
public class SwimLaneService implements SwimLaneServiceContract{

	@Autowired
	SwimLaneDao swimLaneDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public void createSwimLane(String swimLaneName, int boardId) {

		SwimLane swimLane = new SwimLane();
		swimLane.setName(swimLaneName);
		
		
		Board selectedBoard = boardDao.findOne(boardId);
		List<SwimLane> swimLaneList = selectedBoard.getSwimLanes();
		int order = 0;
		
		for(int i=0; i<swimLaneList.size(); i++) {
			if(order < swimLaneList.get(i).getOrder()) {
				order = swimLaneList.get(i).getOrder();
			}
		}
		
		swimLane.setOrder(order + 1);
		swimLaneDao.save(swimLane);
		swimLaneList.add(swimLane);
		selectedBoard.setSwimLanes(swimLaneList);
		boardDao.save(selectedBoard);
	}
		

	@Override
	public void deleteSwimLane(int swid) 
	{
		swimLaneDao.delete(swid);
	}
	
	

}
