package org.concurrency.collation;
	public class ThreadTest {
		public static void main(String[] args) {
			TaskQueue queue = new TaskQueue();
			ThreadPool pool = new ThreadPool(queue);
			for (int i = 0; i < 10; i++) {
				queue.putTask(new CalculateTask());
				queue.putTask(new TimerTask());
			}
			pool.addWorkerThread();						// �����̳߳���
			pool.addWorkerThread();
			doSleep(8000);								// ˯��һ��ʱ��
			pool.currentStatus();							// ��ȡ�̳߳صĵ�ǰ״̬
		}
		private static void doSleep(long ms) {
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
