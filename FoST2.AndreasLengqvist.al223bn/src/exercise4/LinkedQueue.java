package exercise4;

import java.util.Iterator;

/** 
 * This class handles a Queue with the head and tail implementation.
 * Taken from (Queue.java) in FoST1.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 16:14, September 13, 2015.
 */
public class LinkedQueue<E> implements Queue<E> {

	private int size = 0; 					// Current size.
	private Node head = null;				// Head node/element.
	private Node tail = null;				// Tail node/element.

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E element) {
    	Node temp = new Node(element);

    	// Lazy dequeuing.
        if (head == null) {
        	head = temp;
        	tail = temp;
        } else {
        	tail.setNext(temp);
        	tail = tail.getNext();
        }
        
        // Increment the size of the list.
        size++;
	}

	@Override
	public E dequeue() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("No objects in the list!");
		}
		
		Node nodeToRemove = head;

		// "Dequeue" by rewrite the first Node with the next.
		head = head.getNext();
		
        // Decrement the size of the list.
		size--;
		
		// Return the removed Node.
		return nodeToRemove.getValue();
	}

	@Override
	public E first() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("No objects in the list!");
		}
		return head.getValue();
	}

	@Override
	public E last() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("No objects in the list!");
		}
		return tail.getValue();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			private Node current = head;

			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				E value = current.getValue();
				current = current.getNext();
				return value;
			}
		};
	}

	private class Node {
		private Node next = null;
		private E value;
		
		Node(E value) { 
			this.value = value;
		}

		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public E getValue() {
			return this.value;
		}
	}
}