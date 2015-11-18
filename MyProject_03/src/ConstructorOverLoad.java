class Student {
		private String name = "Lucy";
		private int age = 18;
		Student() {
			System.out.println("invoke no parameter construcor method");
			System.out.println("name is " + name + ",age is " + age);
		}
		Student(String n) {
			name = n;
			System.out.println("invoke construcor method with one parameter");
			System.out.println("name is " + name + ",age is " + age);
		}
		Student(String n, int i) {
			name = n;
			age = i;
			System.out.println("invoke construcor method with two parameters");
			System.out.println("name is " + name + ",age is " + age);
		}
}
public class ConstructorOverLoad {
		public static void main(String[] args) {
			new ConstructorOverLoad();
			new Student();
			new Student("Tom");
			new Student("Jack", 25);
		}
}
