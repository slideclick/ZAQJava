public class StatisticWords {
		public static void main(String[] args) {
			String s = "I am a student I am studying hard";
			byte[] c =s.getBytes();						// ���ַ���ת��Ϊ�ֽ�����
			int word=0;							// �ж��Ƿ��ǵ��ʵı�ʶ
			int num=0;								// ͳ�Ƶ��ʵĸ���
			int i = c.length;
			for (int j=0;j<i;j++){
				if(c[j]==32){						// �ǿո�
					word =0;
				}else if(word==0){
					word =1;						// ��ʼ���ֵ���
					num++;					
				}
			}
			System.out.println("���ʵ������ǣ�"+num);
		}
	}

