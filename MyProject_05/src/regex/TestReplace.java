package regex;
	import java.util.regex.*;
	public class TestReplace {
		public static void main(String[] args) {
			Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);	// �����ִ�Сд
			Matcher m = p.matcher("Java java JAva JAVA I love JAVA you dislike Java ");
			StringBuffer buf = new StringBuffer();
			int i=0;
			while(m.find()) {
				i++;
				if(i%2 == 0) {			
					m.appendReplacement(buf, "JAVA");		// ż�����е�ת���ɴ�д
				} else {
					m.appendReplacement(buf, "java");		// �������е�ת����Сд
				}
			}
			m.appendTail(buf);
			System.out.println(buf);
		}
	}

