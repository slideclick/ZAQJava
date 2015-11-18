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
			Pattern p = Pattern.compile("[\\w[.]]+@[\\w[.]]+\\.[\\w]+");  // 编译正则表达式
			Matcher m = p.matcher(line);					   // 匹配邮箱地址
			while(m.find()) {
				System.out.println(m.group());				   // 打印匹配的邮箱地址
			}
		}
	}

