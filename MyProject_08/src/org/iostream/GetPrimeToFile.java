package org.iostream;
	import java.io.*;
	public class GetPrimeToFile {
		public static void main(String arg[]) throws IOException {
			int a, b, c, count = 0, m, p;
			boolean flag;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入a的值：");
			a = Integer.parseInt(in.readLine());
			System.out.println("请输入b的值：");
			b = Integer.parseInt(in.readLine());
			System.out.println("请输入c的值：");
			c = Integer.parseInt(in.readLine());
			System.out.println("请输入要保存的文件名：");
			FileWriter out = new FileWriter(in.readLine());
			for (m = a; m <= b; m++) {
				flag = true;
				for (p = 2; p < m / 2; p++)
					if (m % p == 0) {
						flag = false;
						break;
					}
				if (flag) {
					count++;
					out.write(m + "\t");
					if (count % c == 0)
						out.write("\r\n");
				}
			}
			out.write("\r\n共有" + count + "个素数");
			out.close();
			System.out.println("已完成");
		}
	}

