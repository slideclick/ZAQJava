package org.iostream;
	import java.io.*;
	public class ByteArrayInputStreamDemo {
		public static void main(String[] args) throws IOException {
			String str = "abcdefghijk";
			byte[] strBuf = str.getBytes();					// ���ַ���ת��Ϊ�ֽ�����
			ByteArrayInputStream bais = new ByteArrayInputStream(strBuf);
			int data = bais.read();							// ���ֽ�������������ȡ�ֽ�
			while (data != -1) {
				char upper = Character.toUpperCase((char) data);	// Сдת��Ϊ��д
				System.out.print(upper + " ");
				data = bais.read();						
			}
			bais.close();
		}
	}
