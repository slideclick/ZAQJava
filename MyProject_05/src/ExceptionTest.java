public class ExceptionTest {
		public static void main(String args[]) {
			for (int i = 0; i < 3; i++) {
				int k;
				try {
					switch (i) {
					case 0: 
						int a = 0;
						k = 10 / a;						// ����Ϊ0�쳣
						break;
					case 1: 							// ��ָ���쳣
						int b[] = null;
						k = b[0];
						break;
					case 2: 
						int c[] = new int[5];
						k = c[5];						// ��������Խ���쳣
						break;
					}
				} catch (Exception e) {
					System.out.println("\n�쳣" + i + "\n");
					System.out.println(e);
				}
			}
		}
	}

