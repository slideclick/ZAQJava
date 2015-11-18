public class MainOfCommand {
		public static void main(String[] args) {
			int i = Integer.parseInt(args[0]); 					// 获取第一个命令行参数
			int j = Integer.parseInt(args[2]); 					// 获取第三个命令行参数
			int num = 0; 								// 运算结果
			if (args[1].equals("+")) {
				num = i + j;
				System.out.println(i + " + " + j + " = " + num);
			} else if (args[1].equals("-")) {
				num = i - j;
				System.out.println(i + " - " + j + " = " + num);
			} else if (args[1].equals("x")) {
				num = i * j;
				System.out.println(i + " x " + j + " = " + num);
			} else if (args[1].equals("/")) {
				num = i / j;
				System.out.println(i + " / " + j + " = " + num);
			}
		}
	}
