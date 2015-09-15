package countdigits;

import helpers.Input;


/** 
 * This class lets the user enter a integer and then computes how many zeros, evens, odds there are and also
 * the total sum.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:47, September 5, 2015.
 */
public class CountDigits {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {

		// Define and initialize variables.
		int zeros = 0;
		int evens = 0;
		int odds = 0;
		int sum = 0;
		
		// Get positive integer from user.
		int n = Input.getPositiveInt("Provide a positive integer: ");

		// Find zeros, evens and odds.
		while (n > 0) {
						
			   if ((n % 10) == 0) {
			       zeros++;
			    } else if (n % 2 == 0) {
			       evens++;
			    } else { 
			       odds++;
			    }
			   
	            sum = sum + n % 10;
			    n /= 10;
		}
		
        // User output.
        System.out.printf("Zeros: %d%nEvens: %d%nOdds: %d%nSum: %d", zeros, evens, odds, sum);
	}
}