import java.util.*;
import java.text.*;
public class TestDateFormat {
	public static Date parseDate(String text, String format) {
		try {
			return new SimpleDateFormat(format).parse(text);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd-EEEE-hh-mm-ss");
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy/MM/dd/EEEE/hh/mm/ss");
		System.out.println(f.format(date));
		System.out.println(f1.format(date));
		Date d1 = parseDate("12-23-2008", "MM-dd-yyyy");
		System.out.println(d1);
		Date d2 = parseDate("2008/12/25 10:53:54", "yyyy/MM/dd hh:mm:ss");
		System.out.println(d2);
	}
}
