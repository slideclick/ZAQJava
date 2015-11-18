public class Point {
		private double x; 								 // x轴分量
		private double y; 								 // y轴分量
		public Point(double x, double y) {						 // 构造方法
			this.x = x;
			this.y = y;
		}
		public double radius() { 							// 获得点的极坐标半径
			return Math.sqrt(x * x + y * y);
		}
		public double angle() {								 // 获得点的极坐标
			return (180 / 3.14159) * Math.atan2(y, x);
		}
		public static void main(String[] args) {
			Point p1 = new Point(10, 10);
			System.out.print("x =" + p1.x + "  ");				 // 打印x轴分量
			System.out.print("y =" + p1.y + "  ");				 // 打印x轴分量
			int i = (int) p1.angle(); 						 // 将double型强制转换为整形
			int j = (int) p1.radius();
			System.out.print("radius =" + i + "  ");				 // 打印点的极坐标半径
			System.out.print("angle =" + j + "  "); 				 // 打印点的极坐标
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

