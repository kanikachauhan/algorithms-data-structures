package com.algorithms.bt;

public class BTreeProblemsTwo<T> {

	private BTNode<Integer> root;
	
	private static boolean isMirror(BTNode<Integer> node1, BTNode<Integer> node2) {
		if(node1==null && node2==null) {
			return true;
		}
		if(node1==null || node2==null) {
			return false;
		}
		
		return node1.data==node2.data && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
	}
	
	private void printPaths(BTNode<Integer> root) {
		int arr[] = new int[1000];
		paths(root, arr, 0);
	}
	
	private void paths(BTNode<Integer> node, int arr[],int len) {
		if(node==null)
			return;
		arr[len++] = node.data;
		if(node.left==null && node.right==null) {
			for(int i=0;i<len;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}else {
			paths(node.left, arr, len);
			paths(node.right, arr, len);
		}
	}
	
	private int fmax(BTNode<Integer> node) {
		if(node==null) {
			return Integer.MIN_VALUE;
		}
		int res = node.data;
		int lres = fmax(node.left);
		int rres = fmax(node.right);
		if(lres>res) {
			res = lres;
		}
		if(rres>res) {
			res = rres;
		}
		return res;
	}
	
	public static void main(String[] args) {
		BTreeProblemsTwo<Integer> bt1 = new BTreeProblemsTwo<Integer>();
		bt1.root = new BTNode<Integer>(1);
		bt1.root.left = new BTNode<Integer>(2);
		bt1.root.right = new BTNode<Integer>(3);
		bt1.root.left.left = new BTNode<Integer>(4);
		bt1.root.left.right = new BTNode<Integer>(5);
		
		BTreeProblemsTwo<Integer> bt2 = new BTreeProblemsTwo<Integer>();
		bt2.root = new BTNode<Integer>(1);
		bt2.root.right = new BTNode<Integer>(2);
		bt2.root.left = new BTNode<Integer>(3);
		bt2.root.right.left = new BTNode<Integer>(5);
		bt2.root.right.right = new BTNode<Integer>(4);
		
		System.out.println(isMirror(bt1.root, bt2.root));
		bt1.printPaths(bt1.root);
		System.out.println(bt1.fmax(bt1.root));
	}
}
