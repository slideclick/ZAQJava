package org.annotations;
	public class DeprecatedTest extends Service {
		@Override
		public void doSomething() {
			System.out.println("do something in DeprecatedTest class");
		}
		public static void main(String[] args) {
			DeprecatedTest sub = new DeprecatedTest();
			sub.doSomething();
		}
	}
	class Service {
		@Deprecated
		public void doSomething() {
			System.out.println("do something");
		}
	public static void main(String[] args) {
			Service test = new Service();
			//test.doSomething();
		}
	}

