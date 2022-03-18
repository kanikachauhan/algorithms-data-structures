package com.algorithms.arrays;

public class ArrayStatistics {

	/**
	 * Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. 
	 * The array might also contain duplicates. You may assume that both x and y are different and present in arr[].
	 * @param arr
	 * @return
	 */
	public int findMinimumDistanceBetweenTwoNumbers(int arr[],int x,int y) {
		int x_pos = -1;
		int y_pos = -1;
		int diff = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==x) {
				x_pos = i;
			}
			if(arr[i]==y) {
				y_pos = i;
			}
			if(x_pos!=-1 && y_pos!=-1 && x_pos!=y_pos) {
				int diff_cal = Math.abs(x_pos-y_pos);
				diff = Math.min(diff_cal, diff);
			}
		}
		return diff;
	}
	
	/**
	 * Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array. 
	 */
	public int findMaximumIncreasingDecreasing(int arr[],int low,int high) {
		if(low<=high) {
			if(low==high)
				return arr[low];
			if((high==low+1) && (arr[low]>=arr[high]))
				return arr[low];
			if((high==low+1) && (arr[low]<arr[high]))
				return arr[high];
			int mid = (low + high)/2;
			if((arr[mid]>arr[mid+1] && arr[mid-1]<arr[mid]))
				return arr[mid];
			if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1])
				return findMaximumIncreasingDecreasing(arr, low, mid-1);
			else
				return findMaximumIncreasingDecreasing(arr, mid+1, high);
		}
		return Integer.MIN_VALUE;
	}
	
	/**
	 * Given an array, find the largest element in it. 
	 */
	public int findLargest(int arr[]) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	/**
	 * Given an array with all distinct elements, find the largest three elements.
	 * Expected time complexity is O(n) and extra space is O(1). 
	 */
	public int[] findLargestThree(int arr[]) {
		int first = Integer.MIN_VALUE;
		int second = first;
		int third = second;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>first) {
				third = second;
				second = first;
				first = arr[i];
			}else if(arr[i]>second) {
				third = second;
				second = arr[i];
			}else if(arr[i]>third) {
				third = arr[i];
			}
		}
		return new int[] {first,second,third};
	}
	
	/**
	 * Given a sorted array of n distinct integers where each integer is in the range from 0 to m-1 and m > n.
	 * Find the smallest number that is missing from the array. 
	 */
	public int findSmallestMissing(int arr[],int low,int high) {
		//TODO
		return 0;
	}
	
	
}
