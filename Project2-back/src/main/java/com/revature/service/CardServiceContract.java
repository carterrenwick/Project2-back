package com.revature.service;

import com.revature.model.Card;

public interface CardServiceContract 
{
	void deleteCard(int cid);
	public void createCard(Card card, int swimLaneId);

}
