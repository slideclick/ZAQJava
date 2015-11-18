public class AbstractDemo {
		public static void main(String[] args) {
			//********C1 and C2 不能任何对象********
			//C1 ng1 = new C1();
			//C2 ng2 = new C2();
			Go1 g1 = new Go1();
		}
	}
	abstract class C1 {
		C1() { System.out.println("C1()"); }
	}
	abstract class C2 {}
	class Go1 extends C1 {
		Go1() { System.out.println("Go1()"); }
	}

