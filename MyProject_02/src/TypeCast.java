public class TypeCast {
		public static void main(String[] args){
			byte b =1;								// �Զ�����ת��
			int i=b;
			long l=b;
			float f=b;
			double d=b;
			char ch='c';    
			int i2 = ch; 							// ת��Ϊ��Ӧ��ASCII��ֵ
			System.out.println("i2:"+i2);
			short s = 99;
			char c=(char)s; 							// ǿ������ת��
			System.out.println("c:"+c);
			byte b1 = (byte)129; 
			System.out.println("b1:"+b1);
		}
	}

