package com.adaptionsoft.games.trivia.runner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameRunnerTest {

	@Test
	public void generalCharacterizationTest() {
		//fail("Not yet implemented");
		PrintStream stdout = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		GameRunner.main(null);
		
		System.setOut(stdout);
		System.out.print(baos.toString());
		
	}

}
