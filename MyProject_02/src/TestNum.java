public class TestNum {
		public static void main(String[] args){
			int i = 0;int j = 0;int k = 0;
			int n = 0;int p = 0;
			for( int m = 100; m <1000; m++){
			i = m /100;								// �õ���λ��
				n = m %100;
				j = n /10;							// �õ�ʮλ��
				k = n %10;							// �õ���λ��
				p = i*i*i+j*j*j+k*k*k;
				if (p==m){
					System.out.println(m);				// ��ӡˮ�ɻ���
				}
			}
		}
	}
