public class SimpleDaemons implements Runnable {
		int i = 0;
		public void run() {
			try {
				while (i < 10) {
					i++;
					System.out.println(Thread.currentThread());
				}
			} catch (Exception e) {
				System.out.println("sleep() interrupted");
			}
		}
		public static void main(String[] args) throws Exception {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);				// ��daemon�߳�����Ϊ��̨�߳�
			daemon.start();						// ������̨�߳�
			System.out.println("main end");
		}
	}

