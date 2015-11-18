package org.iostream;
	import java.io.*;
	class FileInputStreamDemo {
		public static void main(String[] args) {
			String filename;
			int ch = 0;
			filename = "e:/workbench/MyProject_08/src/org/iostream/t1.txt";
			try {
				FileInputStream fis = new FileInputStream(filename);
				while ((ch = fis.read()) != -1) {			// 从文件输入流读取数据
					System.out.print((char) ch);
				}
				fis.close();							// 关闭文件输入流
			} catch (IOException e) {
				System.out.println("File not found");
			}
		}
	}

