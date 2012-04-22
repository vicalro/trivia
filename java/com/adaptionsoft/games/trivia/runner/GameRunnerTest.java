package com.adaptionsoft.games.trivia.runner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunnerTest {

	@Test
	public void generalCharacterizationTest() {
		
		PrintStream stdout = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		GameRunner.main(null);
		
		//ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		//System.setOut(new PrintStream(baos2));
		//GameRunner.main(null);
		
		System.setOut(stdout);
		System.out.print(baos.toString());
		//assertEquals(baos.toString(), baos2.toString());
		
	}
	
	@Test
	public void  testForMethodIsPlayableOnePlayer(){
		Game aGame = new Game();
		aGame.add("John");
		assertFalse(aGame.isPlayable());
	}
	
	@Test
	public void  testForMethodIsPlayableTwoPlayers(){
		Game aGame = new Game();
		aGame.add("John");
		aGame.add("Maria");
		assertTrue(aGame.isPlayable());
	}
	
	@Test
	public void whiteBoxTestMariaAlwaysWinsJohnDoesnt(){
		Game aGame = new Game();
		aGame.add("John");
		aGame.add("Maria");
		aGame.roll(2);
		assertTrue(aGame.wrongAnswer());
		aGame.roll(2);
		assertTrue(aGame.wasCorrectlyAnswered());
		
		aGame.roll(1);
		assertTrue(aGame.wrongAnswer());
		aGame.roll(2);
		assertTrue(aGame.wasCorrectlyAnswered());
		
		aGame.roll(2);
		assertTrue(aGame.wrongAnswer());
		aGame.roll(2);
		assertTrue(aGame.wasCorrectlyAnswered());
		
		aGame.roll(2);
		assertTrue(aGame.wasCorrectlyAnswered());
		aGame.roll(2);
		assertTrue(aGame.wasCorrectlyAnswered());
		
		aGame.roll(2);
		assertTrue(aGame.wrongAnswer());
		aGame.roll(2);
		assertTrue(aGame.wasCorrectlyAnswered());
		
		aGame.roll(2);
		assertTrue(aGame.wasCorrectlyAnswered());
		aGame.roll(2);
		assertFalse(aGame.wasCorrectlyAnswered());
	}

}
