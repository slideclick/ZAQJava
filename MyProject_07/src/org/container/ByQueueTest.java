package org.container;
	import java.util.*;
	class ByQueue<T> {
		private LinkedList<T> queue = new LinkedList<T>();
		public void addFirst(T e) {					// 向队列的头部加入元素
			queue.addFirst(e);
		}
		public void addLast(T e) {					// 向队列的尾部加入元素
			queue.addLast(e);
		}
		public T getFirst() {						// 返回队列的头部元素
			return queue.getFirst();
		}
		public T getLast() {						// 返回队列的尾部元素
			return queue.getLast();
		}
		public T removeFirst() {					// 移去并返回队列的头元素
			return queue.removeFirst();
		}
		public T removeLast() {					// 移去并返回队列的尾元素
			return queue.removeLast();
		}
		public int size() {						// 返回队列的元素数
			return queue.size();
		}
		public String toString() {
			return queue.toString();
		}
	}

	public class ByQueueTest {
		static void fillElement(ByQueue<Integer> queue) {
			for (int i = 1; i < 7; i++)
				queue.addFirst(i);				// 在队列的头部加入元素
			for (int i = 20; i < 25; i++)
				queue.addLast(i);				// 在队列的尾部加入元素
		}
		public static void main(String[] args) {
			ByQueue<Integer> q = new ByQueue<Integer>();
			fillElement(q);
			System.out.print(q);
			System.out.println();
			while (q.size() != 0)
				System.out.print(q.removeFirst() + " ");	// 在队列的头部移去元素
			System.out.println();
			fillElement(q);
			while (q.size() != 0)
				System.out.print(q.removeLast() + " ");	// 在队列的尾部移去元素
		}
	}

