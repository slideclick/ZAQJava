import java.io.*;
	public class ThrowsExceptionTest {
		public static void main(String[] args) throws IOException {
			int c;
			while ((c = System.in.read()) != -1)				//�Ӽ��̶�������
				System.out.println(c);
		}
	}

