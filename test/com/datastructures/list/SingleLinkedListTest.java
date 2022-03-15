package com.datastructures.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {
	
	SingleLinkedList<Integer> list;
	
	@BeforeEach
	public void setUp() {
		list = new SingleLinkedList<Integer>();
		list.append(1); list.append(2); list.append(3); list.append(4);
	}
	

	/**
	 * tests append,search,indexof,get methods
	 */
	@Test
	public void testInsert() {
		assertNotNull(list);
		assertNotNull(list.head);
		list.insertBefore(200, list.head.next.next);
		assertTrue(list.search(200));
		assertEquals("Index difference", 2, list.indexOf(200));
		assertTrue(list.searchRecur(list.head, 200));
		list.insertAfter(1000, list.head);
		assertTrue(list.search(1000));
		assertEquals("Index difference", 0, list.indexOf(1000));
		list.insertAfter(2000, list.head.next.next);
		assertTrue(list.search(2000));
		assertEquals("Index difference", 3, list.indexOf(2000));
		assertEquals("Index difference", -1,list.indexOf(102324));
		assertEquals("Difference in value",2000 ,(int)(list.get(3).data));
		assertEquals("Difference in value",1000 ,(int)(list.get(0).data));
		assertEquals("Difference in value",200, (int)(list.nthNodeEnd(3).data));
	}
	
	/**
	 * tests length calculations
	 */
	@Test
	public void testLength() {
		assertEquals(4, list.size());
		assertEquals(4, list.sizeRecur(list.head, 0));
	}
	
	/**
	 * test searching
	 */
	@Test
	public void testSearch() {
		assertTrue(list.search(3));
		assertFalse(list.searchRecur(list.head, 13));
		assertTrue(list.searchRecur(list.head, 3));
	}
}
