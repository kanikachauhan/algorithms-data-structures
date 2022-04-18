package com.algorithms.que;

import java.util.Stack;

public class QueueOperationsOne {

	public static void reverse(ArrayQueue<Integer> queue) {
		Stack<Integer> stack = new Stack<Integer>();
		while(!queue.isEmpty()) {
			stack.push(queue.dequeue());
		}
		while(!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
	}
	
	public static ArrayQueue<Integer> reverseRecursion(ArrayQueue<Integer> queue) {
		if(queue.isEmpty())
			return queue;
		int data = queue.dequeue();
		reverseRecursion(queue);
		queue.enqueue(data);
		return queue;
	}
}
