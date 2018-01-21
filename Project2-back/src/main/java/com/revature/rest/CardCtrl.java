package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.revature.serviceInterface.CardSer;


@RestController
public class CardCtrl {

	@Autowired
	CardSer cardSer;
	
	public void makeCard(String cardTitle, int swimLaneId) {
		
		cardSer.createCard(cardTitle, swimLaneId);
	}
}
