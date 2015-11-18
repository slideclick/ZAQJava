public class TypeCast {
		public static void main(String[] args){
			byte b =1;								// 自动类型转换
			int i=b;
			long l=b;
			float f=b;
			double d=b;
			char ch='c';    
			int i2 = ch; 							// 转换为对应的ASCII码值
			System.out.println("i2:"+i2);
			short s = 99;
			char c=(char)s; 							// 强制类型转换
			System.out.println("c:"+c);
			byte b1 = (byte)129; 
			System.out.println("b1:"+b1);
		}
	}

