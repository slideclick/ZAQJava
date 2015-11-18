class A{
		private int i;
		A(){
			System.out.println("invoke A constructor,i = "+ i);
		}
	}
	class B extends A{
		private String s;
		B(){
			System.out.println("invoke B constructor,s = "+ s);
		}
	}
	public class C extends B{
		public C(){
			System.out.println("invoke C constructor");
		}
		public static void main(String[] args){
			new C();
		}
	}

