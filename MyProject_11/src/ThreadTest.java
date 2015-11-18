class SimpleThread extends Thread {
		public SimpleThread(String str) {
			super(str);
		}
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(i + " " + getName());
				try {
					sleep((int) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public class ThreadTest {
		public static void main(String[] args) {
			new SimpleThread("first thread is running.").start();			// Æô¶¯Ïß³Ì
			new SimpleThread("second thread is running.").start();
		}
	}
