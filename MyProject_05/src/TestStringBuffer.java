public class TestStringBuffer {
		public static void main(String[] args){
			String s = "123";
			char[] a = {'a','b','c'};
			StringBuffer sb1 = new StringBuffer(s);
			sb1.append("struts").append("hiberante").append("spring");	//׷���ַ�����
			System.out.println(sb1);				
			StringBuffer sb2 = new StringBuffer("�й�");
			for(int i = 0;i< 10;i++){
				sb2.append(i);
			}
			System.out.println(sb2);
			sb2.delete(5, sb2.length());							//�Ƴ��ַ�����
			System.out.println(sb2);
			sb2.insert(3,a);									//�����ַ�����
			System.out.println(sb2);
			System.out.println(sb2.reverse());						//����
		}
	}

