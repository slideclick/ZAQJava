package org.arrays;
	public class MatMax {
		public static void main(String[] args) {
			int arr[][] = {{12,76,4,1},{19,28,55,6}
				,{2,10,13,2},{3,9,110,22}};
			int i =0; int j=0 ;int row=0;int col=0;int max=arr[0][0];
			System.out.println("4�׾����ǣ�");
			for(i=0;i<4;i++){
				for(j=0;j<4;j++){
					System.out.print(arr[i][j]+"  ");
					if(max<arr[i][j]){
						max = arr[i][j];
						row = i ; col = j;
					}
				}
				System.out.println();
			}
			System.out.println("������������"+max);
			System.out.println("����λ�ھ���ĵ�"+row+"��"+"��"+col+"��");
		}
	}

