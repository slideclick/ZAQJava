import java.util.*;
	import java.text.*;
	public class CalculateWeekDay {
		public static void main(String[] args) {
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");	// 格式化日期					System.out.println(f.format(date));
			String str = f.format(date);
			String str1[] = str.split("-"); 					// 分割日期字符串
			int year = Integer.parseInt(str1[0]);				// 使用包装类把字符型转换为整型
			int month = Integer.parseInt(str1[1]);
			int day = Integer.parseInt(str1[2]);
			int total, week, i;
			boolean leap = false;
			leap = (year % 400 == 0) | (year % 100 != 0) & (year % 4 == 0);	// 判断当年是否是闰年
			week = 1; 								// 起始日1979-12-31是monday
			total = year - 1980 + (year - 1980 + 3) / 4;		// 计算total的初值
			//计算当年前几月的累计天数与total的初值之和
			for (i = 1; i <= month - 1; i++) {				
				switch (i) {							// 判断当前月份
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
			total = total + day;						// 将本月天数加到total上
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

