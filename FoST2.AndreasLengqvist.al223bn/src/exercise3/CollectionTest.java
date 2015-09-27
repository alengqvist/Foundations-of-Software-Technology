package exercise3;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.TestName;

import exercise1.ArrayIntList;
import exercise1.ArrayIntStack;
import exercise1.IntList;
import exercise1.IntStack;


public class CollectionTest {
    @Rule public TestName name = new TestName();
    private static int test_count = 0;

	/**
	 * Is executed before every test method (not test case).
	 */
	@Before
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count + ": " + name.getMethodName());
	}
	
	/**
	 * Is executed after every test method (not test case).
	 */
	@After
	public void tearDown() {}
	
	@Test
	public void testInitSize() {
		IntList list = new ArrayIntList();
		assertEquals(0, list.size());
	}
	
	/**
	 * Tests the add, size and get methods.
	 */
	@Test
	public void testAddGet() {
		
		// Test add(int n) using build(5).
		IntList list1 = buildList(5);
		assertEquals(5, list1.size());
		
		// Test add(int n) using build(10) to test resize().
		IntList list2 = buildList(10);
		assertEquals(10, list2.size());
		
		// Test get(int n) on list2(10).
		for (int i = 0; i < list2.size(); i++) {
			assertEquals(i, list2.get(i));
		}
		
		// Test if get(int index) throws exception on too low index.
		boolean res1 = false;
		try {
			list1.get(-1);
		} catch(IndexOutOfBoundsException e) { res1 = true; }
		assertTrue(res1);

		// Test if get(int index) throws exception on too high index.
		boolean res2 = false;
		try {
			list1.get(5);
		} catch(IndexOutOfBoundsException e) { res2 = true; }
		assertTrue(res2);
	}
	
	/**
	 * Tests the addAt and also again the add, size and get methods.
	 */
	@Test
	public void testAddAtGet() {
		
		// Setup list(5).
		IntList list = buildList(5);		// [0, 1, 2, 3, 4]
		assertEquals(5, list.size());
		
		// Test addAt(int n, int index) interior.
		list.addAt(6, 3);					// [0, 1, 2, 6, 3, 4]
		list.addAt(7, 3);					// [0, 1, 2, 7, 6, 3, 4]
		assertEquals(7, list.size());

		// Test get(int n).
		assertEquals(0, list.get(0));
		assertEquals(1, list.get(1));
		assertEquals(2, list.get(2));
		assertEquals(7, list.get(3));
		assertEquals(6, list.get(4));
		assertEquals(3, list.get(5));
		assertEquals(4, list.get(6));
		
		// Test addAt(int n, int index) in the end of the array.
		list.addAt(8, 6);					// [0, 1, 2, 7, 6, 3, 8, 4]
		assertEquals(8, list.size());

		// Test get(int n).
		assertEquals(8, list.get(6));
		assertEquals(4, list.get(7));
		
		// Test addAt(int n, int index) in the start of the array (also tests the resize()).
		list.addAt(9, 0);					// [9, 0, 1, 2, 7, 6, 3, 8, 4]
		assertEquals(9, list.size());
		
		// Test get(int n).
		assertEquals(9, list.get(0));
		assertEquals(0, list.get(1));
		assertEquals(1, list.get(2));
		assertEquals(2, list.get(3));
		assertEquals(7, list.get(4));
		assertEquals(6, list.get(5));
		assertEquals(3, list.get(6));
		assertEquals(8, list.get(7));
		assertEquals(4, list.get(8));
		
		// Test if addAt(int n, int index) throws exception on too low index.
		boolean res1 = false;
		try {
			list.addAt(7, -1);
		} catch(IndexOutOfBoundsException e) { res1 = true; }
		assertTrue(res1);
		
		// Test if addAt(int n, int index) throws exception on too high index.
		boolean res2 = false;
		try {
			list.addAt(7, 10);
		} catch(IndexOutOfBoundsException e) { res2 = true; }
		assertTrue(res2);
	}
	
	/**
	 * Tests the indexOf method.
	 */
	@Test
	public void testIndexOf() {
		
		// Test indexOf(int n) using build(100).	
		IntList list = buildList(100);
		for (int i = 0; i < list.size(); i++) {
			assertEquals(i, list.indexOf(i));
		}
	}
	
	@Test
	public void testRemove() {
		
		// Test extreme cases.
		IntList list = buildList(10);
		list.remove(9);  				// [0, 1, 2, 3, 4, 5, 6, 7, 8]
		list.remove(0);  				// [1, 2, 3, 4, 5, 6, 7, 8 ]
		assertEquals(8,list.size());
		
		// Test to remove in the middle.
		list.remove(3);  // [1, 2, 3, 5, 6, 7, 8]
		list.remove(3);  // [1, 2, 3, 6, 7, 8]
		assertEquals(6, list.size());
		
		// Check each remaining element.
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(6, list.get(3));
		assertEquals(7, list.get(4));
		assertEquals(8, list.get(5));
				
		// Test if remove(int index) throws exception on too low index.
		boolean res1 = false;
		try {
			list.remove(-1);
		} catch(IndexOutOfBoundsException e) { res1 = true; }
		assertTrue(res1);

		// Test if remove(int index) throws exception on too high index.
		boolean res2 = false;
		try {
			list.remove(6);
		} catch(IndexOutOfBoundsException e) { res2 = true; }
		assertTrue(res2);
	}
	
	/**
	 * Tests the push, size and peek methods.
	 */
	@Test
	public void testPushPeek() {
		
		// Test push(int n) using buildStack().
		IntStack stack1 = buildStack(5);
		assertEquals(5, stack1.size());
		
		// Test push(int n) using buildStack() to test resize().
		IntStack stack2 = buildStack(10);
		assertEquals(10, stack2.size());
		
		// Test peek().
		assertEquals(9, stack2.peek());
		
		// Test if peek() throws exception on empty stack.
		IntStack stack3 = new ArrayIntStack();
		assertEquals(0, stack3.size());
		boolean res1 = false;
		try {
			stack3.peek();
		} catch(IndexOutOfBoundsException e) { res1 = true; }
		assertTrue(res1);
	}
	
	/**
	 * Tests the pop and again the push and size methods.
	 */
	@Test
	public void testPushPop() {
		
		// Test push(int n) using buildStack().
		IntStack stack1 = buildStack(5);
		assertEquals(5, stack1.size());
		
		IntStack stack2 = buildStack(10);
		assertEquals(10, stack2.size());
		
		// Test pop().
		assertEquals(9, stack2.pop());
		
		// Test pop() until empty.
		assertEquals(8, stack2.pop());
		assertEquals(7, stack2.pop());
		assertEquals(6, stack2.pop());
		assertEquals(5, stack2.pop());
		assertEquals(4, stack2.pop());
		assertEquals(3, stack2.pop());
		assertEquals(2, stack2.pop());
		assertEquals(1, stack2.pop());
		assertEquals(0, stack2.pop());

		// Test if pop() throws exception on empty stack.
		assertEquals(0, stack2.size());
		boolean res1 = false;
		try {
			stack2.pop();
		} catch(IndexOutOfBoundsException e) { res1 = true; }
		assertTrue(res1);
	}
	
	/**
	 * Tests the isEmpty() of Stack and List method.
	 */
	@Test
	public void testListIsEmpty() {
		
		// Test isEmpty() in IntList on empty list.
		IntList list = new ArrayIntList();
		assertTrue(list.isEmpty());
		
		// Test isEmpty() in IntList on element removed.
		list.add(1);
		list.remove(0);
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Tests the isEmpty() of Stack and List method.
	 */
	@Test
	public void testStackIsEmpty() {
		
		// Test isEmpty() in IntStack on empty stack.
		IntStack stack = new ArrayIntStack();
		assertTrue(stack.isEmpty());
		
		// Test isEmpty() in IntStack on top element removed.
		stack.push(1);
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * Tests the toString() of Stack.
	 */
	@Test
	public void testStackToString() {
		
		// Test push(int n) using buildStack(10).
		IntStack stack = buildStack(10);
		assertEquals(10, stack.size());
		
		// Test isEmpty() in IntStack on top element removed.
		assertEquals("[ 0 1 2 3 4 5 6 7 8 9 ]", stack.toString());
	}
	
	/**
	 * Tests the toString() of List.
	 */
	@Test
	public void testListToString() {
		
		// Test add(int n) using buildList(10).
		IntList list = buildList(10);
		assertEquals(10, list.size());
		
		// Test isEmpty() in IntList on top element removed.
		assertEquals("[ 0 1 2 3 4 5 6 7 8 9 ]", list.toString());
	}
	
	/**
	 * Help method which creates a list of values.
	 * 
	 * @param size
	 * @return list
	 */
	private IntList buildList(int size) {
		IntList list = new ArrayIntList();
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		return list; 
	}
	
	/**
	 * Help method which creates a stack of values.
	 * 
	 * @param size
	 * @return stack
	 */
	private IntStack buildStack(int size) {
		IntStack stack = new ArrayIntStack();
		for (int i = 0; i < size; i++) {
			stack.push(i);
		}
		return stack; 
	}
}