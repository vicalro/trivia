package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayersTest {

	public Players players;
	public int maxPlayers;
	
	@Before
	public void initializePlayersTest(){
		maxPlayers = 5;
		players = new Players(maxPlayers);
	}
	
	@Test
	public void playersIsEmpty(){
		assertEquals(players.howManyPlayers(), 0);
	}
	
	@Test
	public void testMaxPlayers() {
		players.addPlayer("Carles");
		players.addPlayer("Andres");
		players.addPlayer("Xavi");
		players.addPlayer("Cesc");
		players.addPlayer("Gerard");
		
		assertFalse(players.addPlayer("Cristiano"));
	}
	
	@Test
	public void nextPlayerWorks(){
		
		players.addPlayer("Carles");
		players.addPlayer("Andres");
		players.addPlayer("Xavi");
		players.addPlayer("Cesc");
		players.addPlayer("Gerard");
		
		int i;
		for(i=0;i<maxPlayers-1;i++){
			players.nextPlayer();
		}
		assertEquals(maxPlayers-1, players.currentPlayer());
		players.nextPlayer();
		assertEquals(0, players.currentPlayer());
	}
	

}
