package org.iostream;
	import java.io.*;
	public class GetPrimeToFile {
		public static void main(String arg[]) throws IOException {
			int a, b, c, count = 0, m, p;
			boolean flag;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("������a��ֵ��");
			a = Integer.parseInt(in.readLine());
			System.out.println("������b��ֵ��");
			b = Integer.parseInt(in.readLine());
			System.out.println("������c��ֵ��");
			c = Integer.parseInt(in.readLine());
			System.out.println("������Ҫ������ļ�����");
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
			out.write("\r\n����" + count + "������");
			out.close();
			System.out.println("�����");
		}
	}

