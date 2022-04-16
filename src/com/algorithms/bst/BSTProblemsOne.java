package com.algorithms.bst;

public class BSTProblemsOne<T> {

	private BSTNode<Integer> root;
	
	private int minimum(BSTNode<Integer> node) {
		BSTNode<Integer> current = node;
		while(current.left!=null) {
			current = current.left;
		}
		return current.data;
	}
	
	private boolean isPresent(BSTNode<Integer> node,int key) {
		if(node==null)
			return false;
		if(node.data==key)
			return true;
		if(node.data>key)
			return isPresent(node.right, key);
		return isPresent(node.left, key);
	}
	
	private void insert(int key) {
		this.root = insert(root, key);
	}
	
	private BSTNode<Integer> insert(BSTNode<Integer> node, int key) {
		if(node==null) {
			node = new BSTNode<Integer>(key);
			return node;
		}else if(node.data>key) {
			node.left = insert(node.left,key);
		}else if(node.data<key){
			node.right = insert(node.right, key);
		}
		return node;
	}
	
	private void inOrder(BSTNode<Integer> node) {
		if(node==null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	static int count = 0;
	private BSTNode<Integer> kthSmallest(BSTNode<Integer> node,int k) {
		if(node==null) {
			return null;
		}
		
		BSTNode<Integer> nleft =  kthSmallest(node.left, k);
		if(nleft!=null)
			return nleft;
		count++;
		System.out.println(count);
		if(count==k) {
			return node;
		}
		return kthSmallest(node.right, k);
	}
	
	public static void main(String[] args) {
		BSTProblemsOne<Integer> bstProblemsOne = new BSTProblemsOne<>();
		bstProblemsOne.insert(50);
		bstProblemsOne.insert(30);
		bstProblemsOne.insert(20);
		bstProblemsOne.insert(40);
		bstProblemsOne.insert(70);
		bstProblemsOne.insert(60);
		bstProblemsOne.insert(80);
		bstProblemsOne.inOrder(bstProblemsOne.root);
		System.out.println();
		System.out.println(bstProblemsOne.minimum(bstProblemsOne.root)+" "+bstProblemsOne.isPresent(bstProblemsOne.root, 40));
		System.out.println(bstProblemsOne.kthSmallest(bstProblemsOne.root, 3).data);
	}
}
