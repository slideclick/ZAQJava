package regex;
	import java.util.*;
	public class TestScanner {
		public static void main(String[] args){
			Scanner scanner = new Scanner("192.168.1.99");
			scanner.useDelimiter("\\s*\\.\\s*");					// ʹ��"."��Ϊ�����
			while(scanner.hasNextInt())
				System.out.println(scanner.nextInt());
		}
	}

