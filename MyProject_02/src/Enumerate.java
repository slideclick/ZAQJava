public class Enumerate {
		public static void main(String[] args) {
			int m = 0;
			int s = 0;
			int i = 0;
			for (m = 2; m < 1000; m++) {
				s = 0;
				for (i = 1; i < m; i++)
					if ((m % i) == 0)
						s = s + i;					// ��������֮��
				if (s == m) {						// �жϸ���������֮���Ƿ���ڸ�������
					System.out.print(m+"\t"+"���������ǣ�");
					for (i = 1; i < m; i++) {
						if (m % i == 0) {
							System.out.print(i + "   ");	// ��������ĸ�������
						}
					}
					System.out.println();
				}
			}
		}
	}
