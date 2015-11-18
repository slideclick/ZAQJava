package org.innerclasses;
class Outer {
	private int index=100;
	private class Inner {
		private int index=50;
		void print() {
			int index=30;
				System.out.println(index);					
				System.out.println(this.index);				
				System.out.println(Outer.this.index);			
		}
	}
	void print() {
		Inner i = new Inner();
		i.print();
	}
}
public class Test {
	public static void main(String[] args) {
		Outer o = new Outer();
		o.print();
	}
}

