package org.concurrency.expansion;
	class MyThread extends Thread {
		private int a = 0;
		public void run() {
			for (int a = 0; a < 10; a++) {
				System.out.println(currentThread().getName() + ":" + a);
				try {
					sleep(100);					 	// �������߳����еĻ���
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	public class TestThread {
		public static void main(String[] args) {
			MyThread thread = new MyThread(); 			// �����û��̶߳���
			thread.start();			 				// �����û��߳�
			thread.run(); 							// ���̵߳����û��̶߳����run()����
		}
	}

