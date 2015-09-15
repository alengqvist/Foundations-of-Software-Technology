package queue;

import java.util.Iterator;

/** 
 * This class handles a Queue with the head and tail implementation.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 16:14, September 13, 2015.
 */
public class Queue implements QueueInterface, Iterable<Object>{

	private int size = 0; 					// Current size.
	private Node head = null;				// Head node/element.
	private Node tail = null;				// Tail node/element.
	
	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
		Queue queue = new Queue();
		
		try {

			System.out.println("Testing Queue.isEmpty() -> Is the list empty? - " + queue.isEmpty());

			queue.enqueue("Number 1");
			queue.enqueue("Number 2");
			queue.enqueue("Number 3");
			queue.enqueue("Number 4");
			
			System.out.println("Testing Queue.enqueue() and Queue.size() -> Size after enqueued three objects = " + queue.size());
			System.out.println("Testing Queue.dequeue() and Queue.size() -> Size after dequeued " + queue.dequeue() + " = " + queue.size());
			System.out.println("Testing Queue.first() -> The first object in the list is: " + queue.first());
			System.out.println("Testing Queue.last() -> The last object in the list is: " + queue.last());
			System.out.println("Testing Queue.contains() -> Does the object 'Number 2' " + "exist? - " + queue.contains("Number 2"));
			System.out.print("Testing Queue.iterator() -> The list contains the following objects: ");

			@SuppressWarnings("rawtypes")
			Iterator iterator = queue.iterator();
			
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(Object element) {
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
	public Object dequeue() throws IndexOutOfBoundsException {
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
	public Object first() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("No objects in the list!");
		}
		return head.getValue();
	}

	@Override
	public Object last() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("No objects in the list!");
		}
		return tail.getValue();
	}

	@Override
	public boolean contains(Object o) {
		Node current = head;
		
		// While current Node has a next Node.
		while (current.getNext() != null) {
			if (current.getValue() == o) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Iterator iterator() {
		return new Iterator() {
			
			private Node current = head;

			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Object next() {
				Object value = current.getValue();
				current = current.getNext();
				return value;
			}
		};
	}

	private class Node {
		private Node next = null;
		private Object value;
		
		Node(Object value) { 
			this.value = value;
		}

		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Object getValue() {
			return this.value;
		}
	}
}