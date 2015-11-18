package org.iostream;
	import java.io.*;
	public class RandomRW {
		public static void main(String[] args) throws Exception {
			RandomAccessFile raf = new RandomAccessFile("c:/t.dat", "rw");
			final int DOUBLE_SIZE = 8; 
			for (int i = 0; i < 10; i++){ 				// д��10��Double��ֵ
				raf.writeDouble(i);
				System.out.print("  " + (double) i);
			}
			System.out.println();
			raf.close();
			RandomAccessFile raf1 = new RandomAccessFile("c:/t.dat", "rw");
			raf1.seek(3 * DOUBLE_SIZE);			// �޸ĵ�����doubleֵ
			raf1.writeDouble(300);
			raf1.seek(5 * DOUBLE_SIZE);			// �޸ĵ����doubleֵ
			raf1.writeDouble(500);
			raf1.close();
			//��֤�Ƿ����޸�
			RandomAccessFile raf2 = new RandomAccessFile("c:/t.dat", "r");
			for (int i = 0; i < 10; i++) {
				System.out.print("  " + raf2.readDouble());
			}
			System.out.println();
			raf2.close();
		}
	}

