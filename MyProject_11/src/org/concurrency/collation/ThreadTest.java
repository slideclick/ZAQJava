package org.concurrency.collation;
	public class ThreadTest {
		public static void main(String[] args) {
			TaskQueue queue = new TaskQueue();
			ThreadPool pool = new ThreadPool(queue);
			for (int i = 0; i < 10; i++) {
				queue.putTask(new CalculateTask());
				queue.putTask(new TimerTask());
			}
			pool.addWorkerThread();						// 加入线程池中
			pool.addWorkerThread();
			doSleep(8000);								// 睡眠一段时间
			pool.currentStatus();							// 获取线程池的当前状态
		}
		private static void doSleep(long ms) {
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
