package com.algorithms.bt;

public class BTNode<T> {

	T data;
	public BTNode<T> left, right;
	
	public BTNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
