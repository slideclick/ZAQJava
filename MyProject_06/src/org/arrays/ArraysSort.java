package org.arrays;
	import java.util.Arrays;
	import java.util.Random;
	public class ArraysSort {
		public static void main(String[] args){
			Random r = new Random();
			int[] a = new int[10];
			System.out.println("排序前: ");
			for (int i=0;i<10;i++){
				a[i] = r.nextInt(100);					// 获取在0到100之间的整型随机数
				System.out.print(a[i]+" ");
			}
			System.out.println();
			Arrays.sort(a);							// 从小到大对数组进行排序
			System.out.println("排序后: ");
			for (int i=0;i<10;i++){
				System.out.print(a[i]+" ");
			}
		}
	}	

