package regex;
	import java.util.regex.*;
	public class GetNumber {
		public static void main(String[] args) {
			int[] arr = new int[10];						// 创建1个整型数组
			Pattern p = Pattern.compile("(\\d{1,4})");		// 编译正则表达式，要求1个到4个数字
			String s = "c789yz45!786*+56abc123456789";
			Matcher m = p.matcher(s);					// 对字符串进行匹配
			int i =0;
			while(m.find()) {							// 寻找与指定模式匹配的下一个子序列
				int j = 0;
				j = Integer.parseInt(m.group());			// 将字符串类型转换为整型
				arr[i]= j;
				i++;
			}
			for(int c = 0;c<i;c++){
				System.out.println(arr[c]);				// 打印数组的内容
			}
		}
	}

