package exercise5;

import java.util.Iterator;
import java.util.NoSuchElementException;


/** 
 * This class works like a TreeSet of Word-objects.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 25, 2015.
 */
public class TreeWordSet implements WordSet{
	
	private BST root = null;
	private int size = 0;

	/**
	 * Adds word if not already added.
	 * 
	 * @param word
	 */
	@Override
	public void add(Word word) {
		if (!contains(word)) {
			if (root == null) {
				root = new BST(root, word);
			} else {
				root.add(word);		
			}
			size++;
		}
	}

	/**
	 * Checks if Word already exists.
	 * 
	 * @return if found
	 */
	@Override
	public boolean contains(Word word) {
		if (root == null) {
			return false;
		} else {
			return root.contains(word);		
		}
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
		
		BST next;
		
		public SetIterator() {
			next = root;
			
			// If no elements.
			if(next == null) {
				return;
			}
			
			// Go to the most left Node.
			while (next.left != null) {
				next = next.left;
			}
		}

		public boolean hasNext() {		
			return next != null;
		}
		
		public Word next() {			

			if(!hasNext()) { throw new NoSuchElementException(); };
			     
		   	BST r = next;
			     
		   	// If we can go right, go right.
		   	if(next.right != null){
		    	 
		       next = next.right;
		       
		       // Then again go the most left.
		       while (next.left != null) {
		    	   next = next.left;
		       }
		       return r.word;
		       
		     // Else go up one level until you can go left again.
		     } else while (true) {
		    	 
		    	 // If reaching root.
		    	 if(next.parent == null){
		    		 next = null;
		    		 return r.word;
	    		 }
		    	 
		    	 // If next parents left is next.
		    	 if(next.parent.left == next){
			         next = next.parent;
			         return r.word;
		    	 }
		    	 next = next.parent;
		     }	   
		}
		
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}
	
	/**
	 * This class works like an Binary Search Tree.
	 */
	private class BST {
		
		Word word;
		BST left = null;
		BST right = null;
		BST parent = null;

		/**
		 * Constructor.
		 * 
		 * @param word
		 */
		public BST(BST parent, Word word) {
			this.word = word;
			this.parent = parent;
		}

		/**
		 * Adds a new word to the tree.
		 * Where to put the word is decided by the (Right/Left-branch-algorithm).
		 * 
		 * @param word
		 */
		private void add(Word word) {

			// If we should go Left. (Lower than current branch value)
			if (word.compareTo(this.word) < 0) {
				if (left == null) {
					left = new BST(this, word);
				} else {
					left.add(word);
				}
			}
			
			// If we should go Right. (Higher than current branch value)
			else if (word.compareTo(this.word) > 0) {
				if (right == null) {
					right = new BST(this, word);
				} else {
					right.add(word);
				}
			}			
		}
		
		/**
		 * Checks if a word already exists in the tree.
		 * Search through the branch where the searched word should be stored.
		 * 
		 * @param word
		 */
		private boolean contains(Word word) {
			
			// If we should go Left. (Lower than current branch value)
			if (word.compareTo(this.word) < 0) {
				if (left == null) {
					return false;
				} else {
					return left.contains(word);
				}
			}
			
			// If we should go Right. (Higher than current branch value)
			else if (word.compareTo(this.word) > 0) {
				if (right == null) {
					return false;
				} else {
					return right.contains(word);
				}
			}
			return true;
		}
	}
}