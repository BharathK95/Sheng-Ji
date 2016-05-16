package Model;

import java.util.Comparator;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

/**
 * Created by Bharath on 6/20/2015.
 */
public class Card implements Comparator<Card>, Comparable<Card> {
    public static String[] suitList = {"Heart","Spade","Diamond","Club"};

    public static String[] faceList = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    
    public static final String HEART = "Heart";
    
    public static final String SPADE = "Spade";

    public static final String DIAMOND = "Diamond";

    public static final String JACK = "Jack";
    
    public static final String QUEEN = "Queen";
    
    public static final String KING = "King";
    
    public static final String ACE = "Ace";
    
    public static final String bigJokerSuit = "1";

    public static final String smallJokerSuit = "0";
    
    public static final String jokerFaceID = "joker";
    
    private int cardID;

    private String face;

    private String suit;

    private boolean isJoker = false;

    // If card is joker, face is "joker" and suit is either "1" or "0" for big and small joker respectively
    public Card(String face, String suit){
        this.face = face;
        this.suit = suit;
        if(face.equalsIgnoreCase(jokerFaceID)){
            isJoker = true;
        }
        
        setID();
    }
    
    private void setID(){
    	if(isJoker){
        	if(suit.equalsIgnoreCase(("1"))){
        		cardID = -1;
        	}
        	
        	else if(suit.equalsIgnoreCase(("0"))){
        		cardID = -2;
        	}
        	return;
    	}
    	
    	if(suit.equalsIgnoreCase((suitList[0]))){
    		if(face.equalsIgnoreCase(ACE)){
    			cardID = 14;
    		}
    		
    		else if(face.equalsIgnoreCase(KING)){
    			cardID = 13;
    		}
    		
    		else if(face.equalsIgnoreCase(QUEEN)){
    			cardID = 12;
    		}
    		
    		else if(face.equalsIgnoreCase(JACK)){
    			cardID = 11;
    		}
    		
    		else{
    			cardID = Integer.parseInt(face);
    		}
    	}
    	
    	else if(suit.equalsIgnoreCase((suitList[1]))){
    		if(face.equalsIgnoreCase(ACE)){
    			cardID = 14+13;
    		}
    		
    		else if(face.equalsIgnoreCase(KING)){
    			cardID = 13+13;
    		}
    		
    		else if(face.equalsIgnoreCase(QUEEN)){
    			cardID = 12+13;
    		}
    		
    		else if(face.equalsIgnoreCase(JACK)){
    			cardID = 11+13;
    		}
    		
    		else{
    			cardID = Integer.parseInt(face)+13;
    		}
    	}
    	
    	else if(suit.equalsIgnoreCase((suitList[2]))){
    		if(face.equalsIgnoreCase(ACE)){
    			cardID = 14+26;
    		}
    		
    		else if(face.equalsIgnoreCase(KING)){
    			cardID = 13+26;
    		}
    		
    		else if(face.equalsIgnoreCase(QUEEN)){
    			cardID = 12+26;
    		}
    		
    		else if(face.equalsIgnoreCase(JACK)){
    			cardID = 11+26;
    		}
    		
    		else{
    			cardID = Integer.parseInt(face)+26;
    		}
    	}
    	
    	else if(suit.equalsIgnoreCase((suitList[3]))){
    		if(face.equalsIgnoreCase(ACE)){
    			cardID = 14+39;
    		}
    		
    		else if(face.equalsIgnoreCase(KING)){
    			cardID = 13+39;
    		}
    		
    		else if(face.equalsIgnoreCase(QUEEN)){
    			cardID = 12+39;
    		}
    		
    		else if(face.equalsIgnoreCase(JACK)){
    			cardID = 11+39;
    		}
    		
    		else{
    			cardID = Integer.parseInt(face)+39;
    		}
    	}
    	

    	
    }
    
    public static Card decodeCardID(int id) throws InvalidValue{
    	if(id == -1){
    		return new Card(jokerFaceID,bigJokerSuit);
    	}
    	
    	else if(id == -2){
    		return new Card(jokerFaceID,smallJokerSuit);
    	}
    	
    	
    	int count = 0;
    	while(id>=15){
    		id-=13;
    		count++;
    	}
    	
    	if(count>3){
    		throw new InvalidValue();
    	}
    	
    	return new Card(faceList[id-2], suitList[count]);
    	
    }

    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isJoker(){
        return isJoker;
    }
    
    public int getID(){
    	return cardID;
    }

    public String toString(){
    	if(isJoker){
    		if(suit.equals(bigJokerSuit)){
    			return "Big Joker";
    		}
    		else{
    			return "Small Joker";
    		}
    	}
    	return face +" of " +suit;
    }

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		if(this.cardID<o.cardID){
			return -1;
		}
		
		else if(this.cardID==o.cardID){
			return 0;
		}
		
		else{
			return 1;
		}
	}

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		if(o1.cardID<o2.cardID){
			return -1;
		}
		
		else if(o1.cardID==o2.cardID){
			return 0;
		}
		
		else{
			return 1;
		}	
	}
    
}
