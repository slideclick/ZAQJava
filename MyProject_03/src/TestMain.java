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
			//System.out.println(x);				// ������󣬲���ֱ�ӷ��ʷǾ�̬����
			System.out.println(y);					// �Ϸ�����ֱ�ӷ��ʾ�̬����
			//method1();						// ������󣬲���ֱ�ӷ��ʷǾ�̬����
			method2();							// �Ϸ�����ֱ�ӷ��ʾ�̬����
			TestMain test = new TestMain();
			System.out.println();
			test.method1();
		}
}

