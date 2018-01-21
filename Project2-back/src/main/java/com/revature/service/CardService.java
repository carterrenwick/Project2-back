package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CardDao;
import com.revature.dao.SwimLaneDao;
import com.revature.model.Card;
import com.revature.model.SwimLane;
import com.revature.serviceInterface.CardSer;

@Service
public class CardService implements CardSer {

	@Autowired
	CardDao cardDao;
	
	@Autowired
	SwimLaneDao swimLaneDao;
	
	@Override
	public void createCard(String cardTitle, int swimLaneId) {
		Card card = new Card();
		card.setTitle(cardTitle);
		cardDao.save(card);
		
		SwimLane selectedSwimLane = swimLaneDao.findOne(swimLaneId);
		List<Card> cardList = selectedSwimLane.getCards();
		cardList.add(card);
		selectedSwimLane.setCards(cardList);
		swimLaneDao.save(selectedSwimLane);
	}

}
