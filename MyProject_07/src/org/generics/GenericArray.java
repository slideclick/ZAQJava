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
		//���ƾ���
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
				ga.put(i, i);									// �������з���Ԫ��
			for (int i = 0; i < 10; i++)
				System.out.print(ga.get(i) + " ");					// ȡ�������е�Ԫ��
			System.out.println();
			try {
				Object[] arr = ga.mat();
				System.out.println(Arrays.toString(arr));		// ���ش��������ݵ��ַ�����ʾ��ʽ
				Integer[] arr1 = ga.mat();				// ����ת���쳣
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

