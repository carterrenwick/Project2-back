package com.revature.service;

import com.revature.model.Card;

public interface CardServiceContract 
{
	void deleteCard(Card c, int slid);
	Card createCard(Card card, int swimLaneId);
	Card updateCard(Card card, int swimLaneId);


}
