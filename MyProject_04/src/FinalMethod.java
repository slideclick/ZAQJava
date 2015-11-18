class Parent {
		private final void method1() {				// 定义method1()方法为final方法
			System.out.println("Parent.method1()");
		}
		final void method2() {
			System.out.println("Parent.method2()");
		}
		public void method3() {
			System.out.println("Parent.method3()");
		}
	}
	class Son extends Parent {
		public final void method1() {
			System.out.println("Son.method1()");		// 在子类中定义一个method1()方法
		}
		// final void method2() {					// final方法不能被重写
		//     System.out.println("Son.method2()");
		// }
		public void method3() {
			System.out.println("Son.method3()");
		}
	}
	public class FinalMethod {
		public static void main(String[] args) {
			Son s = new Son();
			s.method1(); 
			Parent p = s; 						// 执行向上转型操作
			// p.method1(); 						// 不能调用private方法
			p.method2();
			p.method3();
		}
	}

