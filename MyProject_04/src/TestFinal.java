final class T {
		int i = 3;
		int j = 6;
		void f() {
			System.out.println(i+j);
		}
}
public class TestFinal {
		public static void main(String[] args) {
			T n = new T();
			n.f();
			n.i = 20;
			n.j++;
		}
}
