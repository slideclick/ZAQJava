package org.container;
	import java.util.*;
	public class AlphaDegree {
		public static void main(String[] args){
			String s = "afasdfassgdfgdfgdfgsdfg";
			char[] num = s.toCharArray();				// ���ַ���ת��Ϊchar����
			int i = num.length-1;
			HashMap map = new HashMap();				// ����һ��HashMap����
			map.put(num[0], 1);
			for (int k=1; k<=i;k++){
				if(map.containsKey(num[k])){		    // ������������Ѵ��ڸ���ĸ����ĸ����1
					Integer j = (Integer) map.get(num[k]);
					map.put(num[k], ++j);
				}
				else map.put(num[k], 1);				// ��������ڣ�������ĸ���뵽������
			}
			System.out.println(map);
		}
	}

