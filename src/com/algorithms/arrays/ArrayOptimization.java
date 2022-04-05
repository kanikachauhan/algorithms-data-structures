package com.algorithms.arrays;

public class ArrayOptimization {

	public void largestSumContiguousArray(int arr[]) {
		int max = Integer.MIN_VALUE;
		int max_end = 0;
		int start = 0;
		int s = 0;
		int end = 0;
		for(int i=0;i<arr.length;i++) {
			max_end = max_end + arr[i];
			if(max<max_end) {
				max = max_end;
				start = s;
				end = i;
			}
			if(max_end<0) {
				max_end = 0;
				s = i+1;
			}
		}
		for(int i=start;i<end;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
