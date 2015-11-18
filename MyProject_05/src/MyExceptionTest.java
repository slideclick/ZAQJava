class MyException1 extends Exception {
		int num;
		MyException1(int a) {
			num = a;
		}
		public String toString() {
			return num + "<10!\r\nֵ�������10";
		}
	}
	class MyException2 extends Exception {
		int num;
		MyException2(int a) {
			num = a;
		}
		public String toString() {
			return num + ">100!\r\nֵ����С��100";
		}
	}
	class MyExceptionTest {
		static void makeException(int a) throws MyException1, MyException2 {
			if (a < 10)
				throw new MyException1(a);
			if (a > 100)
				throw new MyException2(a);
			System.out.println("û�в�������");
		}
		public static void main(String args[]) {
			int a;
			try {
				a = Integer.parseInt(args[0]);
				makeException(a);
				System.out.println("a=" + a);
			} catch (MyException1 e) {
				System.out.println("������һ�����⣺\r\n" + e);
			} catch (MyException2 e) {
				System.out.println("�����ڶ�������:\r\n" + e);
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
