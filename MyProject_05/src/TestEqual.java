public class TestEqual {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));	
		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		Person p1 = new Person("Tom", 18);
		Person p2 = new Person("Tom", 18);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		Person p3 = new Person("Lucy", 20);
		Person p4 = new Person("Jack",20);
		System.out.println(p3 == p4);
		System.out.println(p3.equals(p4));
	}
}
class Person {
	String name;
	int age;
	Person(String str, int i) {
		name = str;
		age = i;
	}
	public boolean equals(Object obj) {				// 重写Object类的equals()方法
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

