package org.overload;
class Teacher {
		Teacher(int i) {
			this("doctor");							// �ڹ��췽����λ�ڵ�һ�����
			int yearsTraining = i;
			System.out.println("The teacher teaches  " + i + " years ");
		}
		Teacher(String s) {
			String degree = s;
			System.out.println("The teacher's degree  is " + s );
		}	
		void teach() {
			System.out.println("teacher teaches very good!");
		}
	}
	public class OverloadedConstructors {	
		public static void main(String[] args) {
			new Teacher(8).teach();		
		}		
	}
