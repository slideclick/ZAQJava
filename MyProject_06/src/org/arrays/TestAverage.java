package org.arrays;
		public class TestAverage {
			public static void main(String[] args){
				int i = args.length;						// ��ȡ�����в����ĳ���
				int[] arr = new int[10];
				int num =0;
				int k =0; int p =0;
				for(int j =0;j<i;j++){
					arr[j]= Integer.parseInt(args[j]);	
					if (arr[j]< 0){
						k++;							// �����ĸ�����һ
					}
					else						
						p++;							// �����ĸ�����һ
					num = num + arr[j];					// �����ۼӺ�
				}
				System.out.println("�����ĸ���"+p);
				System.out.println("�����ĸ���"+k);
				System.out.println("ƽ��ֵ��"+num/i);			// ����ƽ��ֵ
			}
		}

