package org.extend;
class A {
			public void method1() {
				System.out.println("invoke A method1");
			}
			public void method2() {
				method1();
			}
		}
		class B extends A {
			public void method3() {
				System.out.println("invoke B method3");
			}
		}
		class C {
			public static void main(String[] args) {
				B b = new B();
				A a = b;								// 向上类型转换
				callA(a);
				callA(new B());
			}
			public static void callA(A a) {
				B b = (B) a;							// 强制类型转换
				b.method1();
				b.method2();
				b.method3();
			}
		}
