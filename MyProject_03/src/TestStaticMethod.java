class Citizen{
		private static String country = "china";
		private String name = "Tom";
		public static void f1(){
			System.out.println(country);
			//System.out.println(name);				// ����ֱ�ӷ��ʷǾ�̬��Ա��ֻ�ܼ�ӷ���
		}
		public void f2(){							// �ɷ��ʾ�̬��Ա
			
			f1();									//��Citizen.f1(); �� this.f1();
			System.out.println(country);
			System.out.println(name);
		}
	}
	public class TestStaticMethod {
		public static void main(String[] args){
			new TestStaticMethod();
			Citizen.f1();						// ֱ��ͨ����������f1()
			Citizen citizen = new Citizen();
			citizen.f2();
			citizen.f1();						// ����ͨ�����÷���f1()
		}
	}
