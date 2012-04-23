package com.adaptionsoft.games.trivia.runner;

import java.util.ArrayList;

public class Players {
	
	int numPlayers, currentPlayer, maxPlayers;
	ArrayList names;
	int[] places, purses, highscores;
	boolean[] inPenaltyBox;
	
	public Players(int maxPlayers){
		names = new ArrayList();
	    places = new int[maxPlayers];
	    purses  = new int[maxPlayers];
	    inPenaltyBox  = new boolean[maxPlayers];
	    highscores= new int[maxPlayers];
	    numPlayers = 0;
	    currentPlayer = 0;
	    this.maxPlayers = maxPlayers;
	}
	
	public int howManyPlayers(){
		return numPlayers;
	}
	
	public boolean addPlayer(String playerName){
		if(numPlayers<maxPlayers){
			names.add(playerName);
			places[numPlayers] = 0;
			purses[numPlayers] = 0;
			inPenaltyBox[numPlayers] = false;
			numPlayers++;
			return true;
		}
		else{
			System.out.println(playerName + " not added. Game full");
			return false;
		}
	}
	
	public void nextPlayer(){
		currentPlayer++;
		if (currentPlayer >= numPlayers) currentPlayer = 0;
	}
	
	public int currentPlayer(){
		return this.currentPlayer;
	}
	
	public Object currentPlayerName(){
		return names.get(currentPlayer);
	}
	
	public int getPlace (){
		return places[currentPlayer];
	}
	
	public void setPlace (int roll, int maxPlaces){
		places[currentPlayer]+=roll;
		if (places[currentPlayer]>=maxPlaces)
			places[currentPlayer]-=maxPlaces;
	}
	
	public int getPurse (){
		return purses[currentPlayer];
	}
	
	public void getsCoin(){
		purses[currentPlayer]++;
	}
	
	public void setPenaltyBox(boolean status){
		inPenaltyBox[currentPlayer]=status;
	}
	
	public boolean getPenaltyBox(){
		return inPenaltyBox[currentPlayer];
	}
	
	public boolean stillNotWinner(int coinsToWin){
		return (purses[currentPlayer]<coinsToWin);
	}
	
	public void removePlayer(){
		
	}

}
