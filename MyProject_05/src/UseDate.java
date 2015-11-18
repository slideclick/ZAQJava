import java.util.Date;
	import java.sql.*;
	import java.text.DateFormat;
	public class UseDate{
		public static void main(String[] args){
			Date date = new Date();
			System.out.println(date);
			java.sql.Date date1 = new java.sql.Date(0);	
			java.util.Date date2 = date1.valueOf("2009-03-04");				// 返回一个日期类型
			System.out.println(date2);
			DateFormat fullDateFormat = DateFormat.getDateTimeInstance(
					DateFormat.FULL, DateFormat.FULL);				// 完整的日期格式
			System.out.println(fullDateFormat.format(date));
		}
	}

