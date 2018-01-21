package com.revature.service;

public interface CardServiceContract 
{
	void deleteCard(int cid);
	public void createCard(String cardTitle, int swimLaneId, int difficulty, String description );

}
