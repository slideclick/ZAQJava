public class TestMain {
		int x =1;
		void method1(){}{
			System.out.println("invoke no static method1");
		}
		static void  method2(){
			System.out.println("invoke static method2");
		}
		static int y=9;
		public static void main(String[] args){
			//System.out.println(x);				// 编译错误，不能直接访问非静态变量
			System.out.println(y);					// 合法，可直接访问静态变量
			//method1();						// 编译错误，不能直接访问非静态方法
			method2();							// 合法，可直接访问静态方法
			TestMain test = new TestMain();
			System.out.println();
			test.method1();
		}
}

