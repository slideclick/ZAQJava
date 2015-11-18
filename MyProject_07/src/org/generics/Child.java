package org.generics;
	class Parent<T1, T2> {
		private T1 value1;
		private T2 value2;
		public T1 getValue1() {
			return value1;
		}
		public void setValue1(T1 value1) {
			this.value1 = value1;
		}
		public T2 getValue2() {
			return value2;
		}
		public void setValue2(T2 value2) {
			this.value2 = value2;
		}
	}
	
	public class Child<T1, T2, T3> extends Parent<T1, T2> {			// 子类泛型继承父类泛型
		private T3 value3;
		public void setValue3(T3 value3) {
			this.value3 = value3;
		}
		public T3 getValue3() {
			return value3;
		}
		public static void main(String[] args){
			Child<String,Integer,Boolean> child = new Child<String,Integer,Boolean>();
			child.setValue1("subclass extends parent");
			child.setValue2(10);
			child.setValue3(true);
			System.out.println(child.getValue1());
			System.out.println(child.getValue2());
			System.out.println(child.getValue3());
		}
	}

