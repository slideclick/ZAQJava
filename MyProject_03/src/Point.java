public class Point {
		private double x; 								 // x�����
		private double y; 								 // y�����
		public Point(double x, double y) {						 // ���췽��
			this.x = x;
			this.y = y;
		}
		public double radius() { 							// ��õ�ļ�����뾶
			return Math.sqrt(x * x + y * y);
		}
		public double angle() {								 // ��õ�ļ�����
			return (180 / 3.14159) * Math.atan2(y, x);
		}
		public static void main(String[] args) {
			Point p1 = new Point(10, 10);
			System.out.print("x =" + p1.x + "  ");				 // ��ӡx�����
			System.out.print("y =" + p1.y + "  ");				 // ��ӡx�����
			int i = (int) p1.angle(); 						 // ��double��ǿ��ת��Ϊ����
			int j = (int) p1.radius();
			System.out.print("radius =" + i + "  ");				 // ��ӡ��ļ�����뾶
			System.out.print("angle =" + j + "  "); 				 // ��ӡ��ļ�����
			System.out.println();
			Point p2 = new Point(15, 18);
			i = (int) p2.angle();
			j = (int) p2.radius();
			System.out.print("x =" + p2.x + "  ");
			System.out.print("y =" + p2.y + "  ");
			System.out.print("radius =" + i + "  ");
			System.out.print("angle =" + j + "  ");
		}
	}

