package org.concurrency.collation;
	import java.util.*;
	public class TaskQueue {
		private List queue = new LinkedList();					// ��������
		//********�Ӷ�����ȡ�����񲢴Ӷ������Ƴ�������*********
		public synchronized Task getTask() {							
			while (queue.size() == 0) {
				try {
					this.wait();							// �ȴ��ͻ����µ�����
				} catch (InterruptedException e) {
					e.printStackTrace();
					return null;
				}
			}
			return (Task) queue.remove(0);					// �Ƴ���ǰ����
		}
		//*********�ѵ�ǰ��������������**********
		public synchronized void putTask(Task task) {													queue.add(task);
			this.notifyAll();								// �ȴ�����������
		}
	}
