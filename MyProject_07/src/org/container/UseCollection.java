package org.container;
import java.util.*;
public class UseCollection {
		public static void main(String[] args) {
			Collection<String> collection = new ArrayList<String>(Arrays.asList(
					"A", "B", "C", "D", "E"));					// 创建容器	
			String[]strArray = { "F", "G", "H", "I", "J" };		
			collection.addAll(Arrays.asList(strArray));
			Collections.addAll(collection, "M", "N", "O", "P", "Q");
			System.out.println(collection);
			//迭代容器中的每一个元素
			for(Iterator it = collection.iterator();it.hasNext();){	
				System.out.print(it.next() + " ");
			}
			System.out.println();
			for (String i : collection) {
				System.out.print(i + " ");
			}
			System.out.println();
			collection.remove("A");							// 移除一个元素
			for (String i : collection) {
				System.out.print(i + " ");
			}
			Collection<String> part = new ArrayList<String>(Arrays.asList(
					"B", "C", "D", "E"));
			System.out.println();
			collection.retainAll(part);							// 保存相同的元素
			for (String str : collection) {
				System.out.print(str + " ");
			}
			System.out.println();
			Object[]o = collection.toArray();						// 返回一个数组
			System.out.println(Arrays.deepToString(o));
			collection.removeAll(collection);						// 移除所有的元素
			System.out.println(collection.size());
		}
}

