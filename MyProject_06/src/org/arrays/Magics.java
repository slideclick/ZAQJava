package org.arrays;
	public class Magics {
		public static void main(String[] args) {
			int i = 0;
			int j = 0;
			int m = 0;
			int n = 5;
			j = (n + 1) / 2 - 1;
			int[][] a = new int[n][n];
			a[i][j] = ++m;			// 第一个数在第一行正中
			while (m < n * n) {
				i--;
				j++;
				// 最近插入的元素为n的整数倍时，则选下面一行同列上的位置为新位置
				if (m % n == 0 && m > 1) {			
					i = i + 2;
					j = j - 1;
				}
				if (i < 0)			// 超出方阵上边界，则新位置取应选列的最下一个位置
					i = i + n;	
				if (j > (n - 1))		// 超出方阵右边界，则新位置取应选行的最左一个位置
					j = j - n;
				a[i][j] = ++m;
			}
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					System.out.print(a[i][j]+"\t");
				}
				System.out.println();
			}
		}
	}

