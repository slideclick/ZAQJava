package org.arrays;
	import java.util.Arrays;
	import java.util.Random;
	public class ArraySortTest {
		public static void main(String[] args){
			Random r = new Random();
			int[] a = new int[10];
			System.out.println("����ǰ: ");
			for (int i=0;i<10;i++){
				a[i] = r.nextInt(100);
				System.out.print(a[i]+"   ");
			}
			System.out.println();
			Arrays.sort(a);								// ��������
			System.out.println("�����: ");
			for (int i=9;i>=0;i--){
				System.out.print(a[i]+"   ");
			}
		}
	}

