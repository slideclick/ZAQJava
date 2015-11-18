package org.interfaceImp;
interface A{								//接口
	void a_f();
}
interface B{
	void b_f();
}
interface C extends A,B{					//接口的多继承
	void c_f();
}
class D {
	void d_f(){}{
		System.out.println("d_f()");
	}
}
class H implements A{
	public void a_f(){						//必须显式声明为public 
		System.out.println("a_f()");
	}
	void h_f(){					
		System.out.println("h_f()");
	}
}
class E extends D implements A,B{			//实现多个接口
	public void a_f(){						//必须显式声明为public 
		System.out.println("a_f()");
	}
	public void b_f(){
		System.out.println("b_f()");
	}
}
public class TestInterface {
	public static void main(String[]args ){
		E e =new E();
		e.a_f();
		e.b_f();
		A a = new H();						//接口的引用变量指向实现接口的类的实例
		a.a_f();
	}
}
