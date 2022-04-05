package com.algorithms.arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayTest {
	
	ArrayStatistics arrayStatistics;
	
	@BeforeEach
	public void setUp() {
		arrayStatistics = new ArrayStatistics();
	}

	/**
	 * test findMinimumDistanceBetweenTwoNumbers
	 */
	@Test
	public void testfindMinimumDistanceBetweenTwoNumbers() {
		int arr[] = new int[]{3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
		assertTrue("Difference in expected value", Integer.valueOf(1)==arrayStatistics.findMinimumDistanceBetweenTwoNumbers(arr, 3, 6));
		arr = new int[]{2, 5, 3, 5, 4, 4, 2, 3};
		assertTrue("Difference in expected value", Integer.valueOf(1)==arrayStatistics.findMinimumDistanceBetweenTwoNumbers(arr, 3, 2));
		arr = new int[]{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		assertTrue("Difference in expected value", Integer.valueOf(4)==arrayStatistics.findMinimumDistanceBetweenTwoNumbers(arr, 3, 6));
	}
	
	/**
	 * test findMaximumIncreasingDecreasing
	 */
	@Test
	public void testfindMaximumIncreasingDecreasing() {
		int arr[] = new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		assertTrue("Difference in expected value",(500==arrayStatistics.findMaximumIncreasingDecreasing(arr, 0, arr.length-1)));
		arr = new int[]{1, 3, 50, 10, 9, 7, 6};
		assertTrue("Difference in expected value",(50==arrayStatistics.findMaximumIncreasingDecreasing(arr, 0, arr.length-1)));
		arr = new int[]{10, 20, 30, 40, 50};
		assertTrue("Difference in expected value",(50==arrayStatistics.findMaximumIncreasingDecreasing(arr, 0, arr.length-1)));
		arr = new int[]{120, 100, 80, 20, 0};
		assertTrue("Difference in expected value",(120==arrayStatistics.findMaximumIncreasingDecreasing(arr, 0, arr.length-1)));		
	}
	
	/**
	 * test findLargest
	 */
	@Test
	public void testMany() {
		int arr[] = new int[]{20, 10, 20, 4, 100, 30, 24, 140, 4};
		assertTrue("Difference in expected value",(140==arrayStatistics.findLargest(arr)));
		int res[] = arrayStatistics.findLargestThree(arr);
		assertEquals("Difference in expected value", 140, res[0]);
		assertEquals("Difference in expected value", 100, res[1]);
		assertEquals("Difference in expected value", 30, res[2]);
	}
	
}
