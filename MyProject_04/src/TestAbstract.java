
abstract class Animal {
	void sleep(){
		System.out.println("animals sleep!");
	}
	abstract void run();							// 抽象方法
}
class Dog extends Animal {
	 void run() {								// 实现抽象类
		System.out.println("dogs run fast!");
	}
}
public class TestAbstract {
	public static void f(Animal a) {
		a.sleep();
		a.run();
		Dog d;
		d= (Dog)a;								// 向下转型	
		d.sleep();
		d.run();
	}
	public static void main(String[] args) {
		Dog d = new Dog();
		TestAbstract.f(d);
	}
}

