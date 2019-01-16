package com.firebolt.batua.batuarestservices.card;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CardHardCodedService {

	private static List<Card> cards = new ArrayList();
	private static int idCounter = 0;
	
	static {
		cards.add(new Card(++idCounter, "ICICI", new Date()));
		cards.add(new Card(++idCounter, "Yes Bank", new Date()));
		cards.add(new Card(++idCounter, "Citi Bank", new Date()));
		cards.add(new Card(++idCounter, "SBI", new Date()));
	}
	
	public List<Card> findAll(){
		return cards;
	}
	
	public Card deleteById(long id) {
		Card card = findById(id);
		if(card == null) {
			return null;
		}
		
		if(cards.remove(card)) {
			return card;
		}
		return null;
	}

	public Card findById(long id) {
		for(Card card : cards) {
			if(card.getId() == id) {
				return card;
			}
		}
		return null;
	}
	
	public Card save(Card card) {
		if(card.getId() == -1 || card.getId() == 0) {
			card.setId(++idCounter);
			cards.add(card);
		}
		else {
			deleteById(card.getId());
			cards.add(card);
		}
		return card;
	}
}
