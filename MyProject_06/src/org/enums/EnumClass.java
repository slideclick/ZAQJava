package org.enums;
	enum Season{
		SPRING, SUMMER, AUTUMN, WINTER
	}
	public class EnumClass {
		public static void main(String[] args) {
			for (Season s : Season.values()) {							// 遍历enum实例
				//得到enum实例在声明的顺序
				System.out.print(s + " ordinal: " + s.ordinal());		
				System.out.print(s.compareTo(Season.SUMMER) + " ");		// 比较是否相等
				System.out.print(s.equals(Season.SUMMER) + " ");
				System.out.print(s == Season.SUMMER);
				System.out.print(s.getDeclaringClass());
				System.out.println(s.name());
				System.out.println("----------------------");
			}
			for (String s : "SPRING SUMMER AUTUMN WINTER".split(" ")) {
				// 根据给定的名字返回相应的实例
				Season season = Enum.valueOf(Season.class, s);			
				System.out.println(season);
			}
		}
	}

