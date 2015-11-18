public class Calculate {
		public static void main(String[] args){
			int i = 1 ;
			int num = 0;
			int s = Integer.parseInt(args[0]);						// 把字符串转换为整形
			while(i <= s ){
				num = num +i;
			 	i +=2;
			}
			System.out.println("1 + 3 + 5 +...+"+s+" = " + num);		// 打印出累加和	
		}
	}

