public class LeapYear {
		public static void main(String[] args){
			// args[0]��ʾ�����еĵ�һ���������������ַ���ת��Ϊ����
			int year = Integer.parseInt(args[0]);
			int leap;								// 1��ʾ���꣬0��ʾ��������
			if(year % 4 == 0){						// �ж��ܷ�4����
				if (year %100 ==0){
					if (year %400==0)
						leap = 1;
					else leap = 0;
				}
				else 
					leap =1;						// ������
				}
				else leap = 0;
			if (leap==1)
				System.out.println(year +"��������");
			else 
				System.out.println(year +"�겻������");
		}
	}

