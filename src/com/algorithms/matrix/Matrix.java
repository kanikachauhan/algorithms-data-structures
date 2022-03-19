package com.algorithms.matrix;

import java.util.LinkedHashMap;

public class Matrix {

	/**
	 * inplace rotate 90 degrees matrix
	 */
	public void rotate90(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		int h = n/2;
		for(int i=0;i<m;i++) {
			for(int j=0;j<h;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=i;j<n;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i]  = temp;
			}
		}
	}
	
	/**
	 * rotate a matrix by 180 degrees
	 */
	public void rotateby180(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		int h = n/2;
		for(int i=0;i<m;i++) {
			for(int j=0;j<h;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
		for(int i=0;i<m/2;i++) {
			for(int j=0;j<n;j++) {
				int temp = matrix[m-i-1][j];
				matrix[m-i-1][j] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}
	
	
	/**
	 * print matrix
	 */
	public void printMatrix(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(matrix[i][j]+" ");
			}System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Given a matrix, the task is to find the maximum element of each row.
	 */
	public void findMaximumElement(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++) {
			int max = Integer.MIN_VALUE;
			for(int j=0;j<n;j++) {
				if(matrix[i][j]>max) {
					max = matrix[i][j];
				}
			}
			System.out.println(max);
		}
	}
	
	/**
	 * Given a matrix mat[][] having n rows and m columns. We need to find unique elements in matrix i.e,
	 * those elements which are not repeated in the matrix or those elements whose frequency is 1. 
	 */
	public void findUniqueElements(int matrix[][]) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(!map.containsKey(matrix[i][j])) {
					map.put(matrix[i][j], 1);
				}else {
					map.put(matrix[i][j], map.get(matrix[i][j])+1);
				}
			}
		}
		for(int keys:map.keySet()) {
			if(map.get(keys)==1) {
				System.out.print(keys+" ");
			}
		}
	}
}
