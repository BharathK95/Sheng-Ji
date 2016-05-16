package Model;

public interface PileInterface{
   
	public void shuffle();
    
    public void addToPile(PileInterface P);
    
    public void addToPile(Card c);
    
    public Card drawCard();
    
    public boolean contains(Card c);
    
    public boolean remove(Card c);
    
    public boolean isEmpty();
    
    public int size();
    
    public Pile getPile();
    
    public void clearPile();
    
    public void sortPile();
    
    public Card get(int i) throws IndexOutOfBoundsException;
}
