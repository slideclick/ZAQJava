package org.generics;
class Automobile {}
class Holder1 {
	private Automobile a;
	public Holder1(Automobile a) {
		this.a = a;
	}
	Automobile get() {
		return a;
	}
}
public class Holder2<T> {
	private T a;
	public Holder2(T a) {
		this.a = a;
	}
	public void set(T a) {
		this.a = a;
	}
	public T get() {
		return a;
	}
	public static void main(String[] args) {
		// 持有Automobile类型的对象
		Holder2<Automobile> h2 =new Holder2<Automobile>(new Automobile()); 	
		Automobile a = h2.get();
		// 持有String类型的对象
		Holder2<String> h3 = new Holder2<String>(new String("generics")); 
		//持有Integer类型的对象
		Holder2<Integer> h4 = new Holder2<Integer>(new Integer(12));		
		String str = h3.get();
		int i = h4.get();
		System.out.println(str);
		System.out.println(i);
	}
}
