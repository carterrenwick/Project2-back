package com.revature.service;

import com.revature.model.Card;

public interface CardServiceContract 
{
	void deleteCard(Card c);
	void createCard(Card card, int swimLaneId);


}
