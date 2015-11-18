class Citizen{
		private static String country = "china";
		private String name = "Tom";
		public static void f1(){
			System.out.println(country);
			//System.out.println(name);				// 不可直接访问非静态成员，只能间接访问
		}
		public void f2(){							// 可访问静态成员
			
			f1();									//或Citizen.f1(); 或 this.f1();
			System.out.println(country);
			System.out.println(name);
		}
	}
	public class TestStaticMethod {
		public static void main(String[] args){
			new TestStaticMethod();
			Citizen.f1();						// 直接通过类名访问f1()
			Citizen citizen = new Citizen();
			citizen.f2();
			citizen.f1();						// 可以通过引用访问f1()
		}
	}
