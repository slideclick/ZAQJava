package org.arrays;
	public class Magics {
		public static void main(String[] args) {
			int i = 0;
			int j = 0;
			int m = 0;
			int n = 5;
			j = (n + 1) / 2 - 1;
			int[][] a = new int[n][n];
			a[i][j] = ++m;			// ��һ�����ڵ�һ������
			while (m < n * n) {
				i--;
				j++;
				// ��������Ԫ��Ϊn��������ʱ����ѡ����һ��ͬ���ϵ�λ��Ϊ��λ��
				if (m % n == 0 && m > 1) {			
					i = i + 2;
					j = j - 1;
				}
				if (i < 0)			// ���������ϱ߽磬����λ��ȡӦѡ�е�����һ��λ��
					i = i + n;	
				if (j > (n - 1))		// ���������ұ߽磬����λ��ȡӦѡ�е�����һ��λ��
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

