import java.util.Arrays;
	public class StringBufferDemo {
		public static void main(String[] args) {
			String s = "JavaavaJ";
			char[] str = s.toCharArray();				// ����һ��char����
			boolean b =true;
			int i = str.length-1;
			int k = i ;
			for(int j =0;j<k&&b;j++,i--){
				if(str[j]!=str[i])					// ����ȣ����ǻ��ģ�����ѭ��
					b = false;
			}
			if (b==true){
				System.out.println("�ַ���"+s+"�ǻ���");
			}
			else{
				System.out.println("�ַ���"+s+"���ǻ���");
			}
		}
	}

