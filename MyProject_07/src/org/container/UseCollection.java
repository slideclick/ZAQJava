package org.container;
import java.util.*;
public class UseCollection {
		public static void main(String[] args) {
			Collection<String> collection = new ArrayList<String>(Arrays.asList(
					"A", "B", "C", "D", "E"));					// ��������	
			String[]strArray = { "F", "G", "H", "I", "J" };		
			collection.addAll(Arrays.asList(strArray));
			Collections.addAll(collection, "M", "N", "O", "P", "Q");
			System.out.println(collection);
			//���������е�ÿһ��Ԫ��
			for(Iterator it = collection.iterator();it.hasNext();){	
				System.out.print(it.next() + " ");
			}
			System.out.println();
			for (String i : collection) {
				System.out.print(i + " ");
			}
			System.out.println();
			collection.remove("A");							// �Ƴ�һ��Ԫ��
			for (String i : collection) {
				System.out.print(i + " ");
			}
			Collection<String> part = new ArrayList<String>(Arrays.asList(
					"B", "C", "D", "E"));
			System.out.println();
			collection.retainAll(part);							// ������ͬ��Ԫ��
			for (String str : collection) {
				System.out.print(str + " ");
			}
			System.out.println();
			Object[]o = collection.toArray();						// ����һ������
			System.out.println(Arrays.deepToString(o));
			collection.removeAll(collection);						// �Ƴ����е�Ԫ��
			System.out.println(collection.size());
		}
}

