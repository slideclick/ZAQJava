public class InitiaValue {
		boolean t;
		byte b;
		short s;
		int i;
		long l;
		float f;
		double d;
		char c;
		Point point;								// 引用类型
		void initiaValues(){
			System.out.println(t);
			System.out.println(b);
			System.out.println(s);
			System.out.println(i);
			System.out.println(l);
			System.out.println(f);
			System.out.println(d);
			System.out.println(c);
			System.out.println(point);
		}
		public static void main(String[]args){
			InitiaValue test = new InitiaValue();
			test.initiaValues();
		}
	}

