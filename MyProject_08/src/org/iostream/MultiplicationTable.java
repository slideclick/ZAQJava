package org.iostream;
	import java.io.*;
	public class MultiplicationTable {
		public static void main(String[] args) throws IOException {
			String filename = "e:/workbench/MyProject_08/src/org/iostream/t7.txt";
			FileReader fr = new FileReader(filename);
			FileWriter fw = new FileWriter(filename,true);
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= i; j++) {
					String s = i + "*" + j + "=" + i * j + " ";
					fw.write(s);
				}
				fw.write("\r\n");							// 写入回车换行符
			}
			fw.flush();										// 强制刷新流
			int c;
			while ((c = fr.read()) != -1){					// 将九九乘法表读取出来
				System.out.print((char)c);
			}
			fr.close();
			fw.close();
		}
	}
