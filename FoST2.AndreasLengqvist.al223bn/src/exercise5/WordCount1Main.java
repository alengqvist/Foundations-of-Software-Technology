package exercise5;


/** 
 * This class reads from a given file (not as in-parameter) and adds the content
 * to a HashSet and a TreeSet.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 25, 2015.
 */
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WordCount1Main {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {

        // Read from file and get HashSet.
		Set<Word> hashSet = Reader.readToSet(new HashSet<Word>(), "word.txt");
		
		// Gives the size of the HashSet.
		System.out.println(hashSet.size());
		
        // Read from file and get TreeSet.
		Set<Word> treeSet = Reader.readToSet(new TreeSet<Word>(), "word.txt");

		// Print out the content of the TreeSet.
		for (Word w : treeSet) {
			System.out.println(w.toString());
		}
	}
}