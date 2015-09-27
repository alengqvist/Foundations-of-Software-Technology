package exercise4;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.*;
import org.junit.rules.TestName;


public class QueueTest {
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
		Queue<Integer> queue = new LinkedQueue<>();
		assertEquals(0, queue.size());
	}
	
	/**
	 * Tests the isEmpty() method.
	 */
	@Test
	public void testIsEmpty() {
		
		// Test isEmpty() in IntList on empty list.
		Queue<Integer> queue = new LinkedQueue<Integer>();
		assertTrue(queue.isEmpty());
		
		// Test isEmpty() in Queue after dequeue removed.
		queue.enqueue(1);
		queue.dequeue();
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * Tests the enqueue, size and last methods.
	 */
	@Test
	public void testEnqueueAndLast() {
		
		// Test enqueue(int n) using build().
		Queue<Integer> queue1 = build(10);			// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		assertEquals(10, queue1.size());
		
		// Test last().
		assertEquals(9, (int)queue1.last());		// 1, 2, 3, 4, 5, 6, 7, 8, (9)
		
		// Test enqueue(int n) using build() and extreme case.
		Queue<Integer> queue2 = build(1000000);			// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		assertEquals(1000000, queue2.size());
		
		// Test last().
		assertEquals(999999, (int)queue2.last());		// ....... 999 998, (999 999)

		// Test if last() throws exception on empty queue.
		Queue<Integer> queue3 = new LinkedQueue<Integer>();
		boolean res1 = false;
		try {
			queue3.last();
		} catch(IndexOutOfBoundsException e) { res1 = true; }
		assertTrue(res1);
	}
	
	/**
	 * Tests the dequeue, size and first methods.
	 */
	@Test
	public void testDequeueAndFirst() {
		
		// Setup a queue.
		Queue<Integer> queue2 = build(10);			// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		assertEquals(10, queue2.size());
		
		// Test dequeue().
		assertEquals(0, (int)queue2.dequeue());		// 1, 2, 3, 4, 5, 6, 7, 8, 9
		
		// Test first().
		assertEquals(1, (int)queue2.first());		// (1), 2, 3, 4, 5, 6, 7, 8, 9

		// Test dequeue() until empty.
		assertEquals(1, (int)queue2.dequeue());		// (1), 2, 3, 4, 5, 6, 7, 8, 9
		assertEquals(2, (int)queue2.dequeue());		// (2), 3, 4, 5, 6, 7, 8, 9
		assertEquals(3, (int)queue2.dequeue());		// (3), 4, 5, 6, 7, 8, 9
		assertEquals(4, (int)queue2.dequeue());		// (4), 5, 6, 7, 8, 9
		assertEquals(5, (int)queue2.dequeue());		// (5), 6, 7, 8, 9
		assertEquals(6, (int)queue2.dequeue());		// (6), 7, 8, 9
		assertEquals(7, (int)queue2.dequeue());		// (7), 8, 9
		assertEquals(8, (int)queue2.dequeue());		// (8), 9
		assertEquals(9, (int)queue2.dequeue());		// (9)
		
		// Test if dequeue() throws exception when empty.
		boolean res1 = false;
		try {
			queue2.dequeue();
		} catch(IndexOutOfBoundsException e) { res1 = true; }
		assertTrue(res1);
		
		// Test if first() throws exception on empty queue.
		boolean res2 = false;
		try {
			queue2.first();
		} catch(IndexOutOfBoundsException e) { res2 = true; }
		assertTrue(res2);
	}
	
	/**
	 * Tests the iterator method.
	 */
	@Test
	public void testIterator() {
		
		// Test enqueue(int n) using build().
		Queue<Integer> queue = build(1000);			// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9.... 999
		assertEquals(1000, queue.size());
		
		// Test iterator().
		Iterator<Integer> it = queue.iterator();
		int count = 0;
		while (it.hasNext()) {
			assertEquals(count, (int)it.next());
			count++;
		}
	}
	
	/**
	 * Help method which creates a queue of values.
	 * 
	 * @param size
	 * @return list
	 */
	private Queue<Integer> build(int size) {
		Queue<Integer> queue = new LinkedQueue<Integer>();
		for (int i = 0; i < size; i++) {
			queue.enqueue(i);
		}
		return queue; 
	}
}