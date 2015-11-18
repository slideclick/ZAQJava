	public class TestInvert {
		//******返回n的反序数,若n=1234,则返回4321******
		static int reverse(int n, int v) { 
			return n == 0 ? v : reverse(n / 10, v * 10 + n % 10);
		}
		public static void main(String[] args) {
			System.out.println("1234的反序打印是：" + reverse(1234, 0));
		}
	}

