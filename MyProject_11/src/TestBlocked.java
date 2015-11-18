import java.util.*;
	public class TestBlocked {
		public static void main(String[] args) {
			MyThread thread = new MyThread();
			thread.start();
			try {
				Thread.sleep(10000);					// 主线程睡眠10秒
			} catch (InterruptedException e) {
			}
			thread.interrupt();						// 中断客户线程
		}
	}
	class MyThread extends Thread {
		boolean flag = true;
		public void run() {
			while (flag) {
				System.out.println("...." + new Date() + "...");
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}

