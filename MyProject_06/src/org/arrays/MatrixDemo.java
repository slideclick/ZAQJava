package org.arrays;
	public class MatrixDemo {
		public static void main(String[] args) {
			int[][] a1 = { { 1, 2, 3 }, { 4, 5, 6 } };
			int[][] b1 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
			int[][] c1 = new int[2][2];
			for (int row = 0; row < 2; row++) {
				for (int col = 0; col < 2; col++) {
					c1[row][col] = 0;
					for (int k = 0; k < 3; k++)
						c1[row][col] += a1[row][k] * b1[k][col];
				}
			}
			for (int row = 0; row < 2; row++) {
				for (int col = 0; col < 2; col++)
					System.out.print(" " + c1[row][col]);
				System.out.println();
			}
		}
	}
