	package org.approach2;
	import org.approach1.TestAccess1;
	public class TestAccess3 extends TestAccess1{
		public static void main(String[] args) {
			TestAccess3 access3 = new TestAccess3();
			//System.out.println(access3.var1);					// �������
			//System.out.println(access3.var2);					// �������
			System.out.println(access3.var3);
			System.out.println(access3.var4);
			//access3f1();								// �������
			//access3.f2();								// �������
			access3.f3();
			access3.f4();
		}
	}
