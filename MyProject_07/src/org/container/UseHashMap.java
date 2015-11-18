package org.container;
	import java.util.*;
	class Season {
		private int num;
		public Season(int i) {
			num = i;
		}
	}
	public class UseHashMap {
		public static void main(String[] args) {
			Map<String, Season> map = new HashMap<String, Season>();
			map.put("Spring", new Season(1));						// 加入元素到HashMap中
			map.put("Summer", new Season(2));
			map.put("Autumn", new Season(3));
			map.put("Winter", new Season(4));
			Set<String> sortedKeys = new TreeSet<String>(map.keySet());		// 排序
			System.out.println(sortedKeys);
			System.out.println();
			Map<String, Season> sorted = new HashMap<String, Season>();
			for(String s : sortedKeys) {
				System.out.print("Adding " + s + ", ");
				sorted.put(s, map.get(s));			
			}
		}
	}

