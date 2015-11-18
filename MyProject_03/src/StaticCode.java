public class StaticCode {
		static int i=1;
		public StaticCode(){						
			System.out.println("initialize construct method"+i++);
		}
		static {								// 第一个静态代码块
			System.out.println("initialize the first static block"+i++);
		}
		static {								// 第二个静态代码块
			System.out.println("initialize the second static block"+i++);
		}
		public static void main(String[] args){
			new StaticCode();
			new StaticCode();
		}
}

