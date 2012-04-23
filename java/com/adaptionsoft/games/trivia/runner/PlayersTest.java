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
		players.addPlayer("Carles");
		players.addPlayer("Andres");
		players.addPlayer("Xavi");
		players.addPlayer("Cesc");
		players.addPlayer("Gerard");
	}
	
	@Test
	public void playersIsFull(){
		assertEquals(players.howManyPlayers(), maxPlayers);
	}
	
	@Test
	public void testMaxPlayers() {
		assertFalse(players.addPlayer("Cristiano"));
	}
	
	@Test
	public void nextPlayerWorks(){
		int i;
		for(i=0;i<maxPlayers-1;i++){
			players.nextPlayer();
		}
		assertEquals(maxPlayers-1, players.currentPlayer());
		players.nextPlayer();
		assertEquals(0, players.currentPlayer());
	}
	
	@Test
	public void testCurrentPlayersName(){
		assertEquals("Carles", players.currentPlayerName());
	}
	
	@Test
	public void testMaxPlacesLowerThanMax(){
		players.setPlace(3,12);
		assertEquals(3,players.getPlace());
	}
	
	@Test
	public void testMaxPlacesHigherThanMax(){
		players.setPlace(8,5);
		assertEquals(3,players.getPlace());
	}
	
	@Test
	public void testPutSomeCoins(){
		players.getsCoin();
		players.getsCoin();
		assertEquals(2,players.getPurse());
	}
	
	@Test
	public void testPenaltyBox(){
		players.setPenaltyBox(true);
		assertTrue(players.getPenaltyBox());
		players.setPenaltyBox(false);
		assertFalse(players.getPenaltyBox());
	}
	
	@Test
	public void testStillNotWinner(){
		players.getsCoin();
		players.getsCoin();
		assertTrue(players.stillNotWinner(4));
		assertFalse(players.stillNotWinner(2));
	}

}
