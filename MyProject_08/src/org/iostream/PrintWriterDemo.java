	package org.iostream;
	import java.util.*;
	import java.io.*;
	public class PrintWriterDemo {
		public static void main(String[] s) throws Exception {
			int A = 0;							// 千位上的数
			int B = 0;							// 百位上的数
			int C = 0;							// 十位上的数
			int num = 0;
			String filename = "e:/workbench/MyProject_08/src/org/iostream/t9.txt";
			FileWriter fw = new FileWriter(filename);
			PrintWriter pw = new PrintWriter(fw); 
			for (int i = 1000; i < 10000; i++) {
				A = i / 1000;
				B = i/100%10;
				C = i/10%10;
				if (i % 11 == 0 && A == B + C) {
					pw.print(i+"   ");
					if (++num % 7 == 0) {
						pw.println();			// 写入回车换行符
					}
				}
			}
			fw.close();
		}
	}

