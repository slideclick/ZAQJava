package org.iostream;
	import java.io.*;
	class ByteArrayOutputStreamDemo {
		public static void main(String args[]) throws IOException {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			String s = "welcome to use ByteArrayOutputStream.";
			byte buf[] = s.getBytes();	
			baos.write(buf);				  // ��ָ�� byte �����е��ֽ�д��� byte ���������
			System.out.println(baos.toString());  // ͨ�������ֽڽ�����������ת��Ϊ�ַ������
			// ����һ���·���� byte ���飬�����������е����ݸ��Ƶ���������
			byte b[] = baos.toByteArray();		
			for (int i = 0; i < b.length; i++)
				System.out.print((char) b[i]);
		}
	}
