package org.container;
	import java.util.*;
public class LinkedListTest {
	public static void main(String[] args) {
		Random rand =new Random(49);                      
		LinkedList<String> list =new LinkedList<String>();										list.add(new String("rat"));
		list.add(new String("monkey")); 
		list.add(new String("pig"));
		list.add(new String("rabbit"));
		System.out.println("list:"+list);
		System.out.println("list.getFirst():"+list.getFirst());
		System.out.println("list.element():"+list.element());
		System.out.println("list.peek():"+list.peek());
		System.out.println("list.remove:"+list.remove());
		System.out.println("list.removeFirst():"+list.removeFirst());
		System.out.println("list.poll():"+list.poll());
		System.out.println("List:"+list);
		list.addFirst(new String("mouse"));
		System.out.println("After addFirst():"+list);
		list.offer(new String("dog"));
		System.out.println("After offer():"+list);
		list.add(new String("rabbit"));
		System.out.println("After add():"+list);
		list.addLast(new String("goat"));
		System.out.println("After addLast():"+list);
		System.out.println("list.removeLast():"+list.removeLast());
		System.out.println("After removeLast():"+list);
		}
	}

