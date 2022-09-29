package com.griff.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack {
	private Deck deck = new Deck();;
	private User dealer1 = new User();
	private User user1 = new User();
	boolean isOver = false;
	

	public BlackJack() {
		// TODO Auto-generated constructor stub
	}
	
	public int dealerPoints(){
		ArrayList<Card> dealerhand = dealer1.getHand();
		int values = 0;
		for(Card card : dealerhand) {
			values += card.getRank();
		}
		return values;
	}
	
	public int userPoints() {
		ArrayList<Card> userhand = user1.getHand();
		int values = 0;
		for(Card card : userhand) {
			values += card.getRank();
		}
		return values;
	}
	
	public boolean isBlackJack() {
		if(this.dealerPoints()==21) {
			System.out.println("Dealer has:");
			this.dealer1.showHand();
			System.out.println("You lose, Dealer get BlackJack.");
			return true;
		}
		if(this.userPoints() == 21) {
			System.out.println("You have:");
			this.user1.showHand();
			System.out.println("YOU WON! BLACKJACK!");
			return true;
		}
		return false;
	}
	
	public boolean isBust() { // to make codes more efficient, pass in parameter of object. Create a public method in User class to calculate the total points.
		if(this.dealerPoints() > 21) {
			System.out.format("Dealer total point is: %d \n", this.dealerPoints());
			System.out.println("YOU WON! Dealer busted.");
			return true;
		}
		if(this.userPoints() > 21) {
			for(Card card: user1.getHand()) {
				if(card.getRank() == 11) {
					card.setRank(1); //not sure if this works
					return false;
				}
			}
			System.out.println("BUSTED!!!!!");
			return true;
		}
		return false;
	}
	
	public Card dealCard() {
		Card card = this.deck.getCards().remove(0);
		if(card.getRank() > 10) {
			card.setRank(10);
		}
		if(card.getRank() == 1) {
			if(this.dealerPoints()< 7) {
				card.setRank(11);
			}
		}
		dealer1.addCard(card);
		return card;
	}
	
	public Card dealCardUser() {
		Card card = this.deck.getCards().remove(0);
		if(card.getRank() > 10) {
			card.setRank(10);
		}
		if(card.getRank() == 1) {
			if(this.userPoints()< 11) {
				card.setRank(11);
			}
		}
		user1.addCard(card);
		return card;
		
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck.getCards());
	}
		
	public void playAgain() {
		System.out.println("\n");
		System.out.println("Would you like to Play Again?\nEnter '1' to Play Again \nEnter '2' to Close");
		Scanner s = new Scanner(System.in);
		int choice = Integer.parseInt(s.next());
		
		switch(choice) {
			case 1:
				user1.clearHand();
				dealer1.clearHand();
				deck = new Deck();
				this.game();
			case 2:
				break;
			default:
				System.out.println("Please enter valid choice");
		}
	}
	
	public void userChoice() {
		System.out.println("What would you like to do?\n Enter '1' to HIT\n Enter '2' to Pass");
		Scanner s = new Scanner(System.in);
		int choice = Integer.parseInt(s.next());
		
		switch(choice) {
			case 1: //HIT
				Card card = this.dealCardUser();
				System.out.println("The new card is:");
				card.showCard();
				System.out.format("Your total point is: %d \n", this.userPoints());
				if(this.isBust()) {
					this.playAgain();
				}
				this.userChoice();
				break;
			case 2: //PASS
				break;
			default:
				System.out.println("Please enter valid choice");
		}
	}
	
	public boolean game() {
		System.out.println("===========Welcome to Black Jack===========");
		System.out.println("*******************************************");
		this.shuffleDeck();
		this.dealCard();
		System.out.println("The dealer's revealed card is:");
		this.dealer1.showHand();
		System.out.println("");
		this.dealCardUser();
		this.dealCard();
		this.dealCardUser();	
		if(this.isBlackJack()) {
			this.playAgain();
			return true;
		}
		System.out.println("You have:");
		this.user1.showHand();
		this.userChoice();
		System.out.println("Dealer has:");
		this.dealer1.showHand();
		while(this.dealerPoints() < 17) {
			System.out.println("");
			System.out.println("Dealer draws one more card");
			Card card = this.dealCard();
			System.out.println("The new card is:");
			card.showCard();
			System.out.format("Dealer total point is: %d \n", this.dealerPoints());
			if(this.isBust()) {
				this.playAgain();
				return true;
			}
		}
		System.out.println("\n");
		System.out.println("Dealer's Hand:");
		this.dealer1.showHand();
		
		if(this.userPoints() > this.dealerPoints()) {
			System.out.println("You won!");
			this.playAgain();
			return this.isOver = true;
		}
		else if (this.userPoints() == this.dealerPoints()) {
			System.out.println("DRAW!");
			this.playAgain();
			return this.isOver = true;
		}
		else {
			System.out.println("You lose.");
			this.playAgain();
			return this.isOver = true;
		}
	
	}
	

}
