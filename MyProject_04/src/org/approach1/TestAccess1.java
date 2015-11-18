package org.approach1;
public class TestAccess1 {
	private String var1="private variable";
	String var2="default variable";
	protected String var3="protected variable";
	public String var4="public variable";
	private void f1(){
		System.out.println("private method");
	}
	void f2(){
		System.out.println("default method");
	}
	protected void f3(){
		System.out.println("protected method");
	}
	public void f4(){
		System.out.println("public method");
	}
	public static void main(String[]args){
		TestAccess1 access1= new TestAccess1();
		System.out.println(access1.var1);
		System.out.println(access1.var2);
		System.out.println(access1.var3);
		System.out.println(access1.var4);
		access1.f1();
		access1.f2();
		access1.f3();
		access1.f4();
	}
}
