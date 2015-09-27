package exercise5;

import java.util.Iterator;

/** 
 * This class reads from a given file (not as in-parameter) and adds the content
 * to a HashWordSet and a TreeWordSet.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 25, 2015.
 */
public class WordCount2Main {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
        // Read from file and get HashWordSet.
		WordSet hashWordSet = Reader.readToWordSet(new HashWordSet(), "word.txt");
		
		// Gives the size of the HashWordSet.
		System.out.println(hashWordSet.size());
		
        // Read from file and get TreeWordSet.
		WordSet treeWordSet = Reader.readToWordSet(new TreeWordSet(), "word.txt");
		
		// Print out the content of the TreeSet.
		@SuppressWarnings("rawtypes")
		Iterator it = treeWordSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}		
	}
}