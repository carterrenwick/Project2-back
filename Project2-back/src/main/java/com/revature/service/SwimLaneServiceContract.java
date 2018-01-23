package com.revature.service;

public interface SwimLaneServiceContract 
{
	void deleteSwimLane(int swid);
	public void createSwimLane(String swimLaneName, int boardId);
	public void moveCard(int cId, int sId1, int sId2);
	public void updateOrder(int sid);

}
