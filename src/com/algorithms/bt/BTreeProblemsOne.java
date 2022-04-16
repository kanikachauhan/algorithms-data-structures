package com.algorithms.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTreeProblemsOne<T> {

	private BTNode<Integer> root;
	
	public BTreeProblemsOne(Integer data) {
		root = new BTNode<Integer>(data);
	}
	
	private void inOrder(BTNode<Integer> node) {
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	private void preOrder(BTNode<Integer> node) {
		if(node==null)
			return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private void postOrder(BTNode<Integer> node) {
		if(node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	private void inOrderWithoutRecursion(BTreeProblemsOne tree) {
		Stack<BTNode<Integer>> stack = new Stack<>();
		BTNode<Integer> current = tree.root;
		while(current!=null || !stack.isEmpty()) {
			while(current!=null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.data+" ");
			current = current.right;
		}
	}
	
	int c =0;
	private void nthNodeInorder(BTNode<Integer> node,int n) {
		if(node==null) {
			return;
		}
		if(c==n) {
			System.out.println(node.data);
		}
		c = c+1;
		nthNodeInorder(node.left, n);
		nthNodeInorder(node.right, n);
	}
	
	private void levelOrderTraversal(BTreeProblemsOne tree) {
		BTNode<Integer> current = tree.root;
		Queue<BTNode<Integer>> queue = new LinkedList<BTNode<Integer>>();
		queue.add(current);
		while(!queue.isEmpty()) {
			BTNode<Integer> node = queue.poll();
			System.out.print(node.data+" ");
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
		}
	}
	
	private int height(BTNode<Integer> node) {
		if(node==null)
			return 0;
		else {
			int ldepth = height(node.left);
			int rdepth = height(node.right);
			if(ldepth>rdepth) {
				return (ldepth+1);
			}else {
				return (rdepth+1);
			}
		}
	}
	
	private void reverse(BTNode<Integer> node) {
		int h = height(node);
		for(int i=h;i>=1;i--) {
			printGivenLevel(node, i);
		}
		System.out.println();
	}
	
	private void printGivenLevel(BTNode<Integer> node, int level) {
		if(node==null) return;
		if(level==1) {
			System.out.print(node.data+" ");
		}
		if(level>1) {
			printGivenLevel(node.left, level-1);
			printGivenLevel(node.right, level-1);
		}
	}
	
	private void printGivenLevelFlag(BTNode<Integer> node,int level,boolean flag) {
		if(node==null)
			return;
		if(level==1) {
			System.out.print(node.data+" ");
		}
		if(level>1) {
			if(flag) {
				printGivenLevelFlag(node.left, level-1, flag);
				printGivenLevelFlag(node.right, level-1, flag);
			}else {
				printGivenLevelFlag(node.right, level-1, flag);
				printGivenLevelFlag(node.left, level-1, flag);
			}
		}
	}
	
	private void printSpiralForm(BTNode<Integer> node) {
		int h = height(node);
		boolean flag = false;
		for(int i=1;i<=h;i++) {
			printGivenLevelFlag(node, i,flag);
			flag = !flag;
			System.out.println();
		}
	}
	
	
	private int iterativeHeight(BTNode<Integer> node) {
		Queue<BTNode<Integer>> queue = new LinkedList<BTNode<Integer>>();
		queue.add(node);
		int h = 0;
		while(!queue.isEmpty()) {
			int s = queue.size();
			for(int i=0;i<s;i++) {
				BTNode<Integer> qNode = queue.poll();
				if(qNode.left!=null) {
					queue.add(qNode.left);
				}
				if(qNode.right!=null) {
					queue.add(qNode.right);
				}
			}
			h++;
		}
		return h;
	}
	
	private int countLeafNodes(BTNode<Integer> node) {
		if(node==null) {
			return 0;
		}
		if(node!=null && node.left==null && node.right==null) {
			return 1;
		}
		return countLeafNodes(node.left) + countLeafNodes(node.right);
	}
	
	private int countNonLeafNodes(BTNode<Integer> node) {
		if(node==null) {
			return 0;
		}
		if(node!=null && (node.left==null && node.right==null)) {
			return 0;
		}
		return 1+countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
	}
	
	
	private int sumLeafNodes(BTNode<Integer> node) {
		if(node==null)
			return 0;
		if(node!=null && node.left==null && node.right==null)
			return node.data;
		return sumLeafNodes(node.left) + sumLeafNodes(node.right);
	}
	
	private int sumRightLeaves(BTNode<Integer> node) {
		if(node==null) {
			return 0;
		}
		if(node!=null && node.right!=null && node.right.left==null && node.right.right==null) {
			return node.right.data;
		}
		return sumRightLeaves(node.left) + sumRightLeaves(node.right);
	}
	
	private int sumLeftLeaves(BTNode<Integer> node) {
		if(node==null) {
			return 0;
		}
		if(node!=null && node.left!=null && node.left.left==null && node.left.right==null) {
			return node.left.data;
		}
		return sumLeftLeaves(node.left) + sumLeftLeaves(node.right);
	}
	
	private int sumAllNode(BTNode<Integer> node) {
		if(node==null) {
			return 0;
		}
		int temp = node.data;
		return  temp + sumAllNode(node.left) + sumAllNode(node.right);
	}
	
	private boolean isIdentical(BTNode<Integer> node1,BTNode<Integer> node2) {
		if(node1==null && node2==null)
			return true;
		if(node1.data!=node2.data)
			return false;
		return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
	}
	
	private boolean isIdenticalIterative(BTNode<Integer> node1, BTNode<Integer> node2) {
		if(node1==null && node2==null)
			return true;
		if(node1==null || node2==null)
			return false;
		Queue<BTNode<Integer>> q1 = new LinkedList<BTNode<Integer>>();
		q1.add(node1);
		Queue<BTNode<Integer>> q2 = new LinkedList<BTNode<Integer>>();
		q2.add(node2);
		while(!q1.isEmpty() && !q2.isEmpty()) {
			BTNode<Integer> n1 = q1.poll();
			BTNode<Integer> n2 = q2.poll();
			if(n1.data!=n2.data) {
				return false;
			}
			if(n1.left!=null && n2.left!=null) {
				q1.add(n1.left);
				q2.add(n2.left);
			}
			else if(n1.left!=null || n2.left!=null) {
				return false;
			}
			if(n1.right!=null && n2.right!=null) {
				q1.add(n1.right);
				q2.add(n2.right);
			}
			else if(n1.right!=null || n2.right!=null) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		BTreeProblemsOne tree = new BTreeProblemsOne(10);
		tree.root.left = new BTNode<Integer>(20);
		tree.root.left.left = new BTNode<Integer>(40);
		tree.root.left.right = new BTNode<Integer>(50);
		tree.root.right = new BTNode<Integer>(30);
		tree.root.right.left = new BTNode<Integer>(60);
		tree.root.right.right = new BTNode<Integer>(70);	
		tree.inOrder(tree.root);System.out.println();
		tree.preOrder(tree.root);System.out.println();
		tree.postOrder(tree.root);System.out.println();
		tree.inOrderWithoutRecursion(tree);System.out.println();
		tree.nthNodeInorder(tree.root, 4);
		tree.levelOrderTraversal(tree);
		System.out.println();
		System.out.println(tree.height(tree.root));
		System.out.println(tree.iterativeHeight(tree.root));
		tree.reverse(tree.root);
		tree.printSpiralForm(tree.root);
		System.out.println(tree.countLeafNodes(tree.root) +" " + tree.countNonLeafNodes(tree.root)+" "+tree.sumLeafNodes(tree.root)+" "+tree.sumRightLeaves(tree.root)+" "+tree.sumLeftLeaves(tree.root));
		System.out.println(tree.sumAllNode(tree.root));
		BTreeProblemsOne tree1 = new BTreeProblemsOne(10);
		tree1.root.left = new BTNode<Integer>(20);
		tree1.root.left.left = new BTNode<Integer>(40);
		tree1.root.left.right = new BTNode<Integer>(50);
		tree1.root.right = new BTNode<Integer>(30);
		tree1.root.right.left = new BTNode<Integer>(60);
		tree1.root.right.right = new BTNode<Integer>(70);
		System.out.println(tree.isIdentical(tree.root, tree1.root));
		System.out.println(tree.isIdenticalIterative(tree.root, tree1.root));
		
	}
}
