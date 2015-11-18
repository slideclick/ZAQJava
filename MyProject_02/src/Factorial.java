public class Factorial {
		static int F(int n) {
			return n == 0 ? 1 : n * F(n - 1);
		}
		public static void main(String[] args) {
			System.out.println("10!ÊÇ£º" + F(10));
		}
	}

