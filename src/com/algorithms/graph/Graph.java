package com.algorithms.graph;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph <T extends Comparable<T>>{

	private LinkedHashMap<T, LinkedList<T>> map;
	
	/**
	 * initialization
	 */
	public Graph() {
		map = new LinkedHashMap<T, LinkedList<T>>();
	}
	
	/**
	 * adding vertex to a graph
	 * @param src
	 */
	public void addVertex(T src) {
		map.putIfAbsent(src, new LinkedList<T>());
	}
	
	/**
	 * adding edge from source to destination
	 * @param src
	 * @param dest
	 */
	public void addEdge(T src,T dest) {
		map.get(src).add(dest);
	}
	
	/**
	 * method printing a graph
	 */
	public void printGraph() {
		for(T src:map.keySet()) {
			System.out.println(src+" -> "+map.get(src));
		}
	}
	
	/**
	 * breadth first search with a particular source
	 * @param src
	 */
	public void bfs(T src) {
		LinkedHashMap<T,Boolean> visited = new LinkedHashMap<T, Boolean>();
		Queue<T> queue = new LinkedList<T>();
		queue.add(src);
		while(!queue.isEmpty()) {
			T node = queue.poll();
			System.out.println(node);
			visited.putIfAbsent(node, true);
			LinkedList<T> neighbours = map.get(node);
			for(T n:neighbours) {
				if(!visited.getOrDefault(n,false)) {
					queue.add(n);
					visited.putIfAbsent(n, true);
				}
			}
		}	
	}
	
	/**
	 * depth first search
	 * @param src
	 */
	public void dfs(T src) {
		LinkedHashMap<T,Boolean> visited = new LinkedHashMap<T, Boolean>();
		Stack<T> stack = new Stack();
		stack.push(src);
		while(!stack.isEmpty()) {
			T node = stack.pop();
			System.out.println(node);
			visited.putIfAbsent(node, true);
			LinkedList<T> neighbours = map.get(node);
			for(T n:neighbours) {
				if(!visited.getOrDefault(n,false)) {
					stack.add(n);
					visited.putIfAbsent(n, true);
				}
			}
		}
	}
	
	/**
	 * getting graph size to test
	 * @return
	 */
	public int graphSize() {
		return this.map.size();
	}
}
