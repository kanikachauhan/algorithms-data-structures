package com.algorithms.matrix;

public class MatrixTest {

	
	
	public static void main(String[] args) {
		Matrix matrix = new Matrix();
		int mat[][] = {{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.rotate90(mat);
		matrix.printMatrix(mat);
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.rotateby180(mat);
		matrix.printMatrix(mat);
		mat = new int[][]{{ 1, 2, 3, 21 },{ 12, 1, 67, 8 },{ 19, 120, 11, 124 },{ 1, 14, 156, 190 }};
		matrix.findMaximumElement(mat);
		
	}
}
