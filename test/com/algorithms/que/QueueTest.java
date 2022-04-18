package com.algorithms.que;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {

	ArrayQueue<Integer> arrayQueue,queue;
	
	@BeforeEach
	public void setUp() {
		arrayQueue = new ArrayQueue<Integer>(10);
		queue = new ArrayQueue<Integer>(10);
	}
	
	@Test
	public void testOperations() {
		arrayQueue.enqueue(1); arrayQueue.enqueue(2); arrayQueue.enqueue(3); arrayQueue.enqueue(3); arrayQueue.enqueue(4); arrayQueue.enqueue(5);
		assertTrue("Difference in expected value",arrayQueue.dequeue()==1);
		assertTrue("Difference in expected value",arrayQueue.dequeue()==2);
		assertTrue("Difference in expected value",!arrayQueue.isEmpty());
	}
	
	@Test
	public void testReverseOperations() {
		queue.enqueue(1); queue.enqueue(2); queue.enqueue(3); queue.enqueue(4); queue.enqueue(5); queue.enqueue(6); queue.enqueue(7);
		QueueOperationsOne.reverse(queue);
		assertTrue("Difference in expected value",queue.dequeue()==7);
		assertTrue("Difference in expected value",queue.dequeue()==6);
		assertTrue("Difference in expected value",queue.dequeue()==5);
		assertTrue("Difference in expected value",queue.dequeue()==4);
	}
	
	@Test
	public void testReverseOperationsRecursions() {
		queue.enqueue(1); queue.enqueue(2); queue.enqueue(3); queue.enqueue(4); queue.enqueue(5); queue.enqueue(6); queue.enqueue(7);
		QueueOperationsOne.reverseRecursion(queue);
		assertTrue("Difference in expected value",queue.dequeue()==7);
		assertTrue("Difference in expected value",queue.dequeue()==6);
		assertTrue("Difference in expected value",queue.dequeue()==5);
		assertTrue("Difference in expected value",queue.dequeue()==4);
	}
}
