package regex;
	import java.util.regex.*;
	public class TestReplace {
		public static void main(String[] args) {
			Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);	// 不区分大小写
			Matcher m = p.matcher("Java java JAva JAVA I love JAVA you dislike Java ");
			StringBuffer buf = new StringBuffer();
			int i=0;
			while(m.find()) {
				i++;
				if(i%2 == 0) {			
					m.appendReplacement(buf, "JAVA");		// 偶数序列的转换成大写
				} else {
					m.appendReplacement(buf, "java");		// 奇数序列的转换成小写
				}
			}
			m.appendTail(buf);
			System.out.println(buf);
		}
	}

