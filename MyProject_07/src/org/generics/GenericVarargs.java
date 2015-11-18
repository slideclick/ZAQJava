package org.generics;
	import java.util.*;
	public class GenericVarargs {
		public static <T> List<T> showList(String a,T... args) {
			System.out.print(a);
			ArrayList<T> list = new ArrayList<T>();
			for(T item : args)
				list.add(item);
			return list;
		}
		public static void main(String[] args) {
			List<String> list = showList("one parameter:","A");			// ����1������
			System.out.println(list);
			list = showList("three parameters:" ,"A", "B", "C");			// ����3������
			System.out.println(list);
			list = showList( "more parameters:","ABCDEF".split(""));	// ���ݶ������
			System.out.println(list);
		}
	}

