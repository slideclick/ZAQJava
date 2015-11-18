public class TestContinue {
		public static void main(String[] args) {
			int n = 0;
			int i = 0;
			for (n = 100; n <= 200; n++) {
				if (n % 3 != 0)
					continue;						// 不能被3整除，结束本次循环
				i++;
				System.out.print(n + "   ");
				if (i % 10 == 0) {					  	// 每10个数一行
					System.out.println();
				}
			}
		}
	}
