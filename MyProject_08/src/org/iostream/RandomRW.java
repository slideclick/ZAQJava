package org.iostream;
	import java.io.*;
	public class RandomRW {
		public static void main(String[] args) throws Exception {
			RandomAccessFile raf = new RandomAccessFile("c:/t.dat", "rw");
			final int DOUBLE_SIZE = 8; 
			for (int i = 0; i < 10; i++){ 				// 写入10个Double数值
				raf.writeDouble(i);
				System.out.print("  " + (double) i);
			}
			System.out.println();
			raf.close();
			RandomAccessFile raf1 = new RandomAccessFile("c:/t.dat", "rw");
			raf1.seek(3 * DOUBLE_SIZE);			// 修改第三个double值
			raf1.writeDouble(300);
			raf1.seek(5 * DOUBLE_SIZE);			// 修改第五个double值
			raf1.writeDouble(500);
			raf1.close();
			//验证是否已修改
			RandomAccessFile raf2 = new RandomAccessFile("c:/t.dat", "r");
			for (int i = 0; i < 10; i++) {
				System.out.print("  " + raf2.readDouble());
			}
			System.out.println();
			raf2.close();
		}
	}

