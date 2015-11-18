class SuperClass {
	private int n;
	SuperClass() {
		System.out.println("SuperClass()");
	}
	SuperClass(int n) {
		System.out.println("SuperClass(" + n + ")");
		this.n = n;
	}
}
class SubClass extends SuperClass {
	private int n;
	SubClass(int n) {
		super();						// ���ʸ����Ĭ�Ϲ��췽��
		System.out.println("SubClass(" + n + ")");
		this.n = n;
	}
	SubClass() {
		super(100);						// ���ʸ�����вι��췽��
		System.out.println("SubClass()");
	}
}
public class TestSuperSub {
	public static void main(String arg[]) {
		new TestSuperSub();
		SubClass sc1 = new SubClass();
		SubClass sc2 = new SubClass(200);
	}
}
