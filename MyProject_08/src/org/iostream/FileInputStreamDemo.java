package org.iostream;
	import java.io.*;
	class FileInputStreamDemo {
		public static void main(String[] args) {
			String filename;
			int ch = 0;
			filename = "e:/workbench/MyProject_08/src/org/iostream/t1.txt";
			try {
				FileInputStream fis = new FileInputStream(filename);
				while ((ch = fis.read()) != -1) {			// ���ļ���������ȡ����
					System.out.print((char) ch);
				}
				fis.close();							// �ر��ļ�������
			} catch (IOException e) {
				System.out.println("File not found");
			}
		}
	}

