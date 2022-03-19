package com.algorithms.matrix;

import java.util.LinkedHashMap;
import java.util.Stack;

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
	
	/**
	 * Given a 2D matrix, print all elements of the given matrix in diagonal order.
	 */
	public void diagonalOrder(int matrix[][]) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.println(matrix[i][j]);
			}
		}
	}
	
	/**
	 * Given a matrix of m*n size, the task is to count all the rows in a matrix that are sorted 
	 * either in strictly increasing order or in strictly decreasing order?
	 */
	public void countAllSortedRows(int matrix[][]) {
		int m = matrix.length;
		int count = 0;
		for(int i=0;i<m;i++) {
			boolean flag = true;
			int n = matrix[i].length;
			int t1 = matrix[i][0];
			int t2 = matrix[i][1];
			if(t1<t2) {
				for(int j=1;j<n-1;j++) {
					if(matrix[i][j]>matrix[i][j+1]) {
						flag = false;
						break;
					}
				}
			}
			else if(t1>t2) {
				for(int j=1;j<n-1;j++) {
					if(matrix[i][j]<matrix[i][j+1]) {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	/**
	 * adds two square matrices
	 */
	public void add(int mat1[][],int mat2[][]) {
		int res[][] = new int[mat1.length][mat1[0].length];
		for(int i=0;i<mat1.length;i++) {
			for(int j=0;j<mat1[i].length;j++) {
				res[i][j] = mat1[i][j]+mat2[i][j];
			}
		}
		printMatrix(res);
	}
	
	/**
	 * subtract two square matrices
	 */
	public void subtract(int mat1[][],int mat2[][]) {
		int res[][] = new int[mat1.length][mat1[0].length];
		for(int i=0;i<mat1.length;i++) {
			for(int j=0;j<mat1[i].length;j++) {
				res[i][j] = mat1[i][j]-mat2[i][j];
			}
		}
		printMatrix(res);
	}
	
	/**
	 * Given a m x n 2D matrix, check if it is a Markov Matrix.
	 * Markov Matrix : The matrix in which the sum of each row is equal to 1.
	 */
	public boolean isMarkov(double matrix[][]) {
		boolean flag = true;
		for(int i=0;i<matrix.length;i++) {
			double sum = 0.0;
			for(int j=0;j<matrix[i].length;j++) {
				sum = sum+matrix[i][j];
			}
			if(sum!=1.0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * Given a matrix of order m*n then the task is to find the frequency of even and odd numbers in matrix 
	 */
	public void findFrequency(int matrix[][]) {
		int even = 0;
		int odd = 0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]%2==0) {
					even++;
				}else {
					odd++;
				}
			}
		}
		System.out.println(even+" "+odd);
	}
	
	/**
	 * Given a matrix of n*n size, the task is to find whether all rows are circular rotations of each other or not. 
	 */
	public void checkRotations(int matrix[][]) {
		String str = "";
		for(int i=0;i<matrix[0].length;i++) {
			str = str + matrix[0][i];
		}
		String tempstr = str + str;
		for(int i=1;i<matrix.length;i++) {
			String tstr = "";
			for(int j=0;j<matrix[i].length;j++) {
				tstr = tstr+matrix[i][j];
			}
			if(!tempstr.contains(tstr)) {
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
	}
	
	/**
	 * A square matrix is said to be symmetric matrix if the transpose of the matrix is same as the given matrix.
	 * Symmetric matrix can be obtain by changing row to column and column to row.
	 */
	public boolean isSymmetric(int matrix[][]) {
		boolean flag = true;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]!=matrix[j][i]) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * Given a N x N binary matrix (elements in matrix can be either 1 or 0) 
	 * where each row and column of the matrix is sorted in ascending order, count number of 0s present in it.
	 * Expected time complexity is O(N).
	 */
	public void countZerosInBinaryMatrix(int matrix[][]) {
		//TODO
	}
	
	/**
	 * Print a given matrix in spiral form
	 */
	public void printSpiral(int matrix[][]) {
		int k = 0;
		int m = matrix.length;
		int l = 0;
		int n = matrix.length;
		while(k<m && l<n) {
			for(int i=l;i<n;i++) {
				System.out.print(matrix[k][i]+" ");
			}
			k++;
			for(int i=k;i<m;i++) {
				System.out.print(matrix[i][n-1]+" ");
			}
			n--;
			if(k<m) {
				for(int i=n-1;i>=l;i--) {
					System.out.print(matrix[m-1][i]+" ");
				}
				m--;
			}
			if(l<n) {
				for(int i=m-1;i>=k;i--) {
					System.out.print(matrix[i][l]+" ");
				}	
				l++;
			}
		}
		System.out.println();
	}
	
	/**
	 * print matrix in anti-spiral form
	 */
	public void printAntiSpiral(int matrix[][]) {
		Stack<Integer> stack = new Stack<>();
		int k = 0;
		int l = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		while(k<m && l<n) {
			for(int i=l;i<n;i++) {
				stack.push(matrix[k][i]);
			}
			k++;
			for(int i=k;i<m;i++) {
				stack.push(matrix[i][n-1]);
			}
			n--;
			if(k<m) {
				for(int i=n-1;i>=l;i--) {
					stack.push(matrix[m-1][i]);
				}
				m--;
			}
			if(l<n) {
				for(int i=m-1;i>=k;i--) {
					stack.push(matrix[i][l]);
				}
				l++;
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}
	
	/**
	 * Given a matrix where every element is either ‘O’ or ‘X’, 
	 * replace ‘O’ with ‘X’ if surrounded by ‘X’. A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ 
	 * if there are ‘X’ at locations just below, just above, just left and just right of it. 
	 */
	public void replaceOwithX(char matrix[][]) {
	//TODO	
//		int m = matrix.length;
//		int n = matrix[0].length;
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				if(matrix[i][j]=='O') {
//					if((i+1)<m && (j+1)<n && (i-1)>0 && (j-1)>0 && matrix[i+1][j]=='X' &&  matrix[i-1][j]=='X' &&  matrix[i][j+1]=='X' &&  matrix[i][j-1]=='X') {
//						matrix[i][j] = 'Y';
//					}
//				}
//			}
//		}
//		
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				if(matrix[i][j]=='Y') {
//					matrix[i][j] = 'O';
//				}
//			}
//		}
//		
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(matrix[i][j]+" ");
//			}System.out.println();
//		}
	}
}
