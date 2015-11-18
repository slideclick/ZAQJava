public class TestMath {
		public static void main(String[] args) {
			int a = 0;
			int b = 0;
			int c = 0;
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
			c = Integer.parseInt(args[2]);
			double area =0;
			double s = 0.0;
			s = 1.0/2*(a+b+c);
			area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
			System.out.println("三角形的面积是"+area);
		}
	}

