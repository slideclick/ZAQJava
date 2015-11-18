package org.arrays;
		public class TestAverage {
			public static void main(String[] args){
				int i = args.length;						// 获取命令行参数的长度
				int[] arr = new int[10];
				int num =0;
				int k =0; int p =0;
				for(int j =0;j<i;j++){
					arr[j]= Integer.parseInt(args[j]);	
					if (arr[j]< 0){
						k++;							// 负数的个数加一
					}
					else						
						p++;							// 正数的个数加一
					num = num + arr[j];					// 计算累加和
				}
				System.out.println("正数的个数"+p);
				System.out.println("负数的个数"+k);
				System.out.println("平均值是"+num/i);			// 计算平均值
			}
		}

