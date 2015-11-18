public class ConWithThis {
		int count = 0;
		String str = "hello";
		ConWithThis(int i) {
			this("java");							// ����ConWithThis(String s))
			count = i;
			System.out.println("Constructor with int arg only, count= " + count);
		}
		ConWithThis(String s) {
			System.out.println("Constructor with String arg only, s = " + s);
			str = s;
		}
		ConWithThis(String s, int i) {
			this(i);								// ����ConWithThis(int i)
			this.str = s;
			System.out.println("Constructor with String and int args, s = " + s
				+ ", i = " + i);
		}
		ConWithThis() {
			this("use this reference", 9);					// ����ConWithThis(String s, int i)
			System.out.println("default constructor(no args)");
		}
		void f() {
			System.out.println("count = " + count + ", s = " + str);
		}
		public static void main(String[] args) {
			ConWithThis x = new ConWithThis();
			x.f();
		}
	}

