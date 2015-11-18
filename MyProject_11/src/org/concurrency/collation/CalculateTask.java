package org.concurrency.collation;
	public class CalculateTask implements Task {
		private static int count = 0;				// 线程个数
		private int num = count;				// 线程序号
		public CalculateTask() {
			count++;
		}
		public void execute() {
			System.out.println("[CalculateTask " + num + "] start...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ie) {
			}
			System.out.println("[CalculateTask " + num + "] done.");
		}
	}

