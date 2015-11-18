package org.iostream;
	import java.io.*;
	class ByteArrayOutputStreamDemo {
		public static void main(String args[]) throws IOException {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			String s = "welcome to use ByteArrayOutputStream.";
			byte buf[] = s.getBytes();	
			baos.write(buf);				  // 将指定 byte 数组中的字节写入此 byte 数组输出流
			System.out.println(baos.toString());  // 通过解码字节将缓冲区内容转换为字符串输出
			// 创建一个新分配的 byte 数组，并将缓冲流中的内容复制到该数组中
			byte b[] = baos.toByteArray();		
			for (int i = 0; i < b.length; i++)
				System.out.print((char) b[i]);
		}
	}
