package org.iostream;
	import java.io.*;
	public class StandardIORedirect {
		public static void main(String[] args) throws IOException {
			PrintStream console = System.out;
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(
					"e:/workbench/MyProject_08/src/org/iostream/StandardIORedirect.java"));
			PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(
					"e:/workbench/MyProject_08/src/org/iostream/t10.txt")));
			System.setIn(in);							// 对标准输入流重定向
			System.setOut(out);
			System.setErr(out);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s;
			while ((s = br.readLine()) != null)				// 从BufferedReader类中读取一行数据
				System.out.println(s);					
			out.close(); 
			System.setOut(console);
		}
	}

