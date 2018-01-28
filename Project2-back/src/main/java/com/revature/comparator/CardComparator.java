package com.revature.comparator;

import java.util.Comparator;

import com.revature.model.Card;

public class CardComparator implements Comparator<Card>{

	@Override
	public int compare(Card o1, Card o2) {
		//ascending order
		return o1.getOrder() - o2.getOrder();
	}

	
}
