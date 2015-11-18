package org.overload;
class Teacher {
		Teacher(int i) {
			this("doctor");							// 在构造方法中位于第一条语句
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
