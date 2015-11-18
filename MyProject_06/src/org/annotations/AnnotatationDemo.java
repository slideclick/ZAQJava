package org.annotations;
	public class AnnotatationDemo extends Student{
		@Override							// 内置注解
		public void studying() {				// 重写父类的studying()方法
			System.out.println("student must studying hard!");
		}
		public static void main(String[] args) {
			AnnotatationDemo sub = new AnnotatationDemo();
			sub.studying();
		}
	}
	class Student {
		@Deprecated
		public void studying() {
			System.out.println("studying");
		}
		public static void main(String[] args) {
			Student test = new Student();
			test.studying();
		}
	}

