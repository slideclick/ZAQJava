package org.container;
	import java.util.*;
	public class Statistic {
		public static void main(String[] args) {
			String s = "c789yz45!786*+56abc123456789";
			TreeMap map = new TreeMap();
			char[] arr = s.toCharArray();			// 将字符串转换为字符数组
			int i = arr.length;					// 获取字符数组的长度
			int k = 0;
			int p = 0;						// 记下数字字符的开始位置
			int q = 0;						// 记下数字字符的结束位置
			boolean b = false;
			for (int j = 0; j < i; j++) {
				k = arr[j];
				if (47 < k && k < 58) {		
					if (b == false) {
						p = j;				// 是数字字符的开始位置,记下该位置
						b = true;		
					}
					q = j;
					System.out.print(arr[j]);
					if (q != p) {
						map.put(p, q);		// 将开始位置和结束位置放入到Map容器中
					}
				}else{
					b= false;
				}
			}
			System.out.println(map);
			Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();	// 返回一个迭代器
			int []array= new int[10];
			int a = 0;
			while(it.hasNext()){
				Map.Entry entry = it.next();
				int u = (Integer) entry.getKey();				// 获取键对象
				int v = (Integer)entry.getValue()+1;			// 获取值对象
				if((v-u)<=3){
					String s1 = s.substring(u,v);
					array[a++]=Integer.parseInt(s1);
				}else{
					String s2 = s.substring(u,v);
					int g = s2.length();
					int h =0;
					while(h+4<g){
						String s3 = s2.substring(h, h+4);
						array[a++] = Integer.parseInt(s3);
						h= h+4;
					}
					String s4 = s2.substring(h, g);			// 取出最后不足4个的数字字符
					array[a++] = Integer.parseInt(s4);
				}
			}
			for(int c = 0;c<a;c++){
				System.out.println(array[c]);
			}
		}
	}
