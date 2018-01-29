package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CardDao;
import com.revature.dao.SwimLaneDao;
import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.model.SwimLane;

@Service
public class CardService implements CardServiceContract {

	@Autowired
	CardDao cardDao;

	@Autowired
	SwimLaneDao swimLaneDao;

	@Override
	public Card createCard(Card card, int swimLaneId) {
		Card card2 = new Card();
		if (card.getId() != 0) 
		{
			card2 = cardDao.getOne(card.getId());
			
			card2.setDescription(card.getDescription());
			card2.setDifficulty(card.getDifficulty());
			card2.setOrder(card.getOrder());
			card2.setTitle(card.getTitle());
			
			cardDao.save(card2);
		}
		else
		{
		SwimLane selectedSwimLane = swimLaneDao.findOne(swimLaneId);
		List<Card> cardList = selectedSwimLane.getCards();
		int order = 0;

		for (int i = 0; i < cardList.size(); i++) {
			if (order < cardList.get(i).getOrder()) {
				order = cardList.get(i).getOrder();
			}
		}

		card.setOrder(order + 1);
		card = cardDao.save(card);
		selectedSwimLane.getCards().add(card);
		swimLaneDao.save(selectedSwimLane);
		}

		return card;
	}

	public void deleteCard(Card card, int slid) {
		cardDao.delete(card);
		SwimLane sl = swimLaneDao.findOne(slid);
		List<Card> cList = sl.getCards();
		boolean correctOrder = true;
		CheckOrder: for (int i = 1; i <= cList.size() + 1; i++) {
			for (Card c : cList) {
				if (c.getOrder() == i) {
					if (!correctOrder) {
						c.setOrder(i - 1);
						cardDao.save(c);
					}
					continue CheckOrder;
				}
				correctOrder = false;
			}
		}
	}

}
