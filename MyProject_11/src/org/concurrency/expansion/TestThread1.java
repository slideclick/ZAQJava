package org.concurrency.expansion;
	public class TestThread1 {
		public static void main(String args[]) {
			MyThread1 mt = new MyThread1();
			Thread t = new Thread(mt);					// 创建用户线程
			t.start();								// 启动用户线程
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
	class MyThread1 implements Runnable {				// 通过实现Runnable接口来创建线程
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

