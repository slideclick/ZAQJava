package org.container;
	import java.util.*;
	public class UseCollections {
		public static void printAny(Collection c) {
			Iterator it = c.iterator();					// 返回一个迭代器
			while(it.hasNext())
				System.out.print(it.next() + " ");
			System.out.println();
		}
		public static void main(String[] args) {
			ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1, 2, 3,4,5));
			LinkedList<Character> ll =new LinkedList<Character>(Arrays.asList('a', 'b', 'c','d','e'));	
			HashSet<Float> hs = new HashSet<Float>(Arrays.asList(10.1f, 20.2f, 30.3f, 40.3f,50.3f));
			TreeSet<Double> ts =new TreeSet<Double>(Arrays.asList(1.34, 2.34, 3.34,4.34,5.34));
			LinkedHashSet<Integer> lhs =new LinkedHashSet<Integer>(Arrays.asList(10, 20, 30,40,50));
			printAny(al);
			printAny(ll);
			printAny(hs);
			printAny(ts);
			printAny(lhs);
		}
	}
