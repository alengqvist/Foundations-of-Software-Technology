package exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;


/** 
 * This class works like Reader (and printer).
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 25, 2015.
 */
public class Reader {
	
	/**
	 * Reads from a file and prints to another.
	 * 
	 * @param readFromFileName
	 * @param writeFromFileName
	 */
	public static void readAndPrint(String readFromFileName, String writeFromFileName) {
		try {
			
	    	// Create and initialize Scanner and put the File in it.
			Scanner sc = new Scanner(new File(readFromFileName));
			
			// Create a new file.
			PrintWriter writer = new PrintWriter(writeFromFileName);

			// As long as there is a new line to read in the file.
	    	// Read and write next the line.
		    while(sc.hasNextLine()){

				// 1. replaceAll -> Translate hyphen words into two words. 
		    	// 2. replaceAll -> And keep only words with A-Z.
				// 3. Print line to file.
				writer.print(sc.nextLine().replaceAll("[\\-]", " ").replaceAll("[']*[^a-zA-Z\\s]", "") + "\n");
		    }
		    sc.close();
			writer.close();
		} catch (FileNotFoundException e) { e.printStackTrace(); } 
	}
	
	/**
	 * Reads from a file and adds the content to a Set.
	 * 
	 * @param readFromFileName
	 * @return set
	 */
	public static Set<Word> readToSet(Set<Word> set, String readFromFileName) {
		try {
			
	    	// Create and initialize Scanner and put the File in it.
			Scanner sc = new Scanner(new File(readFromFileName));
			
	        // As long as there is a line to read in the file. Read next word.
		    while(sc.hasNextLine()){
		    	for (String s : sc.nextLine().split("[\\s+]")) {
		    		if (!s.isEmpty()) {
		    			
			    		// Transform into lower case and add to the Set.
			        	set.add(new Word(s.toLowerCase()));	
		    		}
		    	}
		    }
		    sc.close();
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		return set;
	}
	
	/**
	 * Reads from a file and adds the content to a WordSet.
	 * 
	 * @param readFromFileName
	 * @return set
	 */
	public static WordSet readToWordSet(WordSet set, String readFromFileName) {
		try {
			
	    	// Create and initialize Scanner and put the File in it.
			Scanner sc = new Scanner(new File(readFromFileName));
			
	        // As long as there is a line to read in the file. Read next word.
		    while(sc.hasNextLine()){
		    	for (String s : sc.nextLine().split("[\\s+]")) {
		    		if (!s.isEmpty()) {
		    			
			    		// Transform into lower case and add to the Set.
			        	set.add(new Word(s.toLowerCase()));	
		    		}
		    	}
		    }
		    sc.close();
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		return set;
	}
}