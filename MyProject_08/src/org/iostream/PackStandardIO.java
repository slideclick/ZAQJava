package org.iostream;
	import java.io.*;
	public class PackStandardIO {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
			PrintWriter out =new PrintWriter(System.out,true);			// ��װ��׼���
			String s;
			while ((s = br.readLine()) != null && s.length() != 0)			
				out.println(s.toUpperCase());						// ���ַ���ת��Ϊ��д
		}
	}

