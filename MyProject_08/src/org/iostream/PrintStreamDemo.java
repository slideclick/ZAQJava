package org.iostream;
	import java.io.*;
	public class PrintStreamDemo {
		public static void main(String[] args) {
			int[][] a = new int[10][10];
			PrintStream ps = null;
			try {
				FileOutputStream fos = new FileOutputStream(
						"e:/workbench/MyProject_08/src/org/iostream/t5.txt");
				ps = new PrintStream(fos);
				if (ps != null) {
					System.setOut(ps);						// ʹ��׼����ض���
				}
				int i = 0;
				int j = 0;
				for (i = 0; i < 10; i++) {
					a[i][i] = 1;								// ʹ�Խ���Ԫ��Ϊ1
					a[i][0]= 1;								// ʹ��һ��Ԫ��Ϊ1
				}
				for (i = 2; i < 10; i++)
					for (j = 1; j <= i - 1; j++){
						a[i][j] = a[i - 1][j - 1] + a[i - 1][j];	// ��һ����ͬ�к�ǰһ��������֮��
					}
				for (i = 0; i < 10; i++) {
					for (j = 0; j <=i; j++) {
						System.out.print(a[i][j] + " \t");
					}
					System.out.println();
				}
			} catch (IOException e) {
				e.printStackTrace();		
			}
		}
	}
