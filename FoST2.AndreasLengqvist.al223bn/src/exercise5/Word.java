package exercise5;

/** 
 * This class handles a Word.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 25, 2015.
 */
public class Word implements Comparable<Word> {
	
	private String word;
	
	/**
	 * Constructor.
	 * 
	 * @param str
	 */
	public Word(String word) {
		this.word = word;
	}
	
	/**
	 * Returns a pretty string of the Word content.
	 * 
	 * @return word
	 */
	@Override
	public String toString() { 
		return word; 
	}
	
	/**
	 * Computes a hash value for word.
	 */
	@Override
	public int hashCode() {
		int hc = 0;
		for (char c : word.toCharArray()) {
			hc += Character.getNumericValue(c);
		}
		return hc;
	}
	
	/**
	 * Compares if two Word objects are equal to each other.
	 * 
	 * @return if equals
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Word) {
			Word otherWord = (Word) other;
			return word.equals(otherWord.word);
		}
		return false;
	}
	
	/**
	 * Compares two words lexicographically.
	 * 
	 * @return value
	 */
	@Override
	public int compareTo(Word w) {
		return word.compareToIgnoreCase(w.word);
	}
}