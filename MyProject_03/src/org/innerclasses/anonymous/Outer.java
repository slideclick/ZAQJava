package org.innerclasses.anonymous;
public class Outer {
		Outer(int v) {
			System.out.println("another constructor");
		}
		Outer() {
			System.out.println("default constructor");
		}
		void f() {
			System.out.println("from Outer");
		};
		public static void main(String args[]) {
			new Outer().f(); 							// ��ʾfrom Outer
			final int i = 1;
			Outer a = new Outer(i) {					// ������
				{
					System.out.println("initialize constructor");
				}
				void f() {
					System.out.println("from anonymous" + "   " + i);
				}
			};
			a.f(); 								// ��ʾfrom anonymous
		}	
	}

