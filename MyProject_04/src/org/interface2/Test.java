package org.interface2;
	import org.interface1.*;								// ����org.interface1���е���
	public class Test implements TestMethod{
		public void studying(){
			System.out.println("I am studying hard.");
		}
		public void playing(){
			System.out.println("I like playing football.");
		}
		public void eating(){
			System.out.println("I like est fish.");
		}
		public static void main(String [] args){
			Test test = new Test();
			test.studying();
			test.playing();
			test.eating();
		}
	}

