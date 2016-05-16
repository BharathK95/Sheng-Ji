package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Team implements Iterable<Player> {
	
	private ArrayList<Player> players;
	
	private int points;
	
	private String teamID;
	
	public Team(String teamID){
		players = new ArrayList<Player>();
		this.teamID = teamID;
	}
	
	public Team(String teamID,ArrayList<Player> p){
		players = p;
		this.teamID = teamID;
	}

	public void setPoints(int p){
		points = p;
	}
	
	public String getTeamID(){
		return teamID;
	}
	
	public void addPoints(int add){
		points+=add;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void addPlayer(Player P){
		players.add(P);
	}
	
	public Player getPlayer(int i){
		return players.get(i);
	}

	@Override
	public Iterator<Player> iterator() {
		// TODO Auto-generated method stub
		return players.iterator();
	}
}
