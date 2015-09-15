package helpers;

import java.util.Scanner;


/** 
 * This Helper class uses the Scanner class to handle console interactions between the user and the program.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:05, September 4, 2015.
 */
public class Input {
	
	// Constant.
	private final static int MIN_POSITIVE_INTEGER = 0;
	
	
	/**
	 * Query to get String from user.
	 * 
	 * @param message	prompt message in console
	 * @return			the input string from user
	 */
    private static String queryString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String input = scanner.nextLine();
        return input;
    }

	/**
	 * Query to get Integer from user.
	 * 
	 * @param message	prompt message in console
	 * @return			the input integer from user
	 */
    private static int queryInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int input = scanner.nextInt();
        return input;
    }

	/**
	 * Get string from user.
	 * 
	 * @param message	prompt message in console
	 * @return			the queried string
	 */
	public static String getString(String message) {
		return queryString(message);
	}
	
	/**
	 * Get positive integer from user.
	 * 
	 * @param message	prompt message in console
	 * @return			the queried and validated positive integer.
	 */
	public static int getPositiveInt(String message) {
		
	    int input = -1;
		boolean isValid = false;
		
		// Ask until input isValid.
		while (!isValid) {
		    try {
		    	
		        input = queryInt(message);
		        
		        // Validate if the input is positive.
		    	if (isPositiveInteger(input)) {
		    		isValid = true;
		    	} else {
			        System.out.println("You didn't enter a positive integer!");
		    	}
		    	
		    } catch(Exception e) {
		        // Do nothing.
		    }
		}
        return input;
	}
	
	/**
	 * Get positive odd integer from user.
	 * 
	 * @param message	prompt message in console
	 * @return			the queried and validated positive odd integer.
	 */
	public static int getPositiveOddInt(String message) {
		
	    int input = -1;
		boolean isValid = false;
		
		// Ask until input isValid.
		while (!isValid) {
		    try {
		    	
		        input = queryInt(message);
		        
		        // Validate if the input is positive and odd.
		    	if (isPositiveInteger(input) && isOdd(input)) {
		    		isValid = true;
		    	} else {
			        System.out.println("You didn't enter a positive odd integer!");
		    	}
		    	
		    } catch(Exception e) {
		        // Do nothing.
		    }
		}
        return input;
	}
	
	/** Validates if number is positive.
	 * @param n		the integer to validate
	 * @return		if the integer is positive
	 */
	private static boolean isPositiveInteger(int n) {
    	if (n > MIN_POSITIVE_INTEGER ) {
    		return true;
    	} else {
    		return false;
    	} 
	}
	
	/** Validates if number odd.
	 * @param n		the integer to validate
	 * @return		if the integer is odd
	 */
	private static boolean isOdd(int n) {
    	if (n % 2 != 0) {
    		return true;
    	} else {
    		return false;
    	} 
	}
}