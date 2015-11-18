package org.arrays;
	public class InvertSequence {
		public static void main(String[] args){
			int i =0 ;int j = 0;int k = 0;
			int l = 0;int m = 0;int n = 0;
			int num =0;
			for(int p = 1001;p<10000;p++){
				i = p /1000;
				j = p %1000;
				k = j /100;
				l = j %100;
				m = j /10;
				n = j %10;
				num = n *1000+m*100+k*10+i*1;
				if (num ==p*9){
					System.out.println(p);
				}
			}
		}
	}

