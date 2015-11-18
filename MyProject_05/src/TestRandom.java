	import java.util.Random;
		public class TestRandom {
			public static void main(String[] args) {
				Random r1 = new Random();
				Random r2 = new Random(100);
				Random r3 = new Random(100);
				System.out.println(r1.nextInt());				// 产生任意大小的随机整数
				System.out.println(r1.nextBoolean());
				System.out.println(r1.nextDouble());
				System.out.println(r1.nextFloat());
				System.out.println(r1.nextLong());
				System.out.println(r1.nextInt(100));			// 产生0至100的随机整数
				System.out.println(r2.nextInt()); 
				System.out.println(r3.nextInt());
			}
	}

