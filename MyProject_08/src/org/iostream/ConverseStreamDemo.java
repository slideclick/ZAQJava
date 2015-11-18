	package org.iostream;
	import java.io.*;
	public class ConverseStreamDemo {
		public static void main(String[] args) {
			String filename = "e:/workbench/MyProject_08/src/org/iostream/t6.txt";
			try {
				OutputStreamWriter osw = new OutputStreamWriter(
						new FileOutputStream(filename));
				osw.write("中国北京");
				System.out.println(osw.getEncoding()); 	// 显示默认字符集编码
				osw.close();
				osw = new OutputStreamWriter(new FileOutputStream(filename, true),"GB2312");
				osw.write("中国北京");
				System.out.println(osw.getEncoding()); 	// 显示指定字符集编码
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(
						filename), "GB2312");
				int c;
				while ((c = isr.read()) != -1)
					System.out.print((char) c);
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

