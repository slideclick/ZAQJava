package org.iostream;
	import java.io.*;
	public class BufferedFileCopy {
		public static void main(String[] args) {
			FileInputStream fis = null;
			FileOutputStream fos = null;
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			int c;									
			try {
				// 文件输入流
				fis = new FileInputStream("e:/workbench/MyProject_08/src/org/iostream/t12.txt"); 
				bis = new BufferedInputStream(fis); 		// 串接成带缓冲的输入流
				 // 文件输出流
				fos = new FileOutputStream("e:/workbench/MyProject_08/src/org/iostream/t13.txt");
				bos = new BufferedOutputStream(fos); 		// 串接成带缓冲的输出流
				while ((c = bis.read()) != -1)
					bos.write(c);
				bos.flush(); 						// 刷新流，强制输出
			} catch (FileNotFoundException e1) {
				System.out.println(e1);
			} catch (IOException e2) {
				System.out.println(e2);
			} finally {
				try {
					if (fis != null)
						fis.close();
					if (fos != null)
						fos.close();
					if (bis != null)
						bis.close();
					if (bos != null)
						bos.close();
				} catch (IOException e3) {
					System.out.println(e3);
				}
			}
		}
	}

