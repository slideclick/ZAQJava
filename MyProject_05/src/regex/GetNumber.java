package regex;
	import java.util.regex.*;
	public class GetNumber {
		public static void main(String[] args) {
			int[] arr = new int[10];						// ����1����������
			Pattern p = Pattern.compile("(\\d{1,4})");		// ����������ʽ��Ҫ��1����4������
			String s = "c789yz45!786*+56abc123456789";
			Matcher m = p.matcher(s);					// ���ַ�������ƥ��
			int i =0;
			while(m.find()) {							// Ѱ����ָ��ģʽƥ�����һ��������
				int j = 0;
				j = Integer.parseInt(m.group());			// ���ַ�������ת��Ϊ����
				arr[i]= j;
				i++;
			}
			for(int c = 0;c<i;c++){
				System.out.println(arr[c]);				// ��ӡ���������
			}
		}
	}

