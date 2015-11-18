package org.iostream;
	import java.io.*;
	public class ComputeSum {
	public static void main(String[] args) throws Exception {
			BufferedReader kr = new BufferedReader(new InputStreamReader(System.in));
			// 键盘转换成一个能读取文本行的字符输入流
			String s;
			int n = 0;
			int sum = 0, k = 0;
			System.out.println("请输入一个整数值：");
			s = kr.readLine(); 					// 从键盘读取一行
			n = Integer.parseInt(s); 				// 转换成整数值
			for (k = 1; k <= n; k++)
				sum = sum + k;
			System.out.println(" 1 + 2 + … +  " + n + "= " + sum);
		}
	}
