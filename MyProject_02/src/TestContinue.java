public class TestContinue {
		public static void main(String[] args) {
			int n = 0;
			int i = 0;
			for (n = 100; n <= 200; n++) {
				if (n % 3 != 0)
					continue;						// ���ܱ�3��������������ѭ��
				i++;
				System.out.print(n + "   ");
				if (i % 10 == 0) {					  	// ÿ10����һ��
					System.out.println();
				}
			}
		}
	}
