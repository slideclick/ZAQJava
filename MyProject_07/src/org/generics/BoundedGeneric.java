package org.generics;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.LinkedList;
	import java.util.List;
	public class BoundedGeneric<T extends List> {
		private T Array;
		public void setArray(T Array) {
			this.Array =Array;
		}
		public T getArray() {
			return Array;
		}
		public static void main(String[] args) {
			BoundedGeneric<LinkedList> generic1 = new BoundedGeneric<LinkedList>();
			BoundedGeneric<ArrayList> generic2 = new BoundedGeneric<ArrayList>();
			LinkedList linkedList = new LinkedList(Arrays.asList(1,2,3,4,5));
			generic1.setArray(linkedList);
			generic1.getArray().push(6);
			System.out.println(generic1.getArray());
			generic1.getArray().poll();
			System.out.println(generic1.getArray());
			//generic1.getArray().trimToSize();				// LinkedList类没有此方法
			ArrayList arrayList = new ArrayList(Arrays.asList(1,2,3,4,5));
			generic2.setArray(arrayList);
			generic2.getArray().add(6);
			System.out.println(generic2.getArray());
			generic2.getArray().set(1, 9);
			System.out.println(generic2.getArray());
			//generic2.getArray().poll();						// ArrayList类没有此方法
			generic2.getArray().trimToSize();
		}
	}

