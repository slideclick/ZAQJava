package org.concurrency.expansion;
	public class TestThread1 {
		public static void main(String args[]) {
			MyThread1 mt = new MyThread1();
			Thread t = new Thread(mt);					// �����û��߳�
			t.start();								// �����û��߳�
			for (int a = 0; a < 10; a++) {
				System.out.println(Thread.currentThread().getName() + ":" + a);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}	
	}
	class MyThread1 implements Runnable {				// ͨ��ʵ��Runnable�ӿ��������߳�
		public void run() {
			for (int a = 0; a < 10; a++) {
				System.out.println(Thread.currentThread().getName() + ":" + a);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

