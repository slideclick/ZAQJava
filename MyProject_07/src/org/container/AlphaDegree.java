package org.container;
	import java.util.*;
	public class AlphaDegree {
		public static void main(String[] args){
			String s = "afasdfassgdfgdfgdfgsdfg";
			char[] num = s.toCharArray();				// 将字符串转换为char数组
			int i = num.length-1;
			HashMap map = new HashMap();				// 创建一个HashMap对象
			map.put(num[0], 1);
			for (int k=1; k<=i;k++){
				if(map.containsKey(num[k])){		    // 如果在容器中已存在该字母，字母数加1
					Integer j = (Integer) map.get(num[k]);
					map.put(num[k], ++j);
				}
				else map.put(num[k], 1);				// 如果不存在，将该字母加入到容器中
			}
			System.out.println(map);
		}
	}

