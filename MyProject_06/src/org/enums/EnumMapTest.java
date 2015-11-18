package org.enums;
	import java.util.EnumMap;
	import java.util.Map;
	enum Size {
    		Small,Medium,Large;
	}
	public class EnumMapTest {
		public static void main(String[] args) {
			/** ����һ��ָ��������Ϊö������Size�Ŀ�ö��ӳ�䣬������ָ��Ϊö������			
			 * 	Size��ֵ����ָ��ΪInteger������Ϊ�����͵�Class���� */
			Map<Size, Integer> map = new EnumMap<Size, Integer>(Size.class);									
			map.put(Size.Small, 36);
			map.put(Size.Medium, 40);	
			map.put(Size.Large, 42);
			for (Size size : Size.values()) {
				System.out.println(map.get(size));
			}
			for (int value : map.values()) {
				System.out.println(value);
			}
		}
	}
