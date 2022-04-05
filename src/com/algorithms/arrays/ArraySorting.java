package com.algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ArraySorting {

	public void sortArraysWithTwoTypesElements(int arr[]) {
		int i = 0;
		int j = arr.length-1;
		while(i<j) {
			if(arr[i]==0 && arr[j]==1) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			else if(arr[i]==0 && arr[j]==0) {
				j--;
			}
			else {
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void distinctElementsArray(int arr[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:arr) {
			set.add(i);
		}
		System.out.println(set);
	}
	
	
	public void unionIntersectionSorted(int arr1[],int arr2[]) {
		int i=0,j=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				System.out.print(arr1[i]+" ");
				i++;
			}else if(arr1[i]>arr2[j]) {
				System.out.print(arr2[j]+" ");
				j++;
			}else {
				System.out.print(arr1[i]+" ");
				i++;
				j++;
			}
		}
	}
	
	/**
	 * Given an unsorted array of positive integers, 
	 * find the number of triangles that can be formed with three different array elements as three sides of triangles. 
	 * For a triangle to be possible from 3 values, 
	 * the sum of any of the two values (or sides) must be greater than the third value (or third side). 
	 * @param arr
	 */
	public void printPossibleTriangles(int arr[]) {
		Arrays.sort(arr);
		for(int i=arr.length-1;i>=1;i--) {
			int temp =  arr[i];
			int l = 0;
			int r = i-1;
			while(l<r) {
				if((arr[l]+arr[r])>temp) {
					System.out.println(arr[l]+" "+arr[r]+" "+temp);
					r--;
				}else {
					l++;
				}
			}
		}
	}
}
