package histogram;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/** 
 * This class reads a file and computes a histogram over all integers found in the file.
 * As in-parameter the program wants a text file
 * with integers separated with whitespaces and/or linebreaks.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:02, September 9, 2015.
 */
public class Histogram {

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
            System.out.println("Histogram needs a filename to run!");
            System.exit(1);
        }
        
		try {
			
	    	// Create and initialize Scanner and put the File in it.
		    Scanner sc = new Scanner(new File(fileName));
		    List<Integer> foundIntegers = new ArrayList<Integer>();
		    
	        System.out.println("Reading integers from the file: " + fileName);

	        // As long as there is integers to read in the file.
		    while(sc.hasNextInt()){
		    		        
		    	// Read next integer.
		    	int n = sc.nextInt();
		    	
		    	// If integer is between 1 and 200, add to the ArrayList.
                if(n >= 1 && n <= 200) {
                	foundIntegers.add(n);
                }
		    }
		    
		    // If there was no integers in the file or if the file contained more than integers.
		    if (foundIntegers.isEmpty()) {
		    	System.out.println("No integers were found in " + fileName);
		    } else {
		        System.out.println("Number of integers in the interval [1, 100]: " + getIntegersFoundOnInterval(foundIntegers, 1, 100));
		        System.out.println("in the interval [101, 200]: " + getIntegersFoundOnInterval(foundIntegers, 101, 200));
		        System.out.println();
		        System.out.println("Histogram");
		        System.out.println("1  - 10   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 1, 10)));
		        System.out.println("11 - 20   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 11, 20)));
		        System.out.println("21 - 30   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 21, 30)));
		        System.out.println("31 - 40   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 31, 40)));
		        System.out.println("41 - 50   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 41, 50)));
		        System.out.println("51 - 60   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 51, 60)));
		        System.out.println("61 - 70   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 61, 70)));
		        System.out.println("71 - 80   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 71, 80)));
		        System.out.println("81 - 90   |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 81, 90)));
		        System.out.println("91 - 100  |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 91, 100)));
		        System.out.println("101 - 200 |  " + intToStars(getIntegersFoundOnInterval(foundIntegers, 101, 200)));
		    }
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Counts how many integers found on specific interval.
	 * 
	 * @param foundIntegers	ArrayList<Integer>
	 * @param min			the minimum value of the interval
	 * @param max			the maximum value of the interval
	 * @return 				the final counting of found integers
	 */
	private static int getIntegersFoundOnInterval(List<Integer> foundIntegers, int min, int max) {
		int count = 0;
		
		// Loop through the ArrayList of found integers.
		for (int n : foundIntegers) {
			
			// If an element is inside the interval, count it.
			if (n >= min && n <= max) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Transforms the number of integers into stars.
	 * 
	 * @param n		the number to transform
	 * @return		the string of stars
	 */
	private static String intToStars(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("*");
		}
		return sb.toString();
	}
}