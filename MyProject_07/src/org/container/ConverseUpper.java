package org.container;
	import java.util.*;
	public class ConverseUpper {
		public static void main(String[] args) {
			String s = "afAsdfAsSgdfGdfgDfGsDfg";
			String str = s.toUpperCase();				// ���ַ����е������ַ�ת���ɴ�д
			char[] num = str.toCharArray();			// ���ַ���ת��Ϊchar����
			int i = num.length-1;
			TreeMap map = new TreeMap();			// ����һ��TreeMap����
			map.put(num[0], 1);
			for (int k=1; k<=i;k++){
				if(map.containsKey(num[k])){		// ������������Ѵ��ڸ���ĸ����ĸ����1
					Integer j = (Integer) map.get(num[k]);
					map.put(num[k], ++j);
				}
				else map.put(num[k], 1);			// ��������ڣ�������ĸ���뵽������
			}
			System.out.println(map);
			List list = Collections.synchronizedList(new ArrayList());
		}
	}
