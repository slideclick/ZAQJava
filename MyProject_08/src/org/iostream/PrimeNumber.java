package org.iostream;
	import java.io.*;
	public class PrimeNumber {
		BufferedWriter bw =null;
		String filename = "e:/workbench/MyProject_08/src/org/iostream/t8.txt";
		boolean isPrime(int n) { 
			for (int i = 2; i <= n / 2; i++)
				if (n % i == 0)
					return false;
			return true;
		}
		void printPrime(int m) throws IOException {
			bw = new BufferedWriter(new FileWriter(filename));
			int j = 0;
			for (int i = 2; i <= m; i++){
				if (isPrime(i)){
					j++;
					String s= String.valueOf(i);
					String s1 = s +"  ";
					bw.write(s1);					// 写入到文本文件中
					if(j==10){
						j=0;
						bw.newLine();					// 写入一个行分隔符
					}
				}
			}
			bw.flush();									// 强制刷新流
			bw.close();
		}
		public static void main(String[] args) throws IOException {
			PrimeNumber pn = new PrimeNumber();
			pn.printPrime(100); 							// 打印出100 之内的所有质数
		}
	}

