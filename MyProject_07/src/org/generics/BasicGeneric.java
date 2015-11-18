package org.generics;
public class BasicGeneric<T> {							// T是类型参数
	private T a;
	public BasicGeneric(T a)
	{	this.a = a;}
	public void set(T a)
	{	this.a = a;}
	public T get()
	{	return a;}
	public static void main(String[] args){
		BasicGeneric<B> generic1  = new BasicGeneric<B>(new B()); 
		B b = generic1.get();
		BasicGeneric<Double> generic2  = new BasicGeneric<Double>(3.14);
		Double d = generic2.get();
		System.out.println(d);
		BasicGeneric<String> generic3  = new BasicGeneric<String>("use generic");
		String s = generic3.get();
		System.out.println(s);
	}
}
class B {
	B(){
		System.out.println(" Class B");
	}
}

