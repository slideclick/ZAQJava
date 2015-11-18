import java.util.*;
	import java.text.*;
	public class CalculateWeekDay {
		public static void main(String[] args) {
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");	// ��ʽ������					System.out.println(f.format(date));
			String str = f.format(date);
			String str1[] = str.split("-"); 					// �ָ������ַ���
			int year = Integer.parseInt(str1[0]);				// ʹ�ð�װ����ַ���ת��Ϊ����
			int month = Integer.parseInt(str1[1]);
			int day = Integer.parseInt(str1[2]);
			int total, week, i;
			boolean leap = false;
			leap = (year % 400 == 0) | (year % 100 != 0) & (year % 4 == 0);	// �жϵ����Ƿ�������
			week = 1; 								// ��ʼ��1979-12-31��monday
			total = year - 1980 + (year - 1980 + 3) / 4;		// ����total�ĳ�ֵ
			//���㵱��ǰ���µ��ۼ�������total�ĳ�ֵ֮��
			for (i = 1; i <= month - 1; i++) {				
				switch (i) {							// �жϵ�ǰ�·�
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						total = total + 31;
					break;
					case 4:
					case 6:
					case 9:
					case 11:
						total = total + 30;
						break;
					case 2:
						if (leap)
							total = total + 29;
						else
							total = total + 28;
						break;
				}
			}
			total = total + day;						// �����������ӵ�total��
			week = (week + total) % 7;
			System.out.print("today " + year + "-" + month + "-" + day + " is ");
			switch (week) {
			case 0:
				System.out.println("Sunday");
				break;
			case 1:
				System.out.println("Monday");
				break;
			case 2:
				System.out.println("Tuesday");
				break;
			case 3:
				System.out.println("Wednesday");
				break;
			case 4:
				System.out.println("Thursday");
				break;
			case 5:
				System.out.println("Friday");
				break;
			case 6:
				System.out.println("Saturday");
				break;
			}
		}
	}

