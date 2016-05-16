package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Bharath on 6/20/2015.
 */
public class Pile implements PileInterface, Iterable<Card>{

    protected ArrayList<Card> cardPile;

    public Pile(){
        cardPile = new ArrayList<Card>();
    }

    public void shuffle(){
    	Collections.shuffle(cardPile);
    }
    
    public void addToPile(PileInterface P){
    	for(Card c : P.getPile()){
    		this.cardPile.add(c);
    	}
    }
    
    public void addToPile(Card c){
    	cardPile.add(c);
    }
    
    public Card drawCard(){
    	if(cardPile.isEmpty()){
    		return null;
    	}
    	else{
        	return cardPile.remove(0);
    	}
    }
    
    public boolean contains(Card c){
    	for(Card x : cardPile){
    		if(x.getFace().equalsIgnoreCase(c.getFace())&&x.getSuit().equalsIgnoreCase(c.getSuit())){
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean remove(Card c){
    	for(Card x : cardPile){
    		if(x.getFace().equalsIgnoreCase(c.getFace())&&x.getSuit().equalsIgnoreCase(c.getSuit())){
    			cardPile.remove(x);
    			return true;
    		}
    	}
    	return false; 
    }
    
    public boolean isEmpty(){
    	return cardPile.isEmpty();
    }
    
    public int size(){
    	return cardPile.size();
    }
    
    public Pile getPile(){
    	return this;
    }

	@Override
	public Iterator<Card> iterator() {
		// TODO Auto-generated method stub
		return cardPile.iterator();
	}

	@Override
	public void clearPile() {
		// TODO Auto-generated method stub
		cardPile.clear();
	}

	@Override
	public void sortPile() {
		// TODO Auto-generated method stub
		Collections.sort(cardPile);
	}

	@Override
	public Card get(int i) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		try{
			return cardPile.get(i);
		}
		catch(IndexOutOfBoundsException e){
			throw e;
		}
	}
}
