abstract class Dad {									// 接口
	}
	class Son1 extends Dad {
		protected void print() { System.out.println("Son"); }
	}
	abstract class SecondDad {
		abstract protected void print();
	}
	class SecondSon extends SecondDad {
		protected void print() { System.out.println("SecondSon"); }
	}
	public class Polymrophism {
		public static void testPrint(Son1 s) {					// 静态方法
			((Son1)s).print();
		}
		public static void secondTestPrint(SecondDad sd) {
			sd.print();
		}
		public static void main(String[] args) {
			Son1 s = new Son1();
			Polymrophism.testPrint(s);						// 调用静态方法
			SecondSon ss = new SecondSon();
			Polymrophism.secondTestPrint(ss);			
		}
	}

