package org.container;
	import java.util.*;
	public class SetTest {
		public static void main(String[] args) {
			HashSet<String> has = new HashSet<String>();
			has.add("Struts");
			has.add("Hibernate");
			has.add("Spring");
			has.add("Struts");						// ��HashSet�����м����ظ�Ԫ��
			Iterator it = has.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			TreeSet<Integer> ts = new TreeSet<Integer>();
			ts.add(3);
			ts.add(5);
			ts.add(9);
			ts.add(6);
			ts.add(3);								//��TreeSet�����м����ظ�Ԫ��
			Iterator it2 = ts.iterator();
			while(it2.hasNext()){
				System.out.println(it2.next());
			}
		}
	}

