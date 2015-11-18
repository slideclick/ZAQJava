class MyException1 extends Exception {
		int num;
		MyException1(int a) {
			num = a;
		}
		public String toString() {
			return num + "<10!\r\n值必须大于10";
		}
	}
	class MyException2 extends Exception {
		int num;
		MyException2(int a) {
			num = a;
		}
		public String toString() {
			return num + ">100!\r\n值必须小于100";
		}
	}
	class MyExceptionTest {
		static void makeException(int a) throws MyException1, MyException2 {
			if (a < 10)
				throw new MyException1(a);
			if (a > 100)
				throw new MyException2(a);
			System.out.println("没有产生例外");
		}
		public static void main(String args[]) {
			int a;
			try {
				a = Integer.parseInt(args[0]);
				makeException(a);
				System.out.println("a=" + a);
			} catch (MyException1 e) {
				System.out.println("产生第一个例外：\r\n" + e);
			} catch (MyException2 e) {
				System.out.println("产生第二个例外:\r\n" + e);
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
