package org.polymorphism;
class Student {
	String name;
	Student(String name) {
		this.name = name;
	}
	public void studying() {
		System.out.println("I am a student!");
	}
}
class UnderGraduate extends Student {
	private int credit;
	UnderGraduate(String n, int c) {
		super(n);
		credit = c;
	}
	public void studying() {
		System.out.println("I am a undergraduate!");
	}
}
class PostGraduate extends Student {
	private int paper;
	PostGraduate(String n, int c) {
		super(n);
		paper = c;
	}
	public void studying() {
		System.out.println("I am a postgraduate!");
	}
}
class Doctor extends Student {
	Doctor() {
		super("doctor");
	}
	public void studying() {
		System.out.println("I am a Doctor!");
	}
}
class Profession {
	private String name;
	private Student student;
	Profession(String name, Student s) {
		this.name = name;
		this.student = s;
	}
	public void tutor() {
		student.studying();
		System.out.println("my name is:" + student.name);
	}
}
public class Polymorphism {
	public static void main(String[] args) {
		UnderGraduate underGraduate = new UnderGraduate("Tom", 50);
		PostGraduate postGraduate = new PostGraduate("Jack", 5);
		Doctor doctor = new Doctor();
		Profession p1 = new Profession("DEK", underGraduate);
		Profession p2 = new Profession("DEK", postGraduate);
		Profession p3 = new Profession("DEK", doctor);
		p1.tutor();
		p2.tutor();
		p3.tutor();
	}
}

