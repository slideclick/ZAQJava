public class MultiplyCalculate {
		public static void main(String[]args){
			long s =1;
			int k = Integer.parseInt(args[0]);					// 把字符串转换为整形	
			for (int i = 1;i <k;i++){
				s = s * i ;
			}
			System.out.println("1 * 2 * 3"+"...* "+k+" = "+ s);		// 打印相乘的结果
		}
	}
