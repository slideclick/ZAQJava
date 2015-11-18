package org.arrays;
	public class SaddlePoint {
		public static void main(String[] args) {
			int[][] a = { { 1, 3, 4, 7 }, { 5, 6, 2, 0 }, { 16, 36, 61, 18 } };
			int lineMin;					 		// 行中最小值
			int minx; 								// 行中最小值所在行
			int miny;				 				// 行中最小值所在列
			again: for (int i = 0; i < a.length; i++) { 
				lineMin = a[i][0];
				minx = i; miny = 0;
				//**********找第i行中最小值********************
				for (int j = 0; j < a[i].length; j++) { 
					if (a[i][j] < lineMin) {
						lineMin = a[i][j];
						minx = i; miny = j;
					}
				}
				//*********判该最小值是否是列中最大**************
				for (int j = 0; j < a.length; j++) {
					if (a[j][miny] > lineMin) 			// 不是最大，开始下一行
						continue again;
				}
				System.out.println("马鞍点：" + lineMin + " 位于：(" + minx + " , " + miny+ " ) ");
			}
		}
	}