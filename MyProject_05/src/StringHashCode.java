public class StringHashCode {
		public static void main(String[] args){
			String str1 = new String("hello");
			String str2 = new String("hello");
			String str3 = new String("world");
			System.out.println(str1.hashCode());
			System.out.println(str2.hashCode());
			System.out.println(str3.hashCode());
			Student s1 = new Student("Mary",18);
			System.out.println(s1.hashCode());
			Student s2 = new Student("Tom",20);
			System.out.println(s2.hashCode());
		}
	}
	class Student {
		String name;
		int age;
		Student(String str, int i) {
			name = str;
			age = i;
		}
	}

