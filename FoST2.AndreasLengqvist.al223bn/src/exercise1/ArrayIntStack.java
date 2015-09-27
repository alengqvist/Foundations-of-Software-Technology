package exercise1;


public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
	@Override
	/**
	 * Adds integer at top of stack.
	 * 
	 * @param n
	 */
	public void push(int n) {
		
		// If the size of the array is full.
		if (size == values.length) {
			resize();
		}
		values[size++] = n;
	}

	@Override
	/**
	 * Returns and removes integer at top of stack.
	 * 
	 * @return n
	 */
	public int pop() throws IndexOutOfBoundsException {
		if (size > 0) {
			return values[--size];
		} else {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Couldn't pop top element. Stack is empty!");
		}
	}

	@Override
	/**
	 * Returns without removing integer at top of stack.
	 * 
	 * @return n
	 */
	public int peek() throws IndexOutOfBoundsException {
		if (size > 0) {
			return values[size - 1];
		} else {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Couldn't peek top element. Stack is empty!");
		}
	}
}