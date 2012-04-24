
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {

		//Random rand = new Random();
		RandomUnderControl rand = new RandomUnderControl();
		
		Game aGame = new Game(6, 6, 12, 2, 50, 3);
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
	
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
		} while (notAWinner && aGame.isPlayable());
		
	}
}
