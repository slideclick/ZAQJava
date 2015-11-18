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
			List<String> list = showList("one parameter:","A");			// 传递1个参数
			System.out.println(list);
			list = showList("three parameters:" ,"A", "B", "C");			// 传递3个参数
			System.out.println(list);
			list = showList( "more parameters:","ABCDEF".split(""));	// 传递多个参数
			System.out.println(list);
		}
	}

