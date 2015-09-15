package largestk;

import helpers.Input;


/** 
 * This class lets the user enter a integer value and then finds the largest K. 
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:57, September 4, 2015.
 */
public class LargestK {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {

		// Define and initialize variables.	
		int k = 0;						// Largest K.
		int sum = 0;					// Sum of all Ks.

		// Get positive integer from user.
		int n = Input.getPositiveInt("Enter a positive integer: ");
				
		// Find the last K. (0+2+4+6+8...+ k <= n)
        for(int i = 0; sum <= n; i += 2) {
            sum += i;
            
            // As long as the sum is under N, store latest K.
            if (sum <= n) {
                k = i;
            }
        }

        // User output.
        System.out.printf("Input N: %d %nLargest K: %d", n, k);
	}
}