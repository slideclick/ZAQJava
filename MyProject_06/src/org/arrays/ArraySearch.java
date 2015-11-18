package org.arrays;
	import java.util.Scanner;
	import java.util.Arrays;
	public class ArraySearch {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);			// 从控制台获取要检索的值
			int[] array = { 23, 4, 6, 21, 60, 99, 42, 69, 53, 36 };
			System.out.println("排序前: ");
			for (int i = 0; i < array.length; i++)
				System.out.print(array[i] + " ");
			System.out.println();
			Arrays.sort(array); 							// 数组排序
			System.out.println("排序后: ");
			for (int i = 0; i < array.length; i++)
				System.out.print(array[i] + " ");
			System.out.println("\n请输入查找值: ");
			int key = scanner.nextInt();
			int find = -1;
			if ((find = Arrays.binarySearch(array, key)) > -1) {
				System.out.println("找到值于索引 " + find + " 位置");
			} else
				System.out.println("找不到指定值");
		}
	}
