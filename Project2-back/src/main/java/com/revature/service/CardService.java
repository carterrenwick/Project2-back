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
	
		SwimLane selectedSwimLane = swimLaneDao.findOne(swimLaneId);
		List<Card> cardList = selectedSwimLane.getCards();
		int order = 0;
		
		for(int i=0; i<cardList.size(); i++) {
			if(order < cardList.get(i).getOrder()) {
				order = cardList.get(i).getOrder();
			}
		}
		
		card.setOrder(order + 1);
		card = cardDao.save(card);
		cardList.add(card);
		selectedSwimLane.setCards(cardList);
		swimLaneDao.save(selectedSwimLane);
		
		return card;
	}

	public void deleteCard(Card card, int slid) 
	{
		cardDao.delete(card);
		SwimLane sl = swimLaneDao.findOne(slid);
		List<Card> cList = sl.getCards();
		boolean correctOrder = true;
		CheckOrder: for (int i = 1; i <= cList.size()+1; i++)
		{
			for (Card c : cList)
			{
				if (c.getOrder()==i) 
				{
					if (!correctOrder) 
					{
						c.setOrder(i-1);
						cardDao.save(c);
					}
					continue CheckOrder;
				}
				correctOrder = false;
			}
		}
	}

	@Override
	public Card updateCard(Card card, int swimLaneId) 
	{
		Card temp = cardDao.getOne(card.getId());
		
		temp.setDescription(card.getDescription());
		temp.setTitle(card.getTitle());
		temp.setOrder(card.getOrder());
		temp.setDifficulty(card.getDifficulty());
		
		return cardDao.save(temp);
	}

}
