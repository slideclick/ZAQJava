import java.util.*;
	public class TestString {
		public static void main(String[] args) {
			String data = "This is a String";
			StringTokenizer st = new StringTokenizer(data);		
			int count = st.countTokens(); 				// 计算单词总数
			System.out.println("原串是：" + data);
			System.out.println("各个单词如下：");
			while (st.hasMoreTokens()) {				// 还有子串时
				String s = st.nextToken(); 				// 取出下一个子串
				System.out.println(s);
			}
			System.out.println("单词总数：" + count);
		}
	}
