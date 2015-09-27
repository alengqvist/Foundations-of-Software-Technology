package exercise5;


/** 
 * This class reads from a given file (as in-parameter) and prints to another
 * from a specific pattern. (See Reader.java)
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 25, 2015.
 */
public class IdentyfyWordsMain {

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
        } else {
            System.out.println("IdentyfyWordsMain needs a filename to run!");
            System.exit(1);
        }
        
        // Write to a new file by reading from another.
		Reader.readAndPrint(fileName, "word.txt");
	}
}