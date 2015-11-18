import java.io.BufferedReader;
	import java.io.*;
	import java.util.regex.*;
	public class EmailSpider {
		public static void main(String[] args) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("d:\\test.txt"));
				String line = "";
				while((line=br.readLine()) != null) {
					parse(line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private static void parse(String line) {
			Pattern p = Pattern.compile("[\\w[.]]+@[\\w[.]]+\\.[\\w]+");  // ����������ʽ
			Matcher m = p.matcher(line);					   // ƥ�������ַ
			while(m.find()) {
				System.out.println(m.group());				   // ��ӡƥ��������ַ
			}
		}
	}

