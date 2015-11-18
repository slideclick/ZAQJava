package org.container;
import java.util.*;
class Person {
	private String name;
	private int age;
	public Person(String n, int a) {
		this.name = n; this.age = a;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return (name.equals(p.name)) && (age == p.age);
		}
		return super.equals(obj);
	}
	public int hashCode() {
		int i;
		i = (name == null ? 0 : name.hashCode());
		i = 10 * i + age;
		return i;
	}
}
public class HashSetTest {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add(new Person("Jack", 20));
		c.add(new Person("Jack", 20));
		System.out.println(c.size());
		System.out.println(c);
		c.add(new Integer(25));
		c.add("Hello World");
		c.remove(new Integer(25));
		c.remove("Hello World");
		System.out.println(c.remove(new Person("Jack", 20)));
	}
}

