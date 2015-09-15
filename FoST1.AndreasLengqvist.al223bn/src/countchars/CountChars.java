package countchars;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/** 
 * This class reads a file and counts all types of characters.
 * As in-parameter the program wants a text file.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:22, September 7, 2015.
 */
public class CountChars {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
        String fileName = "";
        
        // Check if filename was given as in-parameter.
        if(args.length != 0) {
        	fileName = args[0];
        }
        else {
            System.out.println("CountChars needs a filename to run!");
            System.exit(1);
        }
		
        // Define variables.
		int lowerCases = 0;
		int upperCases = 0;
		int whitespaces = 0;
		int otherChars = 0;
		int numbers = 0;
			    
	    try {
	    	
	    	// Create and initialize Scanner and put the File in it.
	        Scanner sc = new Scanner(new File(fileName));
	        
	        // As long as there is something to read in the file.
	        while(sc.hasNext()){
	        		        		    
	        	// Break down each line into a charArray and loop through each char.
	            for(char c : sc.nextLine().toCharArray()){

	                if(Character.isLowerCase(c)) {
	                	lowerCases++;
	                } else if(Character.isUpperCase(c)) {
	                    upperCases++;
	                } else if(Character.isWhitespace(c)) {
	                    whitespaces++;
	                } else if(Character.isDigit(c)) {
	                    numbers++;
	                } else {
	                	otherChars++;
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    }
	    
	    // User output.
        System.out.printf("Lowercase letters: %d%nUppercase letters: %d%nWhitespaces: %d%nOther Characters: %d%nNumbers: %d", lowerCases, upperCases, whitespaces, otherChars, numbers);
	}
}