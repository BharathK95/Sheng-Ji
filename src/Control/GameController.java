package Control;

import java.util.ArrayList;

import Model.Deck;
import Model.Packet;
import Model.Pile;
import Model.Player;
import Model.Team;

public class GameController {

	protected Pile mainDeck;
	
	protected Pile deadPile;
	
	protected Pile playPile;
	
	protected ArrayList<Player> players;
	
	protected int currPlayerIndex;
	
	protected Team t1;
	
	protected Team t2;
	
	protected String trumpface = "2";

	protected String trumpSuit;
	
	protected Team inControl;
	
	protected GameState currState;
	
	
	private static final String Team1ID = "Team 1";
	private static final String Team2ID = "Team 2";
	
	public GameController(){
		players = new ArrayList<Player>();
		t1 = new Team(Team1ID);
		t2 = new Team(Team2ID);
	}
	
	public GameController(String startingTrumpFace){
		trumpface = startingTrumpFace;
		players = new ArrayList<Player>();
		t1 = new Team(Team1ID);
		t2 = new Team(Team2ID);
	}
	
	
	public GameController(int numOfPlayers,String startingTrumpFace){
		players = new ArrayList<Player>(numOfPlayers);
		trumpface = startingTrumpFace;
	}
	
	public void setTrumpface(String trumpface) {
		this.trumpface = trumpface;
	}

	public void setInControl(Team inControl) {
		this.inControl = inControl;
	}
	
	public Pile getMainDeck() {
		return mainDeck;
	}

	public Pile getDeadPile() {
		return deadPile;
	}
	
	public String getTrumpSuit() {
		return trumpSuit;
	}

	public void setTrumpSuit(String trumpSuit) {
		this.trumpSuit = trumpSuit;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Team getT1() {
		return t1;
	}

	public Team getT2() {
		return t2;
	}

	public String getTrumpface() {
		return trumpface;
	}

	public Team getInControl() {
		return inControl;
	}

	public static String getTeam1id() {
		return Team1ID;
	}

	public static String getTeam2id() {
		return Team2ID;
	}
	
	public void nextPlayer(){
		if(currPlayerIndex>=players.size()-1){
			currPlayerIndex=0;
		}
		else{
			currPlayerIndex++;
		}
		
	}

	
	public void startGame(){
		for(int i = 0; i<players.size();i+=2){
			int r = (int)(Math.random()*2);
			if(r%2==0){
				t1.addPlayer(players.get(i));
				t2.addPlayer(players.get(1+1));
			}
			else{
				t2.addPlayer(players.get(i));
				t1.addPlayer(players.get(1+1));
			}
		}
		mainDeck = new Pile();
		deadPile = new Pile();
		mainDeck.addToPile(new Deck(true));
		mainDeck.addToPile(new Deck(true));
		mainDeck.shuffle();
		
	}
	
	public void drawCard(String userID){
			for(Player p : players){
				if(p.getID().equalsIgnoreCase(userID)){
					p.addCardToHand(mainDeck.drawCard());
					p.sortHand();
				}
			}
	}
	
	public void playCard(){
		
	}
	
	public void setState(String s){
		
	}
	
	public String getState(){
		return "";
	}
	
	public void addPlayer(Player p){
		players.add(p);
	}
	
	public void processEvent(Packet p){
		
	}
	
}
