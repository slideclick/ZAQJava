package org.interfaceImp;
interface A{								//�ӿ�
	void a_f();
}
interface B{
	void b_f();
}
interface C extends A,B{					//�ӿڵĶ�̳�
	void c_f();
}
class D {
	void d_f(){}{
		System.out.println("d_f()");
	}
}
class H implements A{
	public void a_f(){						//������ʽ����Ϊpublic 
		System.out.println("a_f()");
	}
	void h_f(){					
		System.out.println("h_f()");
	}
}
class E extends D implements A,B{			//ʵ�ֶ���ӿ�
	public void a_f(){						//������ʽ����Ϊpublic 
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
		A a = new H();						//�ӿڵ����ñ���ָ��ʵ�ֽӿڵ����ʵ��
		a.a_f();
	}
}
