package com.datastructures.list;

/**
 * Node data structure to store data for a particular node in a list
 * @author kchauhan
 *
 * @param <T>
 */
class Node<T> {

	Node<T> next;
	T data;
	
	public Node(T data){
		this.data = data;
		this.next = null;
	}
}

/**
 * Single linked list implementation
 * @author kchauhan
 *
 * @param <T>
 */
public class SingleLinkedList<T extends Comparable<T>> {

	Node<T> head;
	
	/**
	 * adding to the end of list
	 * @param data
	 */
	public void append(T data) {
		if(head == null) {
			head = new Node<T>(data);
			return;
		}
		Node<T> temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = new Node<T>(data);	
	}

	/**
	 * searching an element
	 * @param data
	 * @return
	 */
	public  boolean search(T data) {
		if(head.data.compareTo(data)==0)
			return true;
		Node<T> temp =  (Node<T>) head;
		while(temp!=null) {
			if(temp.data.compareTo(data)==0) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	/**
	 * searching using recursion
	 * @param temp
	 * @param data
	 * @return
	 */
	public boolean searchRecur(Node<T> temp,T data) {
		if(temp==null)
			return false;
		if(temp.data.compareTo(data)==0)
			return true;
		return searchRecur(temp.next, data);
	}
	
	/**
	 * insert before a node in a list
	 * @param data
	 * @param beforeNode
	 */
	public void insertBefore(T data,Node<T> beforeNode) {
		Node<T> newNode = new Node<T>(data);
		if(beforeNode==head) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node<T> temp = head;
		while(temp.next!=beforeNode) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	/**
	 * insert after a node in a list
	 * @param data
	 * @param afterNode
	 */
	public void insertAfter(T data,Node<T> afterNode) {
		Node<T> newNode = new Node<T>(data);
		if(afterNode==head) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node<T> temp = head;
		while(temp!=afterNode) {
			temp = temp.next;
		}
		newNode.next = afterNode.next;
		afterNode.next = newNode;
	}
	
	/**
	 * index of an element in a list
	 * @param data
	 * @return
	 */
	public int indexOf(T data) {
		int ind = -1;
		Node<T> temp = head;
		while(temp!=null) {
			ind = ind+1;
			if(temp.data.compareTo(data)==0)
				return ind;
			temp = temp.next;
		}
		if(temp==null)
			return -1;
		return ind;
	}
	
	/**
	 * size of a list
	 * @return
	 */
	public int size() {
		if(head==null)
			return 0;
		int count = 0;
		Node<T> temp = head;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	/**
	 * recursive implementation to calculate size of a list
	 * @param node
	 * @param count
	 * @return
	 */
	public int sizeRecur(Node<T> node,int count) {
		if(node==null)
			return count;
		count = count+1;
		return sizeRecur(node.next, count);
	}
	
	/**
	 * get nthnode of a list
	 * @param index
	 * @return
	 */
	public Node<T> get(int index){
		if(index == -1)
			return null;
		int count  = 0;
		Node<T> temp = head;
		while(count!=index) {
			count = count+1;
			temp = temp.next;
		}
		return temp;
	}
	
	/**
	 * nth node from the end of the list
	 * @param n
	 * @return
	 */
	public Node<T> nthNodeEnd(int n){
		Node<T> first = head;
		Node<T> second = head;
		int count = 0;
		while(count!=n) {
			count = count+1;
			first = first.next;
		}
		while(first!=null) {
			second = second.next;
			first = first.next;
		}
		return second;
	}
	
	/**
	 * printing all elements of a list
	 */
	public void print() {
		Node<T> temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	
	
}
