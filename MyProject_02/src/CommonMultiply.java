public class CommonMultiply {
		public static void main(String[] args) {
			int m, n, r, gcd, lcm = 0;
			m = Integer.parseInt(args[0]);	 			// 把字符串转换为整形
			n = Integer.parseInt(args[1]);
			lcm = m * n;
			while ((r = m % n) != 0) {
				m = n;
				n = r;
			}
			gcd = n;
			lcm = lcm / gcd;
			System.out.println("最大公约数:"+gcd); 		// 打印出最大公约数
				System.out.println("最小公倍数:"+lcm); 	// 打印出最小公倍数
		}
	}
