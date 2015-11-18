public class Test {
	public static void main(String[] args) {
		int i1 = 5, i2 =10;
		int i = (i2++);
		System.out.println("i="+i);
		System.out.println("i2="+i2);
		i=(++i2);
		System.out.println("i="+i);
		System.out.println("i2="+i2);
		i=(--i1);
		System.out.println("i="+i);
		System.out.println("i1="+i1);
		i =(i1--);
		System.out.println("i="+i);
		System.out.println("i1="+i1);
	}
}
