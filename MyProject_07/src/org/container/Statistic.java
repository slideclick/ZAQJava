package org.container;
	import java.util.*;
	public class Statistic {
		public static void main(String[] args) {
			String s = "c789yz45!786*+56abc123456789";
			TreeMap map = new TreeMap();
			char[] arr = s.toCharArray();			// ���ַ���ת��Ϊ�ַ�����
			int i = arr.length;					// ��ȡ�ַ�����ĳ���
			int k = 0;
			int p = 0;						// ���������ַ��Ŀ�ʼλ��
			int q = 0;						// ���������ַ��Ľ���λ��
			boolean b = false;
			for (int j = 0; j < i; j++) {
				k = arr[j];
				if (47 < k && k < 58) {		
					if (b == false) {
						p = j;				// �������ַ��Ŀ�ʼλ��,���¸�λ��
						b = true;		
					}
					q = j;
					System.out.print(arr[j]);
					if (q != p) {
						map.put(p, q);		// ����ʼλ�úͽ���λ�÷��뵽Map������
					}
				}else{
					b= false;
				}
			}
			System.out.println(map);
			Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();	// ����һ��������
			int []array= new int[10];
			int a = 0;
			while(it.hasNext()){
				Map.Entry entry = it.next();
				int u = (Integer) entry.getKey();				// ��ȡ������
				int v = (Integer)entry.getValue()+1;			// ��ȡֵ����
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
					String s4 = s2.substring(h, g);			// ȡ�������4���������ַ�
					array[a++] = Integer.parseInt(s4);
				}
			}
			for(int c = 0;c<a;c++){
				System.out.println(array[c]);
			}
		}
	}
