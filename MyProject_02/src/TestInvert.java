	public class TestInvert {
		//******����n�ķ�����,��n=1234,�򷵻�4321******
		static int reverse(int n, int v) { 
			return n == 0 ? v : reverse(n / 10, v * 10 + n % 10);
		}
		public static void main(String[] args) {
			System.out.println("1234�ķ����ӡ�ǣ�" + reverse(1234, 0));
		}
	}

