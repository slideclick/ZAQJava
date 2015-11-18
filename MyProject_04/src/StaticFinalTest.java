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
		static final Test sft = new Test(); 					// static final���������ڴ���ֻ��һ�ݿ���
		private final Test ft = new Test();					// final��������ÿ�������ж���һ�ݿ���
		static final String SFS = "static final"; 
		private final String fs = "final";
		private static Random rand = new Random();			
		static final int SFI = rand.nextInt(); 				// ��ȡһ���������
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

