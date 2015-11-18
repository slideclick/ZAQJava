import java.io.*;
	public class ThrowExceptionTest {
		public static void main(String[] args) {
			int c;
			try {
				while ((c = System.in.read()) != -1) {
					if (c != 'a')
						throw new Exception("«Î ‰»Î◊÷ƒ∏a!");
					System.out.println(c);
				}
			} catch (IOException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
