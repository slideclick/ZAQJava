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
			// Collections.nCopies()����������ָ����4��StringAddress��������ɵĲ��ɱ��б�
			List<StringAddress> list = new ArrayList<StringAddress>(Collections
					.nCopies(4, new StringAddress("Hello")));										System.out.println(list);
			Collections.fill(list, new StringAddress("World!"));
			System.out.println(list);
			List<String> list1 = Arrays.asList(new String[] { "spring", "summer","autumn", "winter" });
			Collections.sort(list1); 							// ��List�е�Ԫ����Ȼ����
			System.out.println(Collections.max(list1)); 				// ��ʾwinter
			System.out.println(Collections.min(list1)); 				// ��ʾautomn
			System.out.println(Collections.binarySearch(list1, "spring")); 	// ��ʾ1
			System.out.println(Arrays.toString(list1.toArray()));
			Collections.shuffle(list1); 						// �����������List��Ԫ�ص�λ��
			System.out.println(Arrays.toString(list1.toArray())); 	// �����ʾ
		}
	}

