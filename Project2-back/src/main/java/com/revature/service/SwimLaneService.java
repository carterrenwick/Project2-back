package com.revature.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardDao;
import com.revature.dao.CardDao;
import com.revature.dao.SwimLaneDao;
import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.model.SwimLane;

@Service
public class SwimLaneService implements SwimLaneServiceContract{

	@Autowired
	SwimLaneDao swimLaneDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	CardDao cardDao;
	
	@Override
	public SwimLane createSwimLane(SwimLane swimLane, int boardId) {

		Board selectedBoard = boardDao.findOne(boardId);
		List<SwimLane> swimLaneList = selectedBoard.getSwimLanes();
		int order = 0;
		
		for(int i=0; i<swimLaneList.size(); i++) {
			if(order < swimLaneList.get(i).getOrder()) {
				order = swimLaneList.get(i).getOrder();
			}
		}
		
		swimLane.setOrder(order + 1);
		swimLane = swimLaneDao.save(swimLane);
		swimLaneList.add(swimLane);
		selectedBoard.setSwimLanes(swimLaneList);
		boardDao.save(selectedBoard);
		
		return swimLane;
	}
		

	@Override
	public void deleteSwimLane(SwimLane s, int boardId) 
	{
		swimLaneDao.delete(s);
		Board b = boardDao.findOne(boardId);
		List<SwimLane> slList = b.getSwimLanes();
		boolean correctOrder = true;
		CheckOrder: for (int i = 1; i <= slList.size()+1; i++)
		{
			for (SwimLane sl : slList)
			{
				if (sl.getOrder()==i) 
				{
					if (!correctOrder) 
					{
						sl.setOrder(i-1);
						swimLaneDao.save(sl);
					}
					continue CheckOrder;
				}
				correctOrder = false;
			}
		}
	}
	
	@Override
	public void moveCard(int cid, int sId1, int sId2) {
		Card c = cardDao.findOne(cid);
		SwimLane s1 = swimLaneDao.findOne(sId1);
		SwimLane s2 = swimLaneDao.findOne(sId2);
		s2.getCards().add(c);
		c.setOrder(s2.getCards().size());
		s1.getCards().remove(c);
		updateOrder(sId1);
		//updateOrder(sId2);  //Add this method if the user can somehow add a card in the middle of a lane
		swimLaneDao.save(s1);
		swimLaneDao.save(s2);
	}
	
	@Override
	public void updateOrder(int sid) {
		SwimLane s = swimLaneDao.findOne(sid);
		Collections.sort(s.getCards(), new Comparator<Card>(){
		    public int compare(Card c1, Card c2) {
		        return ((Integer) c1.getOrder()).compareTo((Integer) c2.getOrder());
		    }
		});
		for (int i = 1; i < s.getCards().size(); i++) {
			s.getCards().get(i).setOrder(i);
		}
	}

}
