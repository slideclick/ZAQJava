class StaticDemo {
		static int m = 10;								// 静态变量
		static int n;
		static void method(int a){						// 静态方法
			System.out.println("a = " + a);
			System.out.println("m = " + m);
			System.out.println("n = " + n);
		}
		static {									// 静态代码块
			System.out.println("static block  is initialized.");
			n = m * 4;
		}
		public static void main(String args[]) {
			method(42);
		}
	}
