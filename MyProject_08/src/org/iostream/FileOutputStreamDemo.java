package org.iostream;
	import java.io.*;
	public class FileOutputStreamDemo {
		public static void main(String[] args) throws IOException {
			int n = 0;
			int num = 0;
			int i = 0;
			String filename = "e:/workbench/MyProject_08/src/org/iostream/t2.txt";
			FileOutputStream fos = null;
			FileInputStream fis = null;
			try {
				fos = new FileOutputStream(filename,true);
				for (n =100;n<=200;n++){
					if (n % 3 ==0){
						i++;
						String str = String.valueOf(n);		// 返回整型值的字符串表示形式
						String str1 = str+"   ";			// 两数之间保留一定空隙
						byte[] buff = str1.getBytes();			// 把字符串转换为字节数组
						fos.write(buff); 		
						if(i%10==0){
							str = "\r\n";					// 回车换行
							byte[] buf = str.getBytes();
							fos.write(buf);
						}
					}
				}
				fos.close();
			} catch (FileNotFoundException e1) {
				System.out.println(e1);
			} catch (IOException e2) {
				System.out.println(e2);
			}
		}
	}
