package backwards;

import helpers.Input;


/** 
 * This class lets the user enter a string which then gets reversed and displayed backwards.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:26, September 4, 2015.
 */
public class Backwards {
	
	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
		// Get input string from user.
		String text = Input.getString("Type a line of text: ");
						
		// Reverse the string with StringBuilder.
        String reversed = new StringBuilder(text).reverse().toString();

		// User output.
		System.out.println(reversed);
	}
}