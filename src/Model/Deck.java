package Model;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Card;

/**
 * Created by Bharath on 6/20/2015.
 */
public class Deck implements PileInterface, Iterable<Card>{

    private boolean hasJokers = false;
    
    private int numOfDecks = 1;
    
    private Pile p;

    public Deck(boolean hasJokers){
    	p = new Pile();
    	this.hasJokers = hasJokers;
    	init(hasJokers);
    	
    }
    
    public Deck(boolean hasJokers,int numDecks){
    	p = new Pile();
    	init(hasJokers);
    	numOfDecks = numDecks;
    	
    }
    
    private void init(boolean hasJokers){
    	clearPile();
            if(hasJokers){
                p.cardPile = new ArrayList<>(54*numOfDecks);
                for(int i = 0; i < numOfDecks; i++){
	                for(String s : Card.suitList){
	                    for(String f : Card.faceList){
	                    	p.cardPile.add(new Card(f,s));
	                    }
	                }
	                p.cardPile.add(new Card("Joker",Card.bigJokerSuit));
	                p.cardPile.add(new Card("Joker",Card.smallJokerSuit));
                }	
            }

            else{
            	p.cardPile = new ArrayList<>(52*numOfDecks);
                for(int i = 0; i < numOfDecks; i++){
                	for(String s : Card.suitList){
                		for(String f : Card.faceList){
                			p.cardPile.add(new Card(f,s));
                		}
                	}
                }	
            }
    	
    }

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		p.shuffle();
	}

	@Override
	public void addToPile(PileInterface P) {
		// TODO Auto-generated method stub
		p.addToPile(P);
	}

	@Override
	public void addToPile(Card c) {
		// TODO Auto-generated method stub
		p.addToPile(c);
	}

	@Override
	public Card drawCard() {
		// TODO Auto-generated method stub
		return p.drawCard();
	}

	@Override
	public boolean contains(Card c) {
		// TODO Auto-generated method stub
		return p.contains(c);
	}

	@Override
	public boolean remove(Card c) {
		// TODO Auto-generated method stub
		return p.remove(c);
	}
	
	@Override
    public boolean isEmpty(){
    	return p.isEmpty();
    }
	
	@Override
    public int size(){
    	return p.size();
    }
	
	@Override
    public Pile getPile(){
    	return p;
    }

	@Override
	public Iterator<Card> iterator() {
		// TODO Auto-generated method stub
		return p.iterator();
	}
	
	@Override
	public void clearPile(){
		p.clearPile();
	}
	
	@Override
	public void sortPile(){
		p.sortPile();
	}

	@Override
	public Card get(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		try{
			return p.get(i);
		}
		catch(IndexOutOfBoundsException e){
			throw e;
		}
	}
	

    public static void main(String... args){
    	Deck d1 = new Deck(true);
    	Deck d2 = new Deck(true);
    	Pile p = new Pile();
    	p.addToPile(d1);
    	p.addToPile(d2);
    	p.shuffle();
//    	System.out.println(Deck.class);
    	for(Card c : p){
    		System.out.println(c);
    	}
//    	System.out.println(p.size());
    	
    }

}
