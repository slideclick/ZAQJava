package org.annotations;
	import java.util.*;
	public class SuppressWarningsTest {
		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
			Map map = new TreeMap();
			map.put("hello", new Date());
			System.out.println(map.get("hello"));
			List list = new ArrayList();
			list.add("annotation");
			System.out.println(list);
		}
	}

