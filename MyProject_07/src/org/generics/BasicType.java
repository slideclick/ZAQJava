package org.generics;
public class BasicType {
	private Object obj;
	public BasicType(Object obj)
	{	this.obj= obj; }
	public void setObj(Object obj)
 	{	this.obj = obj; }
	public Object getObj()
	{	return obj; }
	public static void main(String[] args) {
		BasicType type = new BasicType(new A());	
		A a = (A)type.getObj();						// 类型转换
		type.setObj(new Double(3.14));
		Double d  = (Double)type.getObj();
		type.setObj(new String("before use generics"));
		String s = (String)type.getObj();
		Double b= (Double)type.getObj();					// 运行时异常
	}
}
class A {
	A(){
		System.out.println("A");
	}
}

