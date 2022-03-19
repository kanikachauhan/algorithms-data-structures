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
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.interchangeFirstLast(mat);
		matrix.printMatrix(mat);
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.snakePattern(mat);
		mat = new int[][]{ {10, 20, 30, 40},{15, 25, 35, 45},{27, 29, 37, 48},{32, 33, 39, 50}};
		matrix.searchSortedMatrix(mat, 271);
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.printBoundary(mat);
		mat = new int[][] {{1,3,5,6,7},{3,5,3,2,1},{1,2,3,4,5},{7,9,2,1,6},{9,1,5,3,2}};
		matrix.sumMiddleRowAndColumn(mat);
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.traversals(mat);
		mat = new int[][]{{ 1,0,0,0 },{ 5,7,0,0 },{2,5,3,0 },{ 13, 14, 15, 16 }};
		System.out.println(matrix.checkLowerTriangular(mat));
		mat = new int[][]{{ 3,2,5,6 },{ 0,6,6,8 },{0,0,2,4 },{ 0,0,0,16 }};
		System.out.println(matrix.checkUpperTriangular(mat));
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.swapUpperAndLowerDiagonals(mat);
		matrix.printMatrix(mat);
		matrix.printMatrixInZForm(mat);
		System.out.println();
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.interchangeDiagonals(mat);
		matrix.printMatrix(mat);
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.DifferenceBetweenSumsOfDiagonals(mat);
		mat = new int[][] {{6,7,8,9},{4,6,7,8},{1,4,6,7},{0,1,4,6},{2,0,1,4}};
		System.out.println(matrix.isToeplitz(mat));
		mat = new int[][]{{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
		matrix.findTranspose(mat);
		matrix.printMatrix(mat);
	}
}
