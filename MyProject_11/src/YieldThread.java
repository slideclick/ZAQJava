public class YieldThread extends Thread {
		public void run() {
			for (int i = 1; i <= 10; i++) {
				System.out.println(currentThread().getName() + " " );
				yield(); 			// ��ʱ����CPU ���������߳����еĻ��ᡣ
			}
		}
		public static void main(String[] args) {
			YieldThread m1 = new YieldThread();
			YieldThread m2 = new YieldThread();
			m1.start();
			m2.start();
		}
	}

