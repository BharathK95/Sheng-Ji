package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Player {

	private Pile hand;
	
	private String userID;
	
	public Player(String id){
		userID = id;
		hand = new Pile();
	}
	
	public Player(String id, Pile hand){
		userID = id; 
		this.hand = hand;
		sortHand();
	}
	
	public void addCardToHand(Card c){
		hand.addToPile(c);
		sortHand();
	}
	
	public void removeCardFromHand(Card c){
		sortHand();
		hand.remove(hand.get(Collections.binarySearch(hand.cardPile, c)));
	}
	
	public ArrayList<Card> playCards(ArrayList<Integer> indicesOfCards){
		ArrayList<Card> play = new ArrayList<Card>();
		for(int i : indicesOfCards){
			Card c = hand.get(i);
			if(hand.contains(c)){
				play.add(c);
				hand.remove(c);
			}
		}
		return play;
	}
	
	public int getHandSize(){
		return hand.size();
	}
	
	public boolean isHandEmpty(){
		return hand.isEmpty();
	}
	
	public String getID(){
		return userID;
	}
	
	public void sortHand(){
		hand.sortPile();
	}
	
	public Pile getHand(){
		sortHand();
		return hand;
	}

	
}
