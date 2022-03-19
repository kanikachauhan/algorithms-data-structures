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
			System.out.print(max+" ");
		}
		System.out.println();
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
	
	/**
	 * interchange first and last row of a matrix
	 */
	public void interchangeFirstLast(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<n;i++) {
			int temp = matrix[0][i];
			matrix[0][i] = matrix[m-1][i];
			matrix[m-1][i] = temp;
		}
	}

	/**
	 * Given an n x n matrix .In the given matrix, you have to print the elements of the matrix in the snake pattern.
	 */
	public void snakePattern(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++) {
			if(i%2==0) {
				for(int j=0;j<n;j++) {
					System.out.print(matrix[i][j]+" ");
				}
			}else {
				for(int j=n-1;j>=0;j--) {
					System.out.print(matrix[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”.
	 */
	public void searchSortedMatrix(int matrix[][],int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		int i=0;
		int j=n-1;
		while(i<m && j>=0) {
			if(matrix[i][j]<k) {
				i++;
			}else if(matrix[i][j]>k) {
				j--;
			}else {
				System.out.println("found");
				break;
			}
		}
	}
	
	/**
	 * Given a matrix of size n x m. Print the boundary elements of the matrix. 
	 */
	public void printBoundary(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<n;i++) {
			System.out.print(matrix[0][i]+" ");
		}
		for(int i=0;i<n;i++) {
			System.out.print(matrix[m-1][i]+" ");
		}
		for(int i=0;i<m;i++) {
			System.out.print(matrix[i][0]+" ");
		}
		for(int i=0;i<m;i++) {
			System.out.print(matrix[i][m-1]+" ");
		}
		System.out.println();
	}

	/**
	 * Given an integer matrix of odd dimensions (3 * 3, 5 * 5). then the task is to find the sum of the middle row & column elements. 
	 */
	public void sumMiddleRowAndColumn(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		int sum = 0;
		for(int i=0;i<m;i++) {
			sum = sum + matrix[i][n/2];
		}
		for(int i=0;i<n;i++) {
			sum = sum + matrix[m/2][i];
		}
		System.out.println(sum);
	}
	
	/**
	 * Row wise and column wise traversal
	 */
	public void traversals(int matrix[][]) {
		System.out.println("Row traversal");
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Column traversal");
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(matrix[j][i]+" ");
			}System.out.println();
		}
	}
	
	/**
	 * Given a square matrix and the task is to check the matrix is in lower triangular form or not.
	 */
	public boolean checkLowerTriangular(int matrix[][]) {
		boolean flag = true;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(i<j && matrix[i][j]!=0) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * Given a square matrix and the task is to check the matrix is in upper triangular form or not.
	 */
	public boolean checkUpperTriangular(int matrix[][]) {
		boolean flag = true;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(i>j && matrix[i][j]!=0) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * Given a square matrix, swap upper diagonal elements of matrix with lower diagonal elements of matrix.
	 */
	public void swapUpperAndLowerDiagonals(int matrix[][]) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=i+1;j<matrix[i].length;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	/**
	 * Given a square matrix of order n*n, we need to print elements of the matrix in Z form
	 */
	public void printMatrixInZForm(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0) {
					System.out.print(matrix[i][j]+" ");
				}
				else if(i==m-1) {
					System.out.print(matrix[i][j]+" ");
				}
				else if(i!=0 && i!=(m-1) && j==(n-i-1)) {
					System.out.print(matrix[i][n-i-1]+" ");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Given a square matrix of order n*n, you have to interchange the elements of both diagonals. 
	 */
	public void interchangeDiagonals(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[i][n-j-1];
					matrix[i][n-j-1] = temp;
				}
			}
		}
	}
	
	/**
	 * Given a matrix of n X n. The task is to calculate the absolute difference between the sums of its diagonal.
	 */
	public void DifferenceBetweenSumsOfDiagonals(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		int s1 = 0, s2 = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					s1 = s1 + matrix[i][j];
					s2 = s2 + matrix[i][n-j-1];
				}
			}
		}
		System.out.println(s1-s2);
	}

	/**
	 * Given a square matrix, find if it’s a Toeplitz matrix or not. 
	 * A Toeplitz (or diagonal-constant) matrix is a matrix in which each descending diagonal from left to right is constant, 
	 * i.e., all elements in a diagonal are same.
	 */
	public boolean isToeplitz(int matrix[][]) {
		boolean flag = true;
		for(int i=0;i<matrix.length-1;i++) {
			for(int j=0;j<matrix[0].length-1;j++) {
				if(matrix[i][j]!=matrix[i+1][j+1]) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * Transpose of a matrix is obtained by changing rows to columns and columns to rows. 
	 */
	public void findTranspose(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++) {
			for(int j=i;j<n;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
