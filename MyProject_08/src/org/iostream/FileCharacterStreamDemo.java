package org.iostream;
	import java.io.*;
	public class FileCharacterStreamDemo {
		public static void main(String[] s) throws Exception {
			String filename1 = "e:/workbench/MyProject_08/src/org/iostream/t17.txt";
			String filename2 = "e:/workbench/MyProject_08/src/org/iostream/t18.txt";
			FileReader filereader = new FileReader(filename1);
			FileWriter filewriter = new FileWriter(filename2);
			int c;
			while ((c = filereader.read()) != -1)				// 从FileReader类中读取一个字符
				filewriter.write(c);							// 向FileWriter类中写入一个字符
			filereader.close();
			filewriter.close();
		}
	}
