public class Test  {
		public static void main(String args[]) throws Exception {
			JoinTest jt = new JoinTest();
			jt.setName("JoinTest:");
			jt.start();							// 启动JoinTest线程
			System.out.println("main start");
			System.out.println(Thread.currentThread().getName());	// 获取正在运行的线程名
			jt.join(); 							// 主线程等待JoinTest线程运行结束
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
