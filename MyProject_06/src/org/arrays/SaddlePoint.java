package org.arrays;
	public class SaddlePoint {
		public static void main(String[] args) {
			int[][] a = { { 1, 3, 4, 7 }, { 5, 6, 2, 0 }, { 16, 36, 61, 18 } };
			int lineMin;					 		// ������Сֵ
			int minx; 								// ������Сֵ������
			int miny;				 				// ������Сֵ������
			again: for (int i = 0; i < a.length; i++) { 
				lineMin = a[i][0];
				minx = i; miny = 0;
				//**********�ҵ�i������Сֵ********************
				for (int j = 0; j < a[i].length; j++) { 
					if (a[i][j] < lineMin) {
						lineMin = a[i][j];
						minx = i; miny = j;
					}
				}
				//*********�и���Сֵ�Ƿ����������**************
				for (int j = 0; j < a.length; j++) {
					if (a[j][miny] > lineMin) 			// ������󣬿�ʼ��һ��
						continue again;
				}
				System.out.println("���㣺" + lineMin + " λ�ڣ�(" + minx + " , " + miny+ " ) ");
			}
		}
	}