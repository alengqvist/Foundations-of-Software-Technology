package exercise1;


public class ArrayIntList extends AbstractIntCollection implements IntList {

	/**
	 * Add integer n to the end of the list.
	 * 
	 * @param n
	 */
	@Override
	public void add(int n) {
		
		// If the size of the array is full.
		if (size == values.length) {
			resize();
		}
		values[size++] = n;
	}

	/**
	 * Inserts integer n at position index.
	 * 
	 * @param n
	 * @param index
	 */
	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size)) {
			throw new IndexOutOfBoundsException("\nIndexOutOfBoundsException: Couldn't addAt index: " + index);
		}
		
		// If the size of the array is full.
		if (size == values.length) {
			resize();
		}
		
		// Shifts the element currently at that position (if any) and any subsequent elements to the right.
		 for (int i = size; i > index; i--) {
			values[i] = values[i - 1];
		}
		values[index] = n;
		size++;	
	}

	/**
	 * Remove integer at position index.
	 * 
	 * @param index
	 */
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size)) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Couldn't remove index: " + index);
		}
		
		// Remove element by shifting the right side back.
		for (int i = index; i < size; i++) {
			values[i] = values[i + 1];
		}
		size--;
	}

	/**
	 * Get integer at position index.
	 * 
	 * @param index
	 * 
	 * @return n
	 */
	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size)) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Couldn't get index: " + index);
		}
		return values[index];
	}

	/**
	 * Find position of integer n, otherwise return -1.
	 * 
	 * @param n
	 * 
	 * @return index
	 */
	@Override
	public int indexOf(int n) {
		for (int i = 0; i < size; i++) {
			if (values[i] == n) {
				return i;
			}
		}
		return -1;
	}
}