package com.revature.service;

import com.revature.model.Card;

public interface CardServiceContract 
{
	void deleteCard(int cid);
	void createCard(Card card, int swimLaneId);


}
