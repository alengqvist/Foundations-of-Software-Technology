package exercise4;

import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;


public interface Queue<E> {

	    int size();                          			// Current queue size 
	    
	    boolean isEmpty();                   			// True if queue is empty
	    
	    void enqueue(E element);        				// Add element at end of queue
	    
	    E dequeue() throws IndexOutOfBoundsException;   // Return and remove first element.
	    
	    E first() throws IndexOutOfBoundsException;     // Return (without removing) first element
	    
	    E last() throws IndexOutOfBoundsException;      // Return (without removing) last element
	    
		Iterator<E> iterator();							// Element iterator
}