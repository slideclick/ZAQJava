package org.generics;
	import java.util.Arrays;
	public class GenericArray<T> {
		private Object[] array;
		public GenericArray(int index) {
			array = new Object[index];
		}
		public void put(int index, T item) {
			array[index] = item;
		}
		//抑制警告
		@SuppressWarnings("unchecked")			
		public T get(int index) {
			return (T) array[index];
		}
		@SuppressWarnings("unchecked")
		public T[] mat() {
			return (T[]) array; 
		}
		public static void main(String[] args) {
			GenericArray<Integer> ga = new GenericArray<Integer>(10);
			for (int i = 0; i < 10; i++)
				ga.put(i, i);									// 向容器中放入元素
			for (int i = 0; i < 10; i++)
				System.out.print(ga.get(i) + " ");					// 取出容器中的元素
			System.out.println();
			try {
				Object[] arr = ga.mat();
				System.out.println(Arrays.toString(arr));		// 返回此数组内容的字符串表示形式
				Integer[] arr1 = ga.mat();				// 类型转换异常
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

