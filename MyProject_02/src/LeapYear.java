public class LeapYear {
		public static void main(String[] args){
			// args[0]表示命令行的第一个参数并把它由字符串转换为整型
			int year = Integer.parseInt(args[0]);
			int leap;								// 1表示闰年，0表示不是闰年
			if(year % 4 == 0){						// 判断能否被4整除
				if (year %100 ==0){
					if (year %400==0)
						leap = 1;
					else leap = 0;
				}
				else 
					leap =1;						// 是闰年
				}
				else leap = 0;
			if (leap==1)
				System.out.println(year +"年是闰年");
			else 
				System.out.println(year +"年不是闰年");
		}
	}

