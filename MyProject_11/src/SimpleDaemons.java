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
			daemon.setDaemon(true);				// 将daemon线程设置为后台线程
			daemon.start();						// 启动后台线程
			System.out.println("main end");
		}
	}

