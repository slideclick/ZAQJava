package org.annotations;
	public class AnnotatationDemo extends Student{
		@Override							// ����ע��
		public void studying() {				// ��д�����studying()����
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

