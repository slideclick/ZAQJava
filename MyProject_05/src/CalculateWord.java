public class CalculateWord {
		public static void main(String[] args) {
			String data = "ab+12cd*123fdfg%^&()as23BG";
			int count = 0; 								//��������
			int llen = 0; 								//����ʳ���
			int slen = Integer.MAX_VALUE; 					//��̵��ʳ���
			int tlen = 0; 								//�����ܵĳ���
			int wlen = 0; 								//��ǰ���ʳ���
			boolean inword = false; 		// ��Ϊtrue����ʾ��ǰ״̬�ڵ����ڣ������ڵ�����
			char ch;
			for (int i = 0; i < data.length(); i++) {
				ch = data.charAt(i);
				if (!inword) {							//�жϵ�ǰ�Ƿ��ڵ�����
					if (Character.isLetter(ch)) {				//�жϵ�ǰ�����Ƿ��ǵ���
						inword = true;
						count++;
						wlen = 1;
					}
				} else {
					if (Character.isLetter(ch)) {				
						wlen++; 						//��ǰ���ʳ���Ϊ1
					} else {
						inword = false;
						tlen += wlen;			 		//�����µĵ��ʵ��ܳ���
						if (llen < wlen)
							llen = wlen;	 			//�µ���ĵ��ʳ���
						if (slen > wlen)
							slen = wlen;	 			//�µ���̵ĵ��ʳ���
					}
				}
			}
			// *********�����ڵ����ڽ����ģ�Ҫ�����һ�����ʼ�������***********
			if (inword) { 
				tlen += wlen;
				if (llen < wlen)
					llen = wlen;
				if (slen > wlen)
					slen = wlen;
			}
			System.out.println("ԭ����" + data);
			System.out.println("����������" + count);
			System.out.println("����ȣ�" + llen);
			System.out.println("��̳��ȣ�" + slen);
			System.out.println("�����ܳ���" + tlen);
			System.out.println("ƽ�����ȣ�" + (float) tlen / count);
		}
	}

