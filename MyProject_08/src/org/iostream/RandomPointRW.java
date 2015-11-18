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
		//*******�ڵ�ǰλ��д��(x,y)����***************************
		public void writePoint(RandomAccessFile f) throws IOException { 
			f.writeInt(x);
			f.writeInt(y);
		}
		//********��ָ���ĵ�nλ��д��(x,y)��nֵ��0��ʼ************
		public void writePoint(RandomAccessFile f, int n) throws IOException { 
			f.seek(n * 8); 		// �Ƶ���n�����λ�ã�һ��������С��8���ֽ�(����int��)
			f.writeInt(x);
			f.writeInt(y);
		}
		//********�ڵ�ǰλ�ö������******************************
		public static Point readPoint(RandomAccessFile f) throws IOException {
			int x = f.readInt();
			int y = f.readInt();
			return new Point(x, y);
		}
		//*******��ָ���ĵ�n��λ�ö������
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
				pt = new Point(i, i);					// ���������
				pt.writePoint(raf); 					// �����д���ļ�
				System.out.print("  " + pt);
			}
			System.out.println();
			raf.close();
			RandomAccessFile raf1 = new RandomAccessFile("c:/t1.dat", "rw");
			pt = new Point(300, 300);
			pt.writePoint(raf1, 3); 						// �޸ĵ����������ֵ
			pt = new Point(500, 500);
			pt.writePoint(raf1, 5);						// �޸ĵ���������ֵ
			raf1.close();
			//********��֤�Ƿ��ѳɹ��޸�******************
			RandomAccessFile raf2 = new RandomAccessFile("c:/t1.dat", "r");
			for (int i = 0; i < 10; i++) {
				pt = Point.readPoint(raf2);
				System.out.print("  " + pt);
			}
			System.out.println();
			raf2.close();
		}
	}

