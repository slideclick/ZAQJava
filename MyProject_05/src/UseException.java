import java.io.*;
	public class UseException {
		public static void main(String[] args) {
			try {
				int a , b;
				a = Integer.parseInt(args[0]);
				b = Integer.parseInt(args[1]);
				System.out.println(a+" /" + b + " = " + (a/b));
			} catch (ArithmeticException e) {
				System.out.println("������һ���쳣����������Ϊ0!");
			}
		}
	}

