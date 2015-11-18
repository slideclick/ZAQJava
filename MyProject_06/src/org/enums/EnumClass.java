package org.enums;
	enum Season{
		SPRING, SUMMER, AUTUMN, WINTER
	}
	public class EnumClass {
		public static void main(String[] args) {
			for (Season s : Season.values()) {							// ����enumʵ��
				//�õ�enumʵ����������˳��
				System.out.print(s + " ordinal: " + s.ordinal());		
				System.out.print(s.compareTo(Season.SUMMER) + " ");		// �Ƚ��Ƿ����
				System.out.print(s.equals(Season.SUMMER) + " ");
				System.out.print(s == Season.SUMMER);
				System.out.print(s.getDeclaringClass());
				System.out.println(s.name());
				System.out.println("----------------------");
			}
			for (String s : "SPRING SUMMER AUTUMN WINTER".split(" ")) {
				// ���ݸ��������ַ�����Ӧ��ʵ��
				Season season = Enum.valueOf(Season.class, s);			
				System.out.println(season);
			}
		}
	}

