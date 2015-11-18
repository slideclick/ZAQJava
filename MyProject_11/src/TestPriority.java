import java.util.Date;
	public class TestPriority {
		public static void main(String[] args) {
			Thread t1 = new Thread(new MyThread1());
			Thread t2 = new Thread(new MyThread2());
			t2.setPriority(Thread.MAX_PRIORITY);			// �����̶߳���t2Ϊ��߼�
			t1.start();									// �����߳�t1
			t2.start();
		}
	}
	class MyThread1 extends Thread {						// ͨ���̳�Thread���������߳���
		public void run() {
			//*******��ȡ�̵߳����ȼ�***********
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
