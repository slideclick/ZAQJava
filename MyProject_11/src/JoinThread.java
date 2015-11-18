public class JoinThread {
		public static void main(String[] args) {
			MyThread4 mt = new MyThread4();
			mt.start();
			try {
				mt.join();					// 挂起主线程，等待客户线程执行结束
			} catch (InterruptedException e) {
			}
			for (int i = 1; i <= 5; i++) {
				System.out.println("main Thread ");
			}
		}
	}
	class MyThread4 extends Thread {
		public void run() {
			for (int i = 1; i <= 5; i++) {
				System.out.println(currentThread().getName());
			}
		}
	}
