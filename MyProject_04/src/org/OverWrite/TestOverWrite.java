package org.OverWrite;
class Person {
	private String name;
	private int age;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getInfo() {
		return "Name: " + name + "\n" + "age: " + age;
	}
}
class Employee extends Person {
	private int salary;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getInfo() {						// 重写父类的getInfo()方法
		return "Name: " + getName() + "\nage: " + getAge() + "\nschool: "+ salary;
	}
}
public class TestOverWrite {
	public static void main(String arg[]) {
		Employee employee = new Employee();
		employee.setName("Mary");
		employee.setAge(20);
		employee.setSalary(2000);
		System.out.println(employee.getInfo());
	} 
}

