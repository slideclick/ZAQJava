public class Recurrence {
		public static void main(String[]args) {
			int k = Integer.parseInt(args[0]);						// 把字符串转换为整形
			long num = 0;
			int s = 1;
			for(int i=1;i<=k;i++){
				s *=i;										// s=i!
				num += s;									// num = 1!+ … +i!
			}
			System.out.println("1!+2!+3!"+"+..."+k+"!="+num);		// 打印乘积的累加和
		}
	}

