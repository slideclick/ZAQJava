public class MainOfCommand {
		public static void main(String[] args) {
			int i = Integer.parseInt(args[0]); 					// ��ȡ��һ�������в���
			int j = Integer.parseInt(args[2]); 					// ��ȡ�����������в���
			int num = 0; 								// ������
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
