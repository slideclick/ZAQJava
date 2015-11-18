package org.concurrency.collation;
	public class TimerTask implements Task {
		private static int count = 0;				// �̸߳���
		private int num = count;				// �߳����
		public TimerTask() {
			count++;
		}
		public void execute() {
			System.out.println("[TimerTask " + num + "] start...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("[TimerTask " + num + "] done.");
		}
	}
