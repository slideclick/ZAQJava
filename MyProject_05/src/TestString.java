import java.util.*;
	public class TestString {
		public static void main(String[] args) {
			String data = "This is a String";
			StringTokenizer st = new StringTokenizer(data);		
			int count = st.countTokens(); 				// ���㵥������
			System.out.println("ԭ���ǣ�" + data);
			System.out.println("�����������£�");
			while (st.hasMoreTokens()) {				// �����Ӵ�ʱ
				String s = st.nextToken(); 				// ȡ����һ���Ӵ�
				System.out.println(s);
			}
			System.out.println("����������" + count);
		}
	}
