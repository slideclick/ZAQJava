package org.concurrency.collation;
	import java.util.*;
	public class ThreadPool extends ThreadGroup {
		private List threads = new LinkedList();
		private TaskQueue queue;
		public ThreadPool(TaskQueue queue) {
			super("Thread-Pool");
			this.queue = queue;
		}
		/********启动一个新的线程****************************/
		public synchronized void addWorkerThread() {
			Thread t = new WorkerThread(this, queue);
			threads.add(t);
			t.start();									// 启动线程
		}
		public synchronized void removeWorkerThread() {
			if (threads.size() > 0) {
				WorkerThread t = (WorkerThread) threads.remove(0);
				t.shutdown();							// 安全关闭线程
			}
		}
		/**********线程当前状态******************************/
		public synchronized void currentStatus() {
			System.out.println("-----------------------------------------------");
			System.out.println("Thread count = " + threads.size());
			Iterator it = threads.iterator();					// 返回一个迭带器
			while (it.hasNext()) {
				WorkerThread t = (WorkerThread) it.next();
				System.out.println(t.getName() + ": "+ (t.isIdle() ? "idle" : "busy"));
			}
			System.out.println("-----------------------------------------------");
		}
	}

