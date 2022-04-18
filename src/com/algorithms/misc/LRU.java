package com.algorithms.misc;

import java.util.LinkedHashSet;

public class LRU {

	private LinkedHashSet<Integer> set;
	private int capacity;
	
	public LRU(int capacity) {
		set = new LinkedHashSet<Integer>();
		this.capacity = capacity;
	}
	
	public void addToCache(int key) {
		if(!set.contains(key)) {
			if(set.size()==this.capacity) {
				int fkey = set.iterator().next();
				this.set.remove(fkey);
			}
			this.set.add(key);
		}else {
			this.set.remove(key);
			this.set.add(key);
		}
	}
	
}
