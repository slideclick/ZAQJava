package org.awt;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	public class ContainerListenerDemo extends Frame implements ActionListener {
		// �����д�ֱ��ˮƽ���������ı���
		static TextArea ta = new TextArea("", 5, 10, TextArea.SCROLLBARS_BOTH);							public ContainerListenerDemo() {
			Button bt = new Button("����λ��");
			bt.setBackground(Color.cyan);
			bt.addActionListener(this);			// ��ContainerListener����ע��ΪButton�ļ�����
			bt.setBounds(100, 40, 80, 30);
			setLayout(null);									// ȡ�����ֹ�����
			setBackground(Color.cyan);
			setBounds(20, 20, 300, 300);
			ta.setBounds(45, 75, 220, 200);
			add(bt);
			add(ta);
			setVisible(true);									// ���ô��ڿɼ�
		}
		public void actionPerformed(ActionEvent e) {
			int a = 0;										// ǧλ�ϵ�����
			int b = 0;										// ��λ�ϵ�����
			int c = 0;										// ʮλ�ϵ�����
			int num = 0;									// ������λ���ĸ���
			int i = 110;
			for (i = 1000; i < 10000; i++) {
				a = i / 1000;
				b = (i % 1000 - i % 100) / 100;
				c = (i % 100 - i % 10) / 10;
				if ((i % 11 == 0) && (a == b + c)) {
					String str = String.valueOf(i); 				// ������ת��Ϊ�ַ�������
					ta.append(str + "    ");
					if (++num % 4 == 0) {
						ta.append("\n");
					}
				}
			}
			String str2 = String.valueOf(num); 
			ta.append(str2 + "    ");
		}
		public static void main(String[] args) {
			ContainerListenerDemo cl = new ContainerListenerDemo();
		}
	}

