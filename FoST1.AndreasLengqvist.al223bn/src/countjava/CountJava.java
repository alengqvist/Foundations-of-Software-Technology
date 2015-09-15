package countjava;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/** 
 * This class takes a directory and lists all the .java-files in that directory and its sub-directories
 * and also how many rows each file contain.
 * As in-parameter the program wants a path to the directory.
 * 
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:02, September 9, 2015.
 */
public class CountJava {
	
	// Id file counting.
	private static int count = 0;

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
        
        String path = "";
        
        // Check if path was given as in-parameter.
        if(args.length != 0) {
        	path = args[0];
        }
        else {
            System.out.println("CountJava needs a path to run!");
            System.exit(1);
        }
        
    	System.out.println("Reading files from the directory: " + path);
    	readDirectory(path);
    	
	}
	
	/**
	 * Counts how many files and how many lines each file contains and prints it out.
	 * 
	 * @param path	the path of the directory
	 */
	private static void readDirectory(String path) {
			
		// Create and initialize a File.
	    File f = new File(path);
	    
	    // List files in the choose directory.
	    File[] files = f.listFiles();

	    // If no files were found.
	    if (files != null) {
	    	
	    	// Loop through the FileArray.
		    for (int i = 0; i < files.length; i++) {
		    	
		        File file = files[i];
		        String name = file.getName();
		        
		        // On each file that ends with .java.
		        if (name.endsWith(".java")) {
		        	
		        	count++;			        
		        	
		        	// Count how many lines the file contains and print it out with the id (count).
		        	try {
		        		int countLines = 0;
		    		    Scanner sc = new Scanner(file);
		    		    while (sc.hasNextLine()) {
		    		        countLines++;
		    		        sc.nextLine();
		    		    }
			        	System.out.println(count + ". " + name + "   lines = " + countLines);
		        	} catch (IOException e) {
		    		    System.out.println(e.getMessage());
		        	}
		        }
		        
		        // If a sub-directory was found, read its files. Basically everything all over again.
		        if (file.isDirectory()) {   
		        	readDirectory(file.getAbsolutePath()); 
		        }
		    }
	    } else {
	    	System.out.println("No directory or files were found in " + path);
	    }
	}
}