import java.util.Arrays;
	public class StringBufferDemo {
		public static void main(String[] args) {
			String s = "JavaavaJ";
			char[] str = s.toCharArray();				// 返回一个char数组
			boolean b =true;
			int i = str.length-1;
			int k = i ;
			for(int j =0;j<k&&b;j++,i--){
				if(str[j]!=str[i])					// 不相等，则不是回文，结束循环
					b = false;
			}
			if (b==true){
				System.out.println("字符串"+s+"是回文");
			}
			else{
				System.out.println("字符串"+s+"不是回文");
			}
		}
	}

