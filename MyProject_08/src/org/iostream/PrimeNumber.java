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
					bw.write(s1);					// д�뵽�ı��ļ���
					if(j==10){
						j=0;
						bw.newLine();					// д��һ���зָ���
					}
				}
			}
			bw.flush();									// ǿ��ˢ����
			bw.close();
		}
		public static void main(String[] args) throws IOException {
			PrimeNumber pn = new PrimeNumber();
			pn.printPrime(100); 							// ��ӡ��100 ֮�ڵ���������
		}
	}

