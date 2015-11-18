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
		//*******��ȫ�����߳�*********************
		public void shutdown() {
			stop = true;
			this.interrupt();								// �ж��߳�
			try {
				this.join();								// �ȴ����߳̽���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		public boolean isIdle() {							// �ж��Ƿ�æ
			return !busy;
		}
		public void run() {
			System.out.println(getName() + " start.");
			while (!stop) {
				Task task = queue.getTask();					// �Ӷ�����ȡ��һ��һ������
				if (task != null) {
					busy = true;
					task.execute();						// ִ������
					busy = false;
				}
			}
			System.out.println(getName() + " end.");
		}
	}

