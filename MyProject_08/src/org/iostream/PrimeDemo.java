package org.iostream;
import java.io.*;
import java.util.regex.*;
public class PrimeDemo{
	BufferedWriter bw =null;
	String filename = "e:/workbench/MyProject_08/src/org/iostream/t20.txt";
	static int s,p,t;
	static long num;										//һ������֮��
	boolean isPrime(int n) { 								//�ж��Ƿ�������
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
					bw.newLine();							// д��һ���зָ���
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
		String s4 = String.valueOf(num);					// �����k��������һ�е��ۼӺ�Ҳд�뵽�ı��ļ���
		System.out.println(" "+num);
		bw.write(s4);
		bw.flush();											// ǿ��ˢ����
		bw.close();
	}
	public static void main(String[] args) throws IOException {
		PrimeDemo pn = new PrimeDemo();
		int[] arr = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		String s1;
		while ((s1 = br.readLine()) != null && s1.length() != 0){
			Pattern p1 = Pattern.compile("(\\d{1,3})");		// ����������ʽ��Ҫ��1����3������
			Matcher m = p1.matcher(s1);						// ���ַ�������ƥ��
			int i =0;
			while(m.find()) {								// Ѱ����ָ��ģʽƥ�����һ��������
				int j = 0;
				j = Integer.parseInt(m.group());			// ���ַ�������ת��Ϊ����
				arr[i]= j;
				i++;
			}
			p = arr[0];										// ������������ʼλ��
			s = arr[1];										// ���������Ľ���λ��
			t = arr[2];										// ÿһ�е���������
			pn.printPrime(p,s); 							// ��ӡ��100 ֮�ڵ���������
		}
	}
}

