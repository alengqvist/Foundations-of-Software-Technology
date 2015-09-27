package exercise5;

import java.util.Iterator;


/** 
 * This class works like a HashSet of Word-objects.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 25, 2015.
 */
public class HashWordSet implements WordSet {

	private int size;
	private Node[] buckets = new Node[8]; 
	
	/**
	 * Get Bucket Number.
	 * 
	 * @param word
	 */
	private int getBucketNumber(Word word) {
		int hc = word.hashCode();
		if (hc < 0) {
			hc = -hc;
		}
		return hc % buckets.length;	
	}
	
	/**
	 * Rehash the bucket.
	 */
	private void rehash() {
		Node[] temp = buckets;  // Copy of old buckets
		buckets = new Node[2*temp.length];  // New empty buckets
		size = 0;
		for (Node n : temp) {   // Insert old values into new buckets
			if (n == null) {
				continue;
			}
			while (n != null) {
				add(n.value);
				n = n.next;
			}
		}
	}

	/**
	 * Adds word if not already added.
	 * 
	 * @param word
	 */
	@Override
	public void add(Word word) {
		
		// Check if already added.
		if (!contains(word)) {
			
			// Get Bucket Number.
			int pos = getBucketNumber(word);
			
			// Create Node for new Word.
			Node node = new Node(word);
			
			// Set the Words next.
			node.setNext(buckets[pos]);
			
			// Push the new Word into the bucket position.
			buckets[pos] = node;
			
			// Increment the size.
			size++;
			
			// If needed to rehash.
			if (size == buckets.length) {
				rehash();
			}
		}
	}

	/**
	 * Checks if Word already exists.
	 * 
	 * @return if found
	 */
	@Override
	public boolean contains(Word word) {
		
		// Get Bucket Number.
		int pos = getBucketNumber(word);
		
		// Create Node from position in the bucket.
		Node node = buckets[pos];
		
		// Until all Nodes have been checked.
		while (node != null) {
			
			// If Word is found.
			if (node.value.equals(word)) {
				return true;
				
			// Else getNext.
			} else {
				node = node.getNext();
			}
		}
		return false;
	}

	/**
	 * Returns the size.
	 * 
	 * @return size
	 */
	@Override
	public int size() {
		return this.size;
	}
	
	/**
	 * Returns a pretty string of the WordHashSet content.
	 * 
	 * @return pretty string
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		@SuppressWarnings("rawtypes")
		Iterator it = iterator();
		
		while (it.hasNext()) {
			sb.append(it.next().toString() + " ");
		}
		return sb.toString();
	}
	
	/**
	 * Returns a new SetIterator.
	 * 
	 * @return SetIterator
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iterator() {
		return new SetIterator();
	}
	
	/**
	 * Class handles a SetIterator.
	 */
	@SuppressWarnings("rawtypes")
	private class SetIterator implements Iterator {
		
		int pos = 0;
		Word[] words;
		
		public SetIterator() {

			words = new Word[size];
			int n = 0;
			
			for (int i = 0; i < buckets.length; i++) {
				
				Node node = buckets[i];
				
				while (node != null) {
					words[n++] = node.getValue();
					node = node.getNext();
				}
			}
		}

		public boolean hasNext() {			
			return pos < words.length;
		}
		
		public Word next() {
			return words[pos++];
		}
		
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}
	
	/**
	 * Taken from my Queue.java exercise.
	 */
	private class Node {
		private Node next = null;
		private Word value;
		
		Node(Word value) { 
			this.value = value;
		}

		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Word getValue() {
			return this.value;
		}
	}
}