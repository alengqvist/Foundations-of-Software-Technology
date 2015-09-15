package diamond;

import helpers.Input;


/** 
 * This class prints out a diamond shape as big as the input given by the user.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 14:22, September 6, 2015.
 */
public class Diamond {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
		// Get positive odd integer from user.
		int n = Input.getPositiveOddInt("Provide an positive odd integer: ");

		// Print out top of the diamond.
	    for (int i = 1; i < n; i += 2) {
	    	
	        for (int j = 0; j < 9 - i / 2; j++) {
	        	System.out.print(" ");
	        }
	        for (int j = 0; j < i; j++) {
	        	System.out.print("*");
	        }
	        System.out.print("\n");
	    }

	    // Print out bottom of the diamond.
	    for (int i = n; i > 0; i -= 2) {
    	  
	        for (int j = 0; j < 9 - i / 2; j++) {
	        	System.out.print(" ");
	        }
	        for (int j = 0; j < i; j++) {
	        	System.out.print("*");
	        }
	        System.out.print("\n");
	    }
	}
}