package org.iostream;
	import java.io.*;
	public class TestPrime {
		BufferedInputStream bis =null;
		BufferedOutputStream bos = null;
		String filename = "e:/workbench/MyProject_08/src/org/iostream/t3.txt";
		static int s,p;
		boolean isPrime(int n) { 
			for (int i = 2; i <= n / 2; i++)
				if (n % i == 0) return false;
			return true;
		}
		void printPrime(int m) throws IOException {
			bos = new BufferedOutputStream(new FileOutputStream(filename));
			int j = 0;
			for (int i = 2; i <= m; i++){
				if (isPrime(i)){
					j++;
					if(j%s==0){
						String s= String.valueOf(i)+"  ";
						bos.write(s.getBytes());			// 将字符串转换为字节数组
						bos.write("\r\n".getBytes()); 		// 写入回车换行符	
					}else {
						String s= String.valueOf(i)+"   ";
						bos.write(s.getBytes());
					}
				}
			}
			bos.flush();									// 强制刷新流
			bos.close();									// 关闭输出流
		}
		void getPrime() throws Exception{
			bis = new BufferedInputStream(new FileInputStream(filename));
			int c =bis.read();								// 读取输入流
			while( c!=-1){
				char ch = (char)c;						// 将整型转换为char类型
				System.out.print(ch);
				c = bis.read();	
			}
			bis.close();
		}
		public static void main(String[] args) throws Exception {
			TestPrime pn = new TestPrime();
			p = Integer.parseInt(args[0]);						// 将字符串类型转换为整型
			s = Integer.parseInt(args[1]);
			pn.printPrime(p); 							// 打印出100 之内的所有质数
			pn.getPrime();								// 读取文本文件中的100个质数
		}
	}

