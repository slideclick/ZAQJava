package org.container;
	import java.util.*;
	class Employee implements Comparable {
		private String name;
		private int salary;
		public Employee(String name, int age) {
			this.name = name;
			this.salary = age;
		}
		public String toString() {
			return "name=" + name + ", " + "salary=" + salary;
		}
		public boolean equals(Object o) {						 // 重写equals()方法
			if (!(o instanceof Employee))
				return false;
		 	Employee employee = (Employee) o;
			if (this.name.equals(employee.name) && this.salary ==employee.salary)
				return true;
			else
				return false;
		}
		public int hashCode() {							// 重写hashCode()方法
			int result;	
			result = (name == null ? 0 : name.hashCode());
			return result;
		}
		public int compareTo(Object o) {					 	// 重写compareTo()方法
			Employee e = (Employee) o;
			int result = salary > e.salary ? 1 : (salary == e.salary ? 0 : -1);
			if (0 == result) {
				result = name.compareTo(e.name);
			}
			return result;
		}
		public static void main(String[] args) {
			Set<Employee> set = new TreeSet<Employee>();
			set.add(new Employee("Lucy", 2800));
			set.add(new Employee("John", 4000));
			set.add(new Employee("Mary", 3000));
			set.add(new Employee("Lily", 3000));
			Iterator<Employee> it = set.iterator();
			while (it.hasNext()) {
				Employee student = it.next();
				System.out.println(student);
			}
		}
	}

