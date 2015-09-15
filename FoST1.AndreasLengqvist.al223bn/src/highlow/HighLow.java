package highlow;

import helpers.Input;

import java.util.Random;


/** 
 * This class selects a random number between 1 and 100. 
 * The player then tries to guess its value. After each guess the program gives a hint "higher" or "lower".
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 14:22, September 6, 2015.
 */
public class HighLow {
	
	// Define and initialize variables.
	private final static int MAX_NUMBER_GUESSES = 10;
	private final static int MAX_GUESS = 100;
	private final static int MIN_GUESS = 1;
	
	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
		// Define and initialize variables.		
		Random random = new Random();					// Instance of Random.
		int correctNumber = random.nextInt(100) + 1;	// Random number between.
		int guessedNumber = 0;							// Guessed number.
		int guesses = 0;								// Number of guesses.
		boolean isValid = false;						// Whether or not the guess is valid. (1 - 100)
		
		while (guessedNumber != correctNumber) {
			
			// Increase the guesses by 1.
			guesses ++;

			// If the guesses reached the maximum number of guesses.
			if (guesses > MAX_NUMBER_GUESSES) {
				System.out.println("You are out of guesses. Game Over!");
				System.exit(1);
			}
			
			// Let the user input until its a valid guess.
			isValid = false;
			while (!isValid) {
				
				// Get guess from user input.
				guessedNumber = Input.getPositiveInt("Guess " + guesses + ": ");
				
				// Check if guess is a valid number.
				if (guessedNumber >= MIN_GUESS && guessedNumber <= MAX_GUESS) {
					isValid = true;
				} else {
					System.out.println("Guessed number must be between 1 - 100!");
				}
			}
			
			// Check if guessedNumber is higher, lower or correct from the correctNumber.
			if (guessedNumber > correctNumber) {
				System.out.println("Hint: Lower");
			} else if (guessedNumber < correctNumber) {
				System.out.println("Hint: Higher");
			} else {
				System.out.printf("Correct after only %d guesses - Brilliant!", guesses);
			}
		}
	}
}