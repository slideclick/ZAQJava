	import java.util.*;
	class Test {
		Test() {
			System.out.println("Test()");
		}
	}
	public class StaticFinalTest {
		private String name;
		public StaticFinalTest(String s) {
			name = s;
		}
		static final Test sft = new Test(); 					// static final变量，在内存中只有一份拷贝
		private final Test ft = new Test();					// final变量，在每个对象中都有一份拷贝
		static final String SFS = "static final"; 
		private final String fs = "final";
		private static Random rand = new Random();			
		static final int SFI = rand.nextInt(); 				// 获取一个随机整数
		private final int fi = rand.nextInt();
		public String toString() {
			return (name + ": " + sft + ", " + ft + ", " + SFS + ", " + fs + ", "
					+ SFI + ", " + fi);
		}
		public static void main(String[] args) {
			StaticFinalTest d1 = new StaticFinalTest("d1");
			StaticFinalTest d2 = new StaticFinalTest("d2");
			StaticFinalTest d3 = new StaticFinalTest("d3");
			System.out.println(d1);
			System.out.println(d2);
			System.out.println(d3);
		}
	}

