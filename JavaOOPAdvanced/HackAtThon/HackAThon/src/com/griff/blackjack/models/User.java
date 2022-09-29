package com.griff.blackjack.models;

import java.util.ArrayList;

public class User {
	private ArrayList<Card> hand;
	
	public User() {
		this.hand = new ArrayList<Card>();
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	public void showHand() {
		for (Card card: this.hand) {
			card.showCard();
		}
	}
	
	public void clearHand() {
		this.hand.clear();
	}
	
	
		
}
