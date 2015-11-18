import java.util.*;
class Value {
		int i;
		public Value( final int a) {						// 局部常量
			i = a;									// i = a++，错误，final变量不能修改
		}
}
public class FinalVar {
		private static Random rand = new Random(47);
		private String id;
		public FinalVar(String id) {
			this.id = id;
		}
		private final int valueOne = 9;					// 实例常量
		private static final int VALUE_TWO = 99;			// 静态常量
		public static final int VALUE_THREE = 39;
		private final int i4 = rand.nextInt(20);
		static final int INT_5 = rand.nextInt(20);
		final Value v1 = new Value(22);
		private static final Value VAL_3 = new Value(33);
		private final int[] a = { 1, 2, 3, 4, 5, 6 };
		public String toString() {
			return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
		}
		public static void main(String[] args) {
			FinalVar f1 = new FinalVar("f1");
			f1.v1.i++;
			System.out.println(f1.v1.i);
			for (int i = 0; i < f1.a.length; i++){
				f1.a[i]++;
				System.out.print(f1.a[i]+"  ");
			}
			System.out.println();
			System.out.println("Creating new FinalVar");
			FinalVar f2 = new FinalVar("f2");
			System.out.println(f2);
		}
}

