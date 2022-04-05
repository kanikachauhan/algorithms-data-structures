package com.algorithms.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayOptimizationTest {

	ArrayOptimization arrayOptimization;
	
	
	@BeforeEach
	public void setUp() {
		arrayOptimization = new ArrayOptimization();
	}
	
	
	@Test
	public void testOptimization() {
		int arr[] = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
		arrayOptimization.largestSumContiguousArray(arr);
	}
}
