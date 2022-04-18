package com.algorithms.que;

public class ArrayQueue<T> {

	
	private int front,rear,capacity;
	
	private int size = 0;
	
	private Object arr[];
	
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		this.front = 0;
		this.size = 0;
		this.rear = capacity-1;
		arr = new Object[capacity];
	}
	
	public boolean isFull() {
		return this.size==capacity;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public void enqueue(T data) {
		if(!isFull()) {
			this.rear = (this.rear+1) % this.capacity;
			this.arr[this.rear] = data;
			this.size = this.size+1;
		}else {
			return;
		}
	}

	public T dequeue() {
		T data = null;
		if(!isEmpty()) {
			data = (T) this.arr[this.front];
			this.front = (this.front+1) % this.capacity;
			this.size = this.size-1;
		}
		return data;
	}
	
	public T front() {
		return (T) this.arr[this.front];
	}
}
