import java.util.GregorianCalendar;
	import java.util.Date;
	import java.text.DateFormat;
	public class CalendarDate {
		public static void main(String[] args) {
			//***********�趨���ں�ʱ���ʽ**********************
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);	
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			System.out.println("System Date: " + dateFormat.format(cal.getTime()));
			cal.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.MONDAY);
			System.out.println("After Setting Day of Week to Friday: "
					+ dateFormat.format(cal.getTime()));
			int monday11Count = 0;
			while (monday11Count < 10) {
				cal.add(GregorianCalendar.DAY_OF_MONTH, 7);	 //����7��õ���һ������һ
				//************�ж�����һ�����Ƿ���11��**************
				if (cal.get(GregorianCalendar.DAY_OF_MONTH) == 11) {	
					monday11Count++;
					System.out.println(dateFormat.format(cal.getTime()));
				}
			}
		}
	}

