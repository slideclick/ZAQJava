package org.container;
	import java.util.*;
	class ByQueue<T> {
		private LinkedList<T> queue = new LinkedList<T>();
		public void addFirst(T e) {					// ����е�ͷ������Ԫ��
			queue.addFirst(e);
		}
		public void addLast(T e) {					// ����е�β������Ԫ��
			queue.addLast(e);
		}
		public T getFirst() {						// ���ض��е�ͷ��Ԫ��
			return queue.getFirst();
		}
		public T getLast() {						// ���ض��е�β��Ԫ��
			return queue.getLast();
		}
		public T removeFirst() {					// ��ȥ�����ض��е�ͷԪ��
			return queue.removeFirst();
		}
		public T removeLast() {					// ��ȥ�����ض��е�βԪ��
			return queue.removeLast();
		}
		public int size() {						// ���ض��е�Ԫ����
			return queue.size();
		}
		public String toString() {
			return queue.toString();
		}
	}

	public class ByQueueTest {
		static void fillElement(ByQueue<Integer> queue) {
			for (int i = 1; i < 7; i++)
				queue.addFirst(i);				// �ڶ��е�ͷ������Ԫ��
			for (int i = 20; i < 25; i++)
				queue.addLast(i);				// �ڶ��е�β������Ԫ��
		}
		public static void main(String[] args) {
			ByQueue<Integer> q = new ByQueue<Integer>();
			fillElement(q);
			System.out.print(q);
			System.out.println();
			while (q.size() != 0)
				System.out.print(q.removeFirst() + " ");	// �ڶ��е�ͷ����ȥԪ��
			System.out.println();
			fillElement(q);
			while (q.size() != 0)
				System.out.print(q.removeLast() + " ");	// �ڶ��е�β����ȥԪ��
		}
	}

