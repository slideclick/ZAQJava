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
						bos.write(s.getBytes());			// ���ַ���ת��Ϊ�ֽ�����
						bos.write("\r\n".getBytes()); 		// д��س����з�	
					}else {
						String s= String.valueOf(i)+"   ";
						bos.write(s.getBytes());
					}
				}
			}
			bos.flush();									// ǿ��ˢ����
			bos.close();									// �ر������
		}
		void getPrime() throws Exception{
			bis = new BufferedInputStream(new FileInputStream(filename));
			int c =bis.read();								// ��ȡ������
			while( c!=-1){
				char ch = (char)c;						// ������ת��Ϊchar����
				System.out.print(ch);
				c = bis.read();	
			}
			bis.close();
		}
		public static void main(String[] args) throws Exception {
			TestPrime pn = new TestPrime();
			p = Integer.parseInt(args[0]);						// ���ַ�������ת��Ϊ����
			s = Integer.parseInt(args[1]);
			pn.printPrime(p); 							// ��ӡ��100 ֮�ڵ���������
			pn.getPrime();								// ��ȡ�ı��ļ��е�100������
		}
	}

