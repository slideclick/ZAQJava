import java.util.Date;
	import java.sql.*;
	import java.text.DateFormat;
	public class UseDate{
		public static void main(String[] args){
			Date date = new Date();
			System.out.println(date);
			java.sql.Date date1 = new java.sql.Date(0);	
			java.util.Date date2 = date1.valueOf("2009-03-04");				// ����һ����������
			System.out.println(date2);
			DateFormat fullDateFormat = DateFormat.getDateTimeInstance(
					DateFormat.FULL, DateFormat.FULL);				// ���������ڸ�ʽ
			System.out.println(fullDateFormat.format(date));
		}
	}

