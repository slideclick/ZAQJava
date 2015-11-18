public class GetPrime {
		public static void main(String args[]) {
			int a, b, c;
			// 读取命令行中的参数并把字符串类型转换为整型
			a = Integer.parseInt(args[0]);									
			b = Integer.parseInt(args[1]);
			c = Integer.parseInt(args[2]);
			boolean flag;
			int m, p, count = 0;
			for (m = a; m <= b; m++) {
				flag = true;
				for (p = 2; p <= m / 2; p++)
					if (m % p == 0) {
						flag = false;
						break;
					}
				if (flag) {
					System.out.print(m + "\t");
					count++;
					if (count % c == 0)				// 每行中只输出c个素数
						System.out.println();
				}
			}
		}
	}
