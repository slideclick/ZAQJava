public class PrimeNumber {
	boolean isPrime(int n) { 					// �ж��Ƿ�������
		for (int i = 2; i <= n / 2; i++)
			if (n % i == 0)					// �ܱ���������������
				return false;
		return true;
	}
	void printPrime(int m) {
		int j = 0;
		for (int i = 2; i <= m; i++){
			if (isPrime(i)){
				j++;
				if(j%10==0){				// ÿ10������һ��
					System.out.print(" " + i);
					System.out.println(); 		// ����
				}
				else  
					System.out.print(" " + i);
			}
		}	
	}
	public static void main(String[] args) {
		PrimeNumber pn = new PrimeNumber();
		pn.printPrime(100); 					// ��ӡ��100 ֮�ڵ���������
		
	}
}

