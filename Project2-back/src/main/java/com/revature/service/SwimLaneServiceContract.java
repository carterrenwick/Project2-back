package com.revature.service;

import com.revature.model.SwimLane;

public interface SwimLaneServiceContract 
{
	void deleteSwimLane(SwimLane s, int boardId);
	public SwimLane createSwimLane(SwimLane swimLane, int boardId);
	public void moveCard(int cId, int sId1, int sId2);
	public void updateOrder(int sid);
	public void updateSwimLane(SwimLane swimLane);
}
