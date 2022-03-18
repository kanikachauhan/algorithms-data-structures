package com.algorithms.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.algorithms.list.SingleLinkedList;

public class SingleLinkedListTest {

	private SingleLinkedList<Integer> list,palindromeList,duplicateList;

	@BeforeEach
	public void setUp() {
		list = new SingleLinkedList<Integer>();
		palindromeList = new SingleLinkedList<Integer>();
		duplicateList = new SingleLinkedList<Integer>();
		list.append(1);list.append(2);list.append(3);list.append(4);list.append(5);
		palindromeList.append(1);palindromeList.append(3); palindromeList.append(3); palindromeList.append(1);
		duplicateList.append(1);duplicateList.append(1);duplicateList.append(2);duplicateList.append(2);duplicateList.append(3);duplicateList.append(4);duplicateList.append(5);duplicateList.append(5);
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
		assertEquals("Index difference", -1, list.indexOf(102324));
		assertEquals("Difference in value", 2000, (int) (list.get(3).data));
		assertEquals("Difference in value", 1000, (int) (list.get(0).data));
		assertEquals("Difference in value", 3, (int) (list.nthNodeEnd(3).data));
	}

	/**
	 * tests length calculations
	 */
	@Test
	public void testLength() {
		assertEquals(5, list.size());
		assertEquals(5, list.sizeRecur(list.head, 0));
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

	/**
	 * test middle of list
	 */
	@Test
	public void testMiddle() {
		assertEquals("Difference in expected value", Integer.valueOf(3), list.findMiddle().data);
	}

	/**
	 * test occurrences
	 */
	@Test
	public void testOccurrences() {
		list.append(2);
		list.append(2);
		list.append(2);
		assertEquals("Difference in expected value", 4, list.findOccurrences(2));
	}

	/**
	 * test loop
	 */
	@Test
	public void testLoop() {
		Node temp = list.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = list.head;
		assertTrue("Difference in expected value", list.detectLoop());
		assertEquals("Difference in expected value", 5, list.lengthLoop());
	}

	/**
	 * test list deletion
	 */
	@Test
	public void testListDeletion() {
		list.deleteList();
		assertNull("Difference in expected value", list.head);
	}
	
	/**
	 * test node deletion
	 */
	@Test
	public void testNodeDeletion() {
		list.deleteNode(list.head);
		assertTrue("Difference in expected value", (list.indexOf(1)==-1));
		list.deleteNode(list.head.next);
		assertTrue("Difference in expected value",(list.indexOf(3)==-1));
		list.deleteNode(list.head.next.next);
		assertTrue("Difference in expected value",(list.indexOf(5)==-1));
	}
	
	/**
	 * test node deletion at a position
	 */
	@Test
	public void testNodeDeletionAtPosition() {
		list.append(6); list.append(7); list.append(8); list.append(9); list.append(10); list.append(11);
		list.deleteAtPosition(5);
		assertTrue("Difference in expected value",(list.size()==10));
	}
	
	/**
	 * test list is palindrome or not
	 */
	@Test
	public void testPalindrome() {
		assertTrue("Difference in expected value", palindromeList.isPalindrome());
		assertFalse("Difference in expected value", list.isPalindrome());
	}
	
	/**
	 * test duplicates
	 */
	@Test
	public void testDuplicates() {
		duplicateList.removeDuplicates();
		assertTrue("Difference in expected value",(duplicateList.size()==5));
	}
	
	/**
	 * test move last element to first
	 */
	@Test
	public void testMoveLastToFirst() {
		list.moveLastToFront();
		assertEquals("Difference in expected value", 5, (int)list.head.data);
	}
	
}
