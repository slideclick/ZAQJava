public class CommonMultiply {
		public static void main(String[] args) {
			int m, n, r, gcd, lcm = 0;
			m = Integer.parseInt(args[0]);	 			// ���ַ���ת��Ϊ����
			n = Integer.parseInt(args[1]);
			lcm = m * n;
			while ((r = m % n) != 0) {
				m = n;
				n = r;
			}
			gcd = n;
			lcm = lcm / gcd;
			System.out.println("���Լ��:"+gcd); 		// ��ӡ�����Լ��
				System.out.println("��С������:"+lcm); 	// ��ӡ����С������
		}
	}
