package com.algorithms.bst;

public class BSTNode<T> {

	T data;
	public BSTNode<T> left, right;
	
	public BSTNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
