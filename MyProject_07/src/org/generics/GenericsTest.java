	package org.generics;
	import java.util.*;
	public class GenericsTest<T> {
		private T value;
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public static void main(String[] args) {
			GenericsTest<? extends Map> gen = null;
			gen = new GenericsTest<TreeMap>();
			gen = new GenericsTest<HashMap>();
			//gen = new GenericTest<ArrayList>();			// ����Map��������
			GenericsTest<? super LinkedHashMap> gen2 = null;
			gen2 = new GenericsTest<HashMap>();			// HashMap��LinkedHashMap�ĸ���
			GenericsTest<String> gen3 = new GenericsTest<String>();
			gen3.setValue("java generic test");
			System.out.println(gen3.getValue());
			GenericsTest<? extends Object> gen4 = gen3;
			System.out.println(gen4.getValue());
			gen4.setValue(null);
			System.out.println(gen4.getValue());
			//gen4.setValue("hello");					// ���ܼ�����Ϣ
		}
	}


