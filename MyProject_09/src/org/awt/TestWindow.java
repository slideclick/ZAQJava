package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class TestWindow {
		static TextField tf = new TextField();
		static TextArea ta = new TextArea();
		public static void main(String[] args){
			Frame f = new Frame();
			ta.setBackground(Color.cyan);
			tf.setBackground(Color.cyan);
			f.setLayout(new BorderLayout());					// ʹ�ñ߽粼�ֹ�����
			f.add(tf,BorderLayout.SOUTH);
			f.add(ta,BorderLayout.NORTH);
			f.setVisible(true);
			f.pack();
			tf.addActionListener(new TFListener1());
			f.addWindowListener(new WindowAdapter() {		// �رմ���
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}
	}
	class TFListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = TestWindow.tf.getText().trim();		// ��ȡ�ı����е�����
			int m = 0; int n = 0; int s = 0;	int i = 0;
			n = Integer.parseInt(str);					// ���ַ�������ת��Ϊ����
			for (m = 2; m < n; m++) {
				s = 0;
				for (i = 1; i < m; i++)
					if ((m % i) == 0)
						s = s + i;					// ��������֮��
				if (s == m) {						// �жϸ���������֮���Ƿ���ڸ�������
					TestWindow.ta.append(m+"\t"+"���������ǣ�");
					for (i = 1; i < m; i++) {
						if (m % i == 0) {
							TestWindow.ta.append(i + "   ");		// ����Ϣ��ӵ�������
						}
					}
					TestWindow.ta.append("\n");					// ��ӻس���
				}
			}
		}
	}

