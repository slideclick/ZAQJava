package org.enums;
	import java.util.EnumMap;
	import java.util.Map;
	enum Size {
    		Small,Medium,Large;
	}
	public class EnumMapTest {
		public static void main(String[] args) {
			/** 创建一个指定键类型为枚举类型Size的空枚举映射，键对象指定为枚举类型			
			 * 	Size，值对象指定为Integer，参数为键类型的Class对象 */
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
