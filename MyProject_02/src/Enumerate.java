public class Enumerate {
		public static void main(String[] args) {
			int m = 0;
			int s = 0;
			int i = 0;
			for (m = 2; m < 1000; m++) {
				s = 0;
				for (i = 1; i < m; i++)
					if ((m % i) == 0)
						s = s + i;					// 计算因子之和
				if (s == m) {						// 判断该数的因子之和是否等于该数自身
					System.out.print(m+"\t"+"它的完数是：");
					for (i = 1; i < m; i++) {
						if (m % i == 0) {
							System.out.print(i + "   ");	// 输出完数的各个因子
						}
					}
					System.out.println();
				}
			}
		}
	}
