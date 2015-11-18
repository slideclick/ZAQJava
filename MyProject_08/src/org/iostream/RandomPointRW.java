package org.iostream;
	import java.io.*;
	class Point {
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return "[" + x + "," + y + "]";
		}
		//*******在当前位置写点(x,y)对象***************************
		public void writePoint(RandomAccessFile f) throws IOException { 
			f.writeInt(x);
			f.writeInt(y);
		}
		//********在指定的第n位置写点(x,y)，n值从0开始************
		public void writePoint(RandomAccessFile f, int n) throws IOException { 
			f.seek(n * 8); 		// 移到第n个点的位置，一个点对象大小是8个字节(两个int型)
			f.writeInt(x);
			f.writeInt(y);
		}
		//********在当前位置读点对象******************************
		public static Point readPoint(RandomAccessFile f) throws IOException {
			int x = f.readInt();
			int y = f.readInt();
			return new Point(x, y);
		}
		//*******在指定的第n个位置读点对象
		public static Point readPoint(RandomAccessFile f, int n) throws IOException { 
			f.seek(n * 8);				
			int x = f.readInt();
			int y = f.readInt();
			return new Point(x, y);
		}	
	}
	public class RandomPointRW {
		public static void main(String[] args) throws Exception {
			Point pt;
			RandomAccessFile raf = new RandomAccessFile("c:/t1.dat", "rw");
			for (int i = 0; i < 10; i++) {
				pt = new Point(i, i);					// 创建点对象
				pt.writePoint(raf); 					// 点对象写入文件
				System.out.print("  " + pt);
			}
			System.out.println();
			raf.close();
			RandomAccessFile raf1 = new RandomAccessFile("c:/t1.dat", "rw");
			pt = new Point(300, 300);
			pt.writePoint(raf1, 3); 						// 修改第三个点对象值
			pt = new Point(500, 500);
			pt.writePoint(raf1, 5);						// 修改第五个点对象值
			raf1.close();
			//********验证是否已成功修改******************
			RandomAccessFile raf2 = new RandomAccessFile("c:/t1.dat", "r");
			for (int i = 0; i < 10; i++) {
				pt = Point.readPoint(raf2);
				System.out.print("  " + pt);
			}
			System.out.println();
			raf2.close();
		}
	}

