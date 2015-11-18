class Parent {
		private final void method1() {				// ����method1()����Ϊfinal����
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
			System.out.println("Son.method1()");		// �������ж���һ��method1()����
		}
		// final void method2() {					// final�������ܱ���д
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
			Parent p = s; 						// ִ������ת�Ͳ���
			// p.method1(); 						// ���ܵ���private����
			p.method2();
			p.method3();
		}
	}

