public class PrimeNumber {
	boolean isPrime(int n) { 					// 判断是否是质数
		for (int i = 2; i <= n / 2; i++)
			if (n % i == 0)					// 能被整除，则不是质数
				return false;
		return true;
	}
	void printPrime(int m) {
		int j = 0;
		for (int i = 2; i <= m; i++){
			if (isPrime(i)){
				j++;
				if(j%10==0){				// 每10个质数一行
					System.out.print(" " + i);
					System.out.println(); 		// 换行
				}
				else  
					System.out.print(" " + i);
			}
		}	
	}
	public static void main(String[] args) {
		PrimeNumber pn = new PrimeNumber();
		pn.printPrime(100); 					// 打印出100 之内的所有质数
		
	}
}

