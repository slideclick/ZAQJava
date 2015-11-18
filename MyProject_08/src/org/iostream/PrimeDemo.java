package org.iostream;
import java.io.*;
import java.util.regex.*;
public class PrimeDemo{
	BufferedWriter bw =null;
	String filename = "e:/workbench/MyProject_08/src/org/iostream/t20.txt";
	static int s,p,t;
	static long num;										//一行质数之和
	boolean isPrime(int n) { 								//判断是否是质数
		for (int i = 2; i <= n / 2; i++)
			if (n % i == 0)
				return false;
		return true;
	}
	void printPrime(int m,int n) throws IOException {
		bw = new BufferedWriter(new FileWriter(filename));
		int j = 0;
		for (int i = m; i <= n; i++){
			if (isPrime(i)){
				j++;
				if(j%t==0){
					System.out.print(" " + i);
					System.out.print(" " +num);
					System.out.println();
					num=num+i;
					String s= String.valueOf(i);
					String s1 = s +"  ";
					String s2 = String.valueOf(num);
					bw.write(s1);
					bw.write(s2);
					bw.newLine();							// 写入一个行分隔符
					num =0;
				}
				else {
					String s= String.valueOf(i);
					String s3 = s + "  ";
					bw.write(s3);
					num = num+i;
					System.out.print(" " + i);
				}
			}
		}
		String s4 = String.valueOf(num);					// 最后不足k个质数的一行的累加和也写入到文本文件中
		System.out.println(" "+num);
		bw.write(s4);
		bw.flush();											// 强制刷新流
		bw.close();
	}
	public static void main(String[] args) throws IOException {
		PrimeDemo pn = new PrimeDemo();
		int[] arr = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		String s1;
		while ((s1 = br.readLine()) != null && s1.length() != 0){
			Pattern p1 = Pattern.compile("(\\d{1,3})");		// 编译正则表达式，要求1个到3个数字
			Matcher m = p1.matcher(s1);						// 对字符串进行匹配
			int i =0;
			while(m.find()) {								// 寻找与指定模式匹配的下一个子序列
				int j = 0;
				j = Integer.parseInt(m.group());			// 将字符串类型转换为整型
				arr[i]= j;
				i++;
			}
			p = arr[0];										// 区间整数的起始位置
			s = arr[1];										// 区间整数的结束位置
			t = arr[2];										// 每一行的质数个数
			pn.printPrime(p,s); 							// 打印出100 之内的所有质数
		}
	}
}

