	package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class TestPrime {
		static TextField tf1 = new TextField();
		static TextField tf2 = new TextField();
		static TextField tf3 = new TextField();
		// �����д�ֱ��ˮƽ���������ı���
		static TextArea ta = new TextArea("", 5, 10, TextArea.SCROLLBARS_BOTH);						static TextField tf4 = new TextField();
		static int num = 0;
		public static void main(String[] args) {
			Frame f = new Frame("��a��b֮�������");
			f.setBackground(Color.cyan);
			f.setSize(new Dimension(500, 400));
			f.setLayout(null);
			f.setLocation(300, 300);
			Button bt1 = new Button("��a��b֮�������");
			bt1.setBackground(Color.cyan);
			bt1.addActionListener(new GetAction());
			Button bt2 = new Button("��������");
			bt2.setBackground(Color.cyan);
			Label l1 = new Label("����a��ֵ");
			Label l2 = new Label("����b��ֵ");
			Label l3 = new Label("ÿ����ʾ����");
			tf1.setBounds(new Rectangle(40, 70, 70, 25));
			tf2.setBounds(new Rectangle(130, 70, 70, 25));
			tf3.setBounds(new Rectangle(220, 70, 70, 25));
			ta.setEditable(true);
			ta.setText("");
			ta.setBackground(Color.white);
			ta.setBounds(new Rectangle(40, 120, 400, 200));
			l1.setBounds(new Rectangle(40, 40, 60, 25));
			l2.setBounds(new Rectangle(130, 40, 60, 25));
			l3.setBounds(new Rectangle(220, 40, 120, 25));
			bt1.setBounds(new Rectangle(340, 40, 120, 25));
			bt2.setBounds(new Rectangle(40, 350, 50, 25));
			tf4.setBounds(new Rectangle(130, 350, 70, 25));
			f.add(l1);f.add(l2);f.add(l3);
			f.add(bt1);f.add(bt2);
			f.add(ta);
			f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);
			f.setLayout(null);
			f.setVisible(true);
			f.addWindowListener(new WindowHandler11());		// ע���¼�������
		}
	}
	// ********����windowClosing���ǵ����ڹر�ʱ�Ĵ�����**********
	class WindowHandler11 extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(1); // �رմ���
		}
	}
	class GetAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String text1 = TestPrime.tf1.getText();				// ��ȡ�ı����е�����
			String text2 = TestPrime.tf2.getText();
			String text3 = TestPrime.tf3.getText();
			int a, b, c;
			a = Integer.parseInt(text1); 						// ���ַ�������ת��Ϊ����
			b = Integer.parseInt(text2);
			c = Integer.parseInt(text3);
			boolean flag;
			int m, p, count = 0;
			for (m = a; m <= b; m++) {
				flag = true;
				for (p = 2; p <= m / 2; p++)					// �ж��Ƿ�������
					if (m % p == 0) {
						flag = false;
						break;
					}
				if (flag) { 
					String str = String.valueOf(m);			// ������ת��Ϊ�ַ�������
					TestPrime.ta.append(str + "    ");			// ������д�뵽�ı�����
					count++;
					TestPrime.num++;
					if (count % c == 0) { 					// ÿ����ֻ���c������
						TestPrime.ta.append("\n");
					}
				}
			}
			String str = String.valueOf(TestPrime.num);
			TestPrime.tf4.setText(str);
		}
	}

