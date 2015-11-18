package org.container;
	import java.util.*;
	public class ConverseUpper {
		public static void main(String[] args) {
			String s = "afAsdfAsSgdfGdfgDfGsDfg";
			String str = s.toUpperCase();				// 将字符串中的所有字符转换成大写
			char[] num = str.toCharArray();			// 将字符串转换为char数组
			int i = num.length-1;
			TreeMap map = new TreeMap();			// 创建一个TreeMap对象
			map.put(num[0], 1);
			for (int k=1; k<=i;k++){
				if(map.containsKey(num[k])){		// 如果在容器中已存在该字母，字母数加1
					Integer j = (Integer) map.get(num[k]);
					map.put(num[k], ++j);
				}
				else map.put(num[k], 1);			// 如果不存在，将该字母加入到容器中
			}
			System.out.println(map);
			List list = Collections.synchronizedList(new ArrayList());
		}
	}
