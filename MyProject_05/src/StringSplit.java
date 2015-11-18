public class StringSplit {
		public static void print(String[] s) {
			for (int i = 0; i < s.length; i++)
				System.out.print(s[i] + " ");
			System.out.println();
		}
		public static void main(String[] args) throws Exception {
			String[] result;							
			String map = "value = hello";
			result = map.split("="); 					// result={"value","hello"}
			print(result);	
			String time = "08:30:36";
			result = time.split(":"); 					// result={"08","30","36"}
			print(result);
			String student = "Tom,20,university";
			result = student.split(",");					// result={"Tom","20","university"}
			print(result);
		}
	}

