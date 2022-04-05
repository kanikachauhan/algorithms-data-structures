package com.algorithms.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArraySortingTest {
	
	ArraySorting arraySorting;
	
	@BeforeEach
	public void setUp() {
		arraySorting = new ArraySorting();
	}
	
	@Test
	public void testSorting() {
		int arr[] = new int[] {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		arraySorting.sortArraysWithTwoTypesElements(arr);
		arr  = new int[] {12, 10, 9, 45, 2, 10, 10, 45};
		arraySorting.distinctElementsArray(arr);
		int a1[] = new int[] {1, 2, 4, 5, 6 };
		int a2[] = new int[] {2, 3, 5, 7 };
		arraySorting.unionIntersectionSorted(a1, a2);
		arr = new int[] {10, 21, 22, 100, 101, 200, 300};
		arraySorting.printPossibleTriangles(arr);
	}

}
