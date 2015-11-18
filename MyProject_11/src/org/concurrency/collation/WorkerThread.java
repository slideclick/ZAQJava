package org.concurrency.collation;
	public class WorkerThread extends Thread {
		private static int count = 0;
		private boolean busy = false;
		private boolean stop = false;
		private TaskQueue queue;
		public WorkerThread(ThreadGroup group, TaskQueue queue) {
			super(group, "worker-" + count);
			count++;
			this.queue = queue;
		}
		//*******安全结束线程*********************
		public void shutdown() {
			stop = true;
			this.interrupt();								// 中断线程
			try {
				this.join();								// 等待该线程结束
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		public boolean isIdle() {							// 判断是否忙
			return !busy;
		}
		public void run() {
			System.out.println(getName() + " start.");
			while (!stop) {
				Task task = queue.getTask();					// 从队列中取出一个一个任务
				if (task != null) {
					busy = true;
					task.execute();						// 执行任务
					busy = false;
				}
			}
			System.out.println(getName() + " end.");
		}
	}

