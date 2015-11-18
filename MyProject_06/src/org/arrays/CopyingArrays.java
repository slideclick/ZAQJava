package org.arrays;
	import java.util.Arrays;
	public class CopyingArrays {
		public static void main(String[] args) {
			int[] i1 = new int[] { 6, 18, 24 };
			int[] i2 = new int[10];
			System.arraycopy(i1, 1, i2, 5, 2);						// 复制数组的元素
			for (int i = 0; i < i2.length; i++) {
				System.out.print(i2[i]+"　");
			}
			System.out.println();
			Integer[] array1 = { 3, 5, 9, 15 };
			Integer[] array2 = new Integer[10];
			System.arraycopy(array1, 1, array2, 5, 3);
			for (int i = 0; i < array2.length; i++) {
				System.out.print(array2[i] + " ");
			}
			System.out.println();
			System.out.print(Arrays.deepToString(array2) + " ");		// 显示数组的元素
			System.out.println();
			Person[] p1 = new Person[] { new Person("Tom", 18),
				new Person("Jack", 20), new Person("Lucy", 24) };
			Person[] p2 = new Person[3];
			System.arraycopy(p1, 0, p2, 0, p1.length);
			for (int i = 0; i < p2.length; i++) {
				System.out.println("name=" + p2[i].name + "," + "age=" + p2[i].age);
			}
			System.out.println("name=" + p1[1].name + "," + "age=" + p1[1].age);
			System.out.print(Arrays.deepToString(p1) + " ");
		}
	}
	class Person {
		String name;
		int age;
		Person(String x, int y) {
			this.name = x; this.age = y;
		}
		public String toString() {
			return "name=" + name + "," + "age=" + age;
		}
	}

