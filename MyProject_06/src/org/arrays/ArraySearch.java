package org.arrays;
	import java.util.Scanner;
	import java.util.Arrays;
	public class ArraySearch {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);			// �ӿ���̨��ȡҪ������ֵ
			int[] array = { 23, 4, 6, 21, 60, 99, 42, 69, 53, 36 };
			System.out.println("����ǰ: ");
			for (int i = 0; i < array.length; i++)
				System.out.print(array[i] + " ");
			System.out.println();
			Arrays.sort(array); 							// ��������
			System.out.println("�����: ");
			for (int i = 0; i < array.length; i++)
				System.out.print(array[i] + " ");
			System.out.println("\n���������ֵ: ");
			int key = scanner.nextInt();
			int find = -1;
			if ((find = Arrays.binarySearch(array, key)) > -1) {
				System.out.println("�ҵ�ֵ������ " + find + " λ��");
			} else
				System.out.println("�Ҳ���ָ��ֵ");
		}
	}
