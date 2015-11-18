package org.arrays;
	public class MatrixAdd {
		public static void main(String[] args) {
			int i , j ;
			int[][] arr1 = new int[][]{{6,8,14,},{7,5,6},{9,8,13}};
			int [][]arr2 = new int[][]{{3,4,6},{5,3,12},{12,11,21}};
			int[][] arr3= new int[3][3];
			for (i=0;i<3;i++){
				for(j=0;j<3;j++){
					arr3[i][j]=arr1[i][j]+arr2[i][j];
				}
			}
			for(int k =0;k<3;k++){
				for(int p=0;p<3;p++){
					System.out.print("   "+arr3[k][p]);
				}
				System.out.println();
			}
		}
	}

