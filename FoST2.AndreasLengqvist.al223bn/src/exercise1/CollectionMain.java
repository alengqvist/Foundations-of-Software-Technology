package exercise1;


/** 
 * This class tests the Collection-classes ArrayIntList and ArrayIntStack.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 14:26, September 17, 2015.
 */
public class CollectionMain {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
		// Create ArrayIntList.
		ArrayIntList ail = new ArrayIntList();

			// Add 6 Integers to the list.
			ail.add(1);
			ail.add(2);
			ail.add(3);
			ail.add(4);
			ail.add(5);
			ail.add(6);
			
			// Try to addAt index 15.
			try { 
				ail.addAt(7, 15); 
				System.out.println("Added 7 at index 15.");
			} catch (IndexOutOfBoundsException e) { 
				System.out.println(e.getMessage());
			}
			
			// Add another 2 Integers.
			ail.add(9);
			ail.add(10);
			
			// Try to addAt index 7.
			try { 
				ail.addAt(8, 7);
				System.out.println("Added 8 at index 7.");
			} catch (IndexOutOfBoundsException e) { 
				System.out.println(e.getMessage());
			}

		// Write out the list.
		System.out.println(ail.toString());

		// Get element at EXISTING index.
		try {
			System.out.println("Get element at index: 5 -> " + ail.get(5));
		} catch (IndexOutOfBoundsException e) { 
			System.out.println(e.getMessage());
		}
		
		// Get element at NOT EXISTING index.
		try {
			System.out.println("Get element at index: 8 -> " + ail.get(9));
		} catch (IndexOutOfBoundsException e) { 
			System.out.println(e.getMessage()); 
		}
		
		// Get indexOf EXISTING element.
		System.out.println("Get indexOf element: 10 -> " + ail.indexOf(10));

		// Get indexOf NOT EXISTING element.
		System.out.println("Get indexOf element: 20 -> " + ail.indexOf(25));
		
		// Remove element at EXISTING index.
		try {
			ail.remove(0);
			System.out.println("After removed index 0: " + ail.toString());
		} catch (IndexOutOfBoundsException e) { 
			System.out.println(e.getMessage()); 
		}
		
		// Remove element at NOT EXISTING index.
		try {
			ail.remove(8);
			System.out.println("After removed index 8: " + ail.toString());
		} catch (IndexOutOfBoundsException e) { 
			System.out.println(e.getMessage()); 
		}
		
		// Create ArrayIntStack.
		ArrayIntStack ais = new ArrayIntStack();
		
		// Try to pop top element in empty stack.
		try {
			System.out.println(ais.pop());
		} catch (IndexOutOfBoundsException e) { 
			System.out.println("IndexOutOfBoundsException: Couldn't pop top element. Stack is empty!"); 
		}
		
		// Try to peek top element in empty stack.
		try {
			System.out.println(ais.peek());
			System.out.println(ais.toString());
		} catch (IndexOutOfBoundsException e) { 
			System.out.println(e.getMessage()); 
		}

		// Push 9 Integers to the stack.
		ais.push(1);
		ais.push(2);
		ais.push(3);
		ais.push(4);
		ais.push(5);
		ais.push(6);
		ais.push(7);
		ais.push(8);
		ais.push(9);
		
		// Write out the stack.
		System.out.println(ais.toString());
		
		// Pop top element.
		try {
			System.out.println(ais.pop());
			System.out.println(ais.toString());
		} catch (IndexOutOfBoundsException e) { 
			System.out.println(e.getMessage()); 
		}
		
		// Peek top element.
		try {
			System.out.println(ais.peek());
			System.out.println(ais.toString());
		} catch (IndexOutOfBoundsException e) { 
			System.out.println("ERROR: Couldn't peek top element. Stack is empty!"); 
		}
		
		// Push another 3 Integers to the stack.
		ais.push(10);
		ais.push(11);
		ais.push(12);
		
		// Write out the stack.
		System.out.println(ais.toString());
		
		System.out.println(ais.peek());
		System.out.println(ais.toString());	
	}
}