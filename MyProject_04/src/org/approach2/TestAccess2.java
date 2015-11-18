package org.approach2;

import org.approach1.TestAccess1;

class Access3 {
	private String var1 = "private variable";
	String var2 = "default variable";
	protected String var3 = "protected variable";
	public String var4 = "public variable";

	private void f1() {
		System.out.println("private method");
	}

	void f2() {
		System.out.println("default method");
	}

	protected void f3() {
		System.out.println("protected method");
	}

	public void f4() {
		System.out.println("public method");
	}
}

public class TestAccess2 {
	public static void main(String[] args) {
		Access3 access3 = new Access3();
		// System.out.println(access3.var1); // 不能访问另一个类的私有成员变量
		System.out.println(access3.var2);
		System.out.println(access3.var3);
		System.out.println(access3.var4);
		// access3.f1(); // 不能访问另一个类的私有成员方法 
		access3.f2();
		access3.f3();
		access3.f4();
	}
}
