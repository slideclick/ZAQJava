public class Test  {
		public static void main(String args[]) throws Exception {
			JoinTest jt = new JoinTest();
			jt.setName("JoinTest:");
			jt.start();							// ����JoinTest�߳�
			System.out.println("main start");
			System.out.println(Thread.currentThread().getName());	// ��ȡ�������е��߳���
			jt.join(); 							// ���̵߳ȴ�JoinTest�߳����н���
			System.out.println("main end");
		}
	}
	class JoinTest extends Thread {
		public void run() {
			for (int i = 0; i < 10; i++){
				System.out.println(Thread.currentThread().getName()+i);
			}
		}
	}
