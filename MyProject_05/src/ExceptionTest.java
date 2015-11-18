public class ExceptionTest {
		public static void main(String args[]) {
			for (int i = 0; i < 3; i++) {
				int k;
				try {
					switch (i) {
					case 0: 
						int a = 0;
						k = 10 / a;						// 除数为0异常
						break;
					case 1: 							// 空指针异常
						int b[] = null;
						k = b[0];
						break;
					case 2: 
						int c[] = new int[5];
						k = c[5];						// 数组索引越界异常
						break;
					}
				} catch (Exception e) {
					System.out.println("\n异常" + i + "\n");
					System.out.println(e);
				}
			}
		}
	}

