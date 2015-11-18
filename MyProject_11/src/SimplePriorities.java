import java.util.concurrent.*;
	public class SimplePriorities implements Runnable {
		private int countDown = 5;
		private volatile double d; 
		private int priority;
		public SimplePriorities(int priority) {
			this.priority = priority;
		}
		public String toString() {
			return Thread.currentThread() + ": " + countDown;
		}
		public void run() {
			Thread.currentThread().setPriority(priority);					// 设置线程的优先级
			while (true) {
				for (int i = 1; i < 100000; i++) {
					d += (Math.PI + Math.E) / (double) i;
					if (i % 1000 == 0)
					Thread.yield();								// 线程让步
				}
				System.out.println(this);
				if (--countDown == 0)
					return;
			}
		}
		public static void main(String[] args) {
			ExecutorService exec = Executors.newCachedThreadPool();
			for (int i = 0; i < 5; i++)
				exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));	// 最低优先级
			exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));	// 最高优先级
			exec.shutdown();
		}
	}
