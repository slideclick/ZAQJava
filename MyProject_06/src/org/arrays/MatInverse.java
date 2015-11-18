package org.arrays;
	public class MatInverse {
		public static void main(String[] args) {
			int a[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
			int b[][] = new int[4][3];
			int i =0 ; int j =0;
			System.out.println("矩阵转置前：");
			for (i=0;i<3;i++){
				for(j=0;j<4;j++){
					System.out.print(a[i][j]+"  ");
				}
				System.out.println();
			}
			for(i=0;i<3;i++){
				for(j=0;j<4;j++){
					b[j][i]= a[i][j];
				}
			}
			System.out.println("矩阵转置后：");
			for (i=0;i<4;i++){
				for(j=0;j<3;j++){
					System.out.print(b[i][j]+"  ");
				}
				System.out.println();
			}
		}
	}

