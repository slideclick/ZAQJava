class A{
		String name;
		public A(String str){
			name = str;
		}
		public void f1(){
			System.out.println("f1() of name "+ name+" is invoked!");
		}
		public void f2(){
			A a2 = new A("a2");
			this.f1();								// 使用this引用调用f1()方法
			a2.f1();
		}
}
public class TestThis {
		public static void main(String[] args){
			A a1 = new A("a1");
			a1.f2();
		}
}

