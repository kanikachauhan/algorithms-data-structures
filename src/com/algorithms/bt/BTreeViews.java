package com.algorithms.bt;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Obj{
	
	BTNode<Integer> node;
	int dis;
	
	Obj(BTNode<Integer> node,int dis){
		this.node = node;
		this.dis = dis;
	}

	public BTNode<Integer> getNode() {
		return node;
	}

	public int getDis() {
		return dis;
	}
	
	
}

public class BTreeViews<T> {

	BTNode<Integer> root;
	
	private static void leftView(BTNode<Integer> node) {
		Queue<BTNode<Integer>> queue = new LinkedList<BTNode<Integer>>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				BTNode<Integer> currentNode = queue.poll();
				if(i==0) {
					System.out.print(currentNode.data+" ");
				}
				if(currentNode.left!=null) {
					queue.add(currentNode.left);
				}
				if(currentNode.right!=null) {
					queue.add(currentNode.right);
				}
			}
		}
		System.out.println();
	}
	
	private static void rightView(BTNode<Integer> node) {
		Queue<BTNode<Integer>> queue = new LinkedList<BTNode<Integer>>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				BTNode<Integer> currentNode = queue.poll();
				if(i==(size-1)) {
					System.out.print(currentNode.data+" ");
				}
				if(currentNode.left!=null) {
					queue.add(currentNode.left);
				}
				if(currentNode.right!=null) {
					queue.add(currentNode.right);
				}
			}
		}
		System.out.println();
	}
	
	private static void verticalView(BTNode<Integer> node) {
		LinkedList<Obj> list = new LinkedList<Obj>();
		Queue<Obj> queue = new LinkedList<Obj>();
		queue.add(new Obj(node,0));
		list.add(new Obj(node,0));
		while(!queue.isEmpty()) {
			Obj currObj = queue.poll();
			int currHd = currObj.dis;
			if(currObj.node.left!=null) {
				Obj lobj = new Obj(currObj.node.left, currHd-1); 
				queue.add(lobj);
				list.add(lobj);
			}
			if(currObj.node.right!=null) {
				Obj robj = new Obj(currObj.node.right, currHd+1);
				queue.add(robj);
				list.add(robj);
			}
		}
		
		Map<Object, List<Obj>> objs =  list.stream().collect(Collectors.groupingBy(w->w.dis));
		objs.forEach((k,v)->{
			v.forEach(t-> {
				System.out.print(t.node.data+" ");
			});
			System.out.println();
		});
	}

	private static void verticalRecursive(BTNode<Integer> node,TreeMap<Integer, List<Obj>> map, int hd) {
		if(node==null) {
			return;
		}
		Obj ob = new Obj(node, hd);
		if(!map.containsKey(hd)) {
			LinkedList<Obj> ls = new LinkedList<Obj>();
			ls.add(ob);
			map.put(hd, ls);
		}else {
			map.get(hd).add(ob);
		}
		verticalRecursive(node.left, map, hd-1);
		verticalRecursive(node.right, map, hd+1);
	}
	
	private static void bottomView(BTNode<Integer> node) {
		System.out.println();
		LinkedList<Obj> list = new LinkedList<Obj>();
		Queue<Obj> queue = new LinkedList<Obj>();
		queue.add(new Obj(node,0));
		list.add(new Obj(node,0));
		while(!queue.isEmpty()) {
			Obj currObj = queue.poll();
			int currHd = currObj.dis;
			if(currObj.node.left!=null) {
				Obj lobj = new Obj(currObj.node.left, currHd-1); 
				queue.add(lobj);
				list.add(lobj);
			}
			if(currObj.node.right!=null) {
				Obj robj = new Obj(currObj.node.right, currHd+1);
				queue.add(robj);
				list.add(robj);
			}
		}
		
		list.stream().sorted(Comparator.comparing(Obj::getDis).reversed()).collect(Collectors.groupingBy(r->r.dis))
			.forEach(
				(k,v)->{
					System.out.println(v.get(v.size()-1).getNode().data);
				});
		
	}
	
	
	public static void main(String[] args) {
		BTreeViews<Integer> bTreeViews = new BTreeViews<Integer>();
		bTreeViews.root = new BTNode<Integer>(1);
		bTreeViews.root.left = new BTNode<Integer>(2);
		bTreeViews.root.right = new BTNode<Integer>(3);
		bTreeViews.root.left.left = new BTNode<Integer>(4);
		bTreeViews.root.left.right = new BTNode<Integer>(5);
		bTreeViews.root.right.left = new BTNode<Integer>(6);
		bTreeViews.root.right.right = new BTNode<Integer>(7);
		leftView(bTreeViews.root);
		rightView(bTreeViews.root);
		verticalView(bTreeViews.root);
		TreeMap<Integer, List<Obj>> map = new TreeMap<Integer, List<Obj>>();
		verticalRecursive(bTreeViews.root, map, 0);
		map.forEach((k,v)->{
			v.forEach(t-> {
				System.out.print(t.node.data+" ");
			});
			System.out.println();
		});
		bottomView(bTreeViews.root);
	}
}
