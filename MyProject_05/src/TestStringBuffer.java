public class TestStringBuffer {
		public static void main(String[] args){
			String s = "123";
			char[] a = {'a','b','c'};
			StringBuffer sb1 = new StringBuffer(s);
			sb1.append("struts").append("hiberante").append("spring");	//×·¼Ó×Ö·ûÐòÁÐ
			System.out.println(sb1);				
			StringBuffer sb2 = new StringBuffer("ÖÐ¹ú");
			for(int i = 0;i< 10;i++){
				sb2.append(i);
			}
			System.out.println(sb2);
			sb2.delete(5, sb2.length());							//ÒÆ³ý×Ö·ûÐòÁÐ
			System.out.println(sb2);
			sb2.insert(3,a);									//²åÈë×Ö·ûÐòÁÐ
			System.out.println(sb2);
			System.out.println(sb2.reverse());						//ÄæÐò
		}
	}

