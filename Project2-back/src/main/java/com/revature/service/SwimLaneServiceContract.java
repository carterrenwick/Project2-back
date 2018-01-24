package com.revature.service;

import com.revature.model.SwimLane;

public interface SwimLaneServiceContract 
{
	void deleteSwimLane(int swid);
	public void createSwimLane(SwimLane swimLane, int boardId);
	public void moveCard(int cId, int sId1, int sId2);
	public void updateOrder(int sid);

}
