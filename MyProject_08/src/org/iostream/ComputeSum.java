package org.iostream;
	import java.io.*;
	public class ComputeSum {
	public static void main(String[] args) throws Exception {
			BufferedReader kr = new BufferedReader(new InputStreamReader(System.in));
			// ����ת����һ���ܶ�ȡ�ı��е��ַ�������
			String s;
			int n = 0;
			int sum = 0, k = 0;
			System.out.println("������һ������ֵ��");
			s = kr.readLine(); 					// �Ӽ��̶�ȡһ��
			n = Integer.parseInt(s); 				// ת��������ֵ
			for (k = 1; k <= n; k++)
				sum = sum + k;
			System.out.println(" 1 + 2 + �� +  " + n + "= " + sum);
		}
	}
