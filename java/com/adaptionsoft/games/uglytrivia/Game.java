package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

import com.adaptionsoft.games.trivia.runner.Players;

public class Game {
	int coinsToWin = 6;
	int maxPlaces = 12;
	int maxPlayers = 6;
    Players players = new Players(maxPlayers);

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    boolean isGettingOutOfPenaltyBox;
    
    public Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}

	/**
	 * @return true if the game is playable.
	 */
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
	    players.addPlayer(playerName);
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.howManyPlayers());
		return true;
	}
	
	public boolean remove(String playerName) {
	  //players.remove(howManyPlayers());
	  return true;
	}
	
	public int howManyPlayers() {
		return players.howManyPlayers();
	}

	public void roll(int roll) {
		System.out.println(players.currentPlayerName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (players.getPenaltyBox()) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				System.out.println(players.currentPlayerName() + " is getting out of the penalty box");
				movePlayer(roll);
			} else {
				System.out.println(players.currentPlayerName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
			movePlayer(roll);
		}
	}

	private void movePlayer(int roll) {
		players.setPlace(roll, maxPlaces);
		
		System.out.println(players.currentPlayerName() 
				+ "'s new location is " 
				+ players.getPlace());
		System.out.println("The category is " + currentCategory());
		askQuestion();
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	// randomly return a category
	private String currentCategory() {
		if (players.getPlace() == 0) return "Pop";
		if (players.getPlace() == 4) return "Pop";
		if (players.getPlace() == 8) return "Pop";
		if (players.getPlace() == 1) return "Science";
		if (players.getPlace() == 5) return "Science";
		if (players.getPlace() == 9) return "Science";
		if (players.getPlace() == 2) return "Sports";
		if (players.getPlace() == 6) return "Sports";
		if (players.getPlace() == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (players.getPenaltyBox()){
			if (isGettingOutOfPenaltyBox) {
				return correctAnswerWhenOutOfPenaltyBox();
			} else {
				players.nextPlayer();
				return true;
			}
		} else {
			return correctAnswerWhenOutOfPenaltyBox();
		}
	}

	private boolean correctAnswerWhenOutOfPenaltyBox() {
		System.out.println("Answer was correct!!!!");
		players.getsCoin();
		System.out.println(players.currentPlayerName() 
				+ " now has "
				+ players.getPurse()
				+ " Gold Coins.");
		
		boolean winner = players.stillNotWinner(coinsToWin);
		players.nextPlayer();
		return winner;
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.currentPlayerName()+ " was sent to the penalty box");
		players.setPenaltyBox(true);
		players.nextPlayer();
		return true;
	}

}
