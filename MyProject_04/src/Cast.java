class Person {
		public String name;
		Person(String name) {
			this.name = name;
		}
	}
	class Student extends Person {
		public int studentId;
		Student(String str, int id) {
			super(str); 								// 调用父类的构造方法
			studentId = id;
		}
		void studying() {
			System.out.println("I am studying hard!");
		}
	}
	class Employee extends Person {
		public int salary;
		Employee(String str, int s) {
			super(str); 								// 调用父类的构造方法
			salary = s;
		}
		void working() {
			System.out.println("I am working hard!");
		}
	}
	public class Cast {
		public void testCast(Person p) {
			System.out.println("name is:" + p.name);
			if (p instanceof Student) {
				Student s = (Student) p;
				System.out.println("studentId is:" + s.studentId);
			} else if (p instanceof Employee) {
				Employee e = (Employee) p;
				System.out.println("studentId is:" + e.salary);
			}
		}
		public static void main(String[] args) {
			Cast cast = new Cast();
			Person p = new Person("Tom");
			Student s = new Student("John", 18);
			Employee e = new Employee("Lucy", 2000);
			System.out.println(p instanceof Person); 			// true
			System.out.println(s instanceof Person);			 	// true
			System.out.println(e instanceof Person); 			// true
			System.out.println(p instanceof Student);	 		// false
			p = new Employee("Mary", 3000); 				// 对象的向上转型
			System.out.println(p.name);
			// System.out.println(p1.salary);					// 错误
			System.out.println(p instanceof Person);
			System.out.println(p instanceof Employee);
			Employee e1 = (Employee) p; 					// 对象的向下转型
			System.out.println(e1.salary);
			e1.working();
			p = new Student("Lily", 4000); 					// 对象的向上转型
			System.out.println(p.name);
			Student s1 = (Student) p; 						// 对象的向下转型
			System.out.println(s1.studentId);
			s1.studying();
			cast.testCast(p);
			cast.testCast(s);
			cast.testCast(e);
		}
	}
