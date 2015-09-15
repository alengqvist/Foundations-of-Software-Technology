package game123;

import deck.Card;
import deck.Card.Rank;
import deck.Deck;

/** 
 * This class plays the card game 123.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:27, September 10, 2015.
 */
public class Game123 {
	
	// Define and initialize variables.
	private static final int NUM_OF_GAMES = 10000;

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
		// Number of games won.
		int wonGames = 0;

		// Play as many games as the NUM_OF_GAMES says.
		for (int i = 0; i < NUM_OF_GAMES; i++) {
			Game123 game = new Game123();
			if (game.play123()) {
				wonGames++;
			}
		}
		
		// User output.
		System.out.printf("The probability to win in %d games is %.2f%%", NUM_OF_GAMES, ((double)wonGames/NUM_OF_GAMES*100));
	}

	/**
	 * Plays the 123 card game.
	 * 
	 * @return if the game was won
	 */
	private boolean play123() {
				
		// Create a new Deck.
		Deck deck = new Deck();
		
		// Shuffle the Deck.
		deck.shuffle();
		int count = 0;
		
		// Until the Deck is empty.
		while (deck.deckSize() > 0) {
						
			// Hand out next card.
			Card card = deck.handOutNextCard(); 

			// Playing...
			// Depending on the counting 1, 2 or 3 which is set by the counter and the modulus operator.  
            switch(count % 3) {
            case 1:
                if(card.getRank() == Rank.ACE) { return false; }
                break;
            case 2:
                if(card.getRank() == Rank.DEUCE) { return false; }
                break;
            case 0:
                if(card.getRank() == Rank.THREE) { return false; }
                break;
            }
            count++;
		}
		return true;
	}
}