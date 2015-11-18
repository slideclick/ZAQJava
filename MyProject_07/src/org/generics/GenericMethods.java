package org.generics;
	public class GenericMethods {
		public <T> void f(T x) {
			System.out.println(x.getClass().getName());		// ��ʾ���ݵĲ������͵�����
		}
		public static void main(String[] args) {
			GenericMethods gm = new GenericMethods();
			gm.<Boolean>f(true);
			gm.<String>f("use generic");
			gm.<Integer>f(3);
			gm.<Float>f(3.14f);
			gm.<Double>f(3.14);
			gm.f(gm);
		}
	}

