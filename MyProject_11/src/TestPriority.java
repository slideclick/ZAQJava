import java.util.Date;
	public class TestPriority {
		public static void main(String[] args) {
			Thread t1 = new Thread(new MyThread1());
			Thread t2 = new Thread(new MyThread2());
			t2.setPriority(Thread.MAX_PRIORITY);			// 设置线程对象t2为最高级
			t1.start();									// 启动线程t1
			t2.start();
		}
	}
	class MyThread1 extends Thread {						// 通过继承Thread类来创建线程类
		public void run() {
			//*******获取线程的优先级***********
			for (int i = 0; i < 10; i++) {
				System.out.println(currentThread().getName() + ":"+currentThread().getPriority());
			}
		}
	}
	class MyThread2 extends Thread {
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(currentThread().getName() + ":"+currentThread().getPriority());
			}
		}
	}
