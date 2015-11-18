public class ConstructorInitiate {
	boolean t;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	char c;
	ConstructorInitiate() {
		t = true;									// 成员变量的初始化
		b = 12;
		s = 99;
		i = 49;
		l = 120;
		f = 3.14f;
		d = 3.1415;
		c = 'h';
	}
	public static void main(String[] args) {
		ConstructorInitiate initiate;						// 定义引用变量
		initiate = new ConstructorInitiate();
		System.out.println(initiate.t);
		System.out.println(initiate.b);
		System.out.println(initiate.s);
		System.out.println(initiate.i);
		System.out.println(initiate.l);
		System.out.println(initiate.f);
		System.out.println(initiate.d);
		System.out.println(initiate.c);
	}
}
