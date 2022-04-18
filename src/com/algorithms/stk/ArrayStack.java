package com.algorithms.stk;

public class ArrayStack<T> {
	
	private static final int MAX = 1000;
	
	private Object arr[];
	
	private int top;
	
	public ArrayStack() {
		arr = new Object[MAX];
		top = -1;
	}
	
	/**
	 * check empty stack
	 * @return
	 */
	public boolean isEmpty() {
		return top<0;
	}
	
	/**
	 * push new data
	 * @param data
	 */
	public void push(T data) {
		if(top!=(MAX-1)) {
			arr[++top] = data;
		}else {
			System.out.println("Stack overflow!!");
		}
	}
	
	/**
	 * removing top element from stack
	 * @return
	 */
	public T pop() {
		if(top<0) {
			System.out.println("Stack underflow!!");
			return null;
		}
		return (T) arr[top--];
	}
	
	/**
	 * getting top element from stack
	 * @return
	 */
	public T peek() {
		if(top<0) {
			System.out.println("Stack underflow!!");
			return null;
		}
		return (T) arr[top];
	}
}
