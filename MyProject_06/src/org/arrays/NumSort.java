package org.arrays;
	public class NumSort {
		public static void main(String[] args) {
			int[] a = new int[args.length];					
			for (int i=0; i<args.length; i++) {				// 获取命令行参数的长度
				a[i] = Integer.parseInt(args[i]);			// 把字符串转换为整形
			}
			System.out.println("排序前：");
			print(a);
			selectionSort(a);
			System.out.println("排序后：");
			print(a);
		}
		private static void selectionSort(int[] a) {			// 排序
			int k, temp;
			for(int i=0; i<a.length; i++) {
				k = i;
				for(int j=k+1; j<a.length; j++) {			
					if(a[j] < a[k]) {
						k = j;
					}
				}
				if(k != i) {
					temp = a[i];
					a[i] = a[k];
					a[k] = temp;
				}
			}
		}	
		private static void print(int[] a) {
			for(int i=0; i<a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
	}
