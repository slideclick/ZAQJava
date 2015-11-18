package org.iostream;
	import java.io.*;
	public class ByteArrayInputStreamDemo {
		public static void main(String[] args) throws IOException {
			String str = "abcdefghijk";
			byte[] strBuf = str.getBytes();					// 把字符串转换为字节数组
			ByteArrayInputStream bais = new ByteArrayInputStream(strBuf);
			int data = bais.read();							// 从字节数组输入流读取字节
			while (data != -1) {
				char upper = Character.toUpperCase((char) data);	// 小写转换为大写
				System.out.print(upper + " ");
				data = bais.read();						
			}
			bais.close();
		}
	}
