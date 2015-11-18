package org.container;
	import java.util.*;
	class StringAddress {
		private String s;
		public StringAddress(String s) {
			this.s = s;
		}
		public String toString() {
			return super.toString() + " " + s;
		}
	}
	public class CollectionsOfList {
		public static void main(String[] args) {
			// Collections.nCopies()方法返回由指定的4个StringAddress对象所组成的不可变列表
			List<StringAddress> list = new ArrayList<StringAddress>(Collections
					.nCopies(4, new StringAddress("Hello")));										System.out.println(list);
			Collections.fill(list, new StringAddress("World!"));
			System.out.println(list);
			List<String> list1 = Arrays.asList(new String[] { "spring", "summer","autumn", "winter" });
			Collections.sort(list1); 							// 把List中的元素自然排序
			System.out.println(Collections.max(list1)); 				// 显示winter
			System.out.println(Collections.min(list1)); 				// 显示automn
			System.out.println(Collections.binarySearch(list1, "spring")); 	// 显示1
			System.out.println(Arrays.toString(list1.toArray()));
			Collections.shuffle(list1); 						// 重新随机调整List中元素的位置
			System.out.println(Arrays.toString(list1.toArray())); 	// 随机显示
		}
	}

