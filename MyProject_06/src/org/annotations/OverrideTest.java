package org.annotations;
	class Person {
		String name;
		int age;
		Person(String str, int i) {
			name = str; age = i;
		}
		// @Override						// 重写从Object类继承过来的equals()方法
		public boolean Equals(Object obj) {		
			Person p = null;
			if (obj instanceof Person)
				p = (Person) obj;
			else
				return false;
			if (p.name == this.name && p.age == this.age)
				return true;
			else
				return false;
		}
	}
	public class OverrideTest {
		public static void main(String[] args) {
			Person p1 = new Person("Tom", 18);
			Person p2 = new Person("Tom", 18);
			System.out.println(p1.equals(p2));
		}
	}

