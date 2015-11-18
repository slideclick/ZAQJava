package org.swing;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	public class TextAreaDemo extends JFrame {
			static JTextField tf1 = new JTextField();
			static JTextField tf2 = new JTextField();
			static JTextField tf3 = new JTextField();
			static TextArea ta = new TextArea(); 
			static JTextField tf4 = new JTextField();
			static int num = 0;	
			//*******��ʾ������**************
			JScrollPane jp = new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			public TextAreaDemo() {
				setBackground(Color.cyan);
				Container contentPane = getContentPane();
				contentPane.setLayout(null);							// ȡ�����ֹ�����
				contentPane.setBackground(Color.cyan);				// ���ô��ڵ���ɫ
				contentPane.add(jp);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// �رմ���
				setVisible(true);									// ʹ���ڿɼ�
				setLocation(300, 300);
				setSize(new Dimension(500, 400));
				Button bt1 = new Button("��a��b֮�������");
				bt1.setBackground(Color.cyan);
				bt1.addActionListener(new GetAction()); 				// ע���¼�������
				Button bt2 = new Button("��������");
				bt2.setBackground(Color.cyan);
				JLabel l1 = new JLabel("����a��ֵ");
				JLabel l2 = new JLabel("����b��ֵ");
				JLabel l3 = new JLabel("ÿ����ʾ����");
				tf1.setBounds(new Rectangle(40, 50, 70, 25));
				tf2.setBounds(new Rectangle(130, 50, 70, 25));
				tf3.setBounds(new Rectangle(220, 50, 70, 25));
				ta.setEditable(true);
				ta.setText("");
				ta.setBackground(Color.white);						// �����ı�������ɫ
				ta.setBounds(new Rectangle(40, 100, 400, 200));
				l1.setBounds(new Rectangle(40, 20, 60, 25));
				l2.setBounds(new Rectangle(130, 20, 60, 25));
				l3.setBounds(new Rectangle(220, 20, 120, 25));
				bt1.setBounds(new Rectangle(340, 20, 120, 25));
				bt2.setBounds(new Rectangle(40, 330, 50, 25));
				tf4.setBounds(new Rectangle(130, 330, 70, 25));
				contentPane.add(l1);								// �������
				contentPane.add(l2);
				contentPane.add(l3);
				contentPane.add(bt1);
				contentPane.add(bt2);
				contentPane.add(ta);
				contentPane.add(tf1);
				contentPane.add(tf2);
				contentPane.add(tf3);
				contentPane.add(tf4);
			}
			public static void main(String[] args) {
				TextAreaDemo test = new TextAreaDemo();
			}
		}
	class GetAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String text1 = TextAreaDemo.tf1.getText(); 			// ��ȡ�ı����е�����
				String text2 = TextAreaDemo.tf2.getText();
				String text3 = TextAreaDemo.tf3.getText();
				int a, b, c;
				a = Integer.parseInt(text1); 						// ���ַ�������ת��Ϊ����
				b = Integer.parseInt(text2);
				c = Integer.parseInt(text3);
				boolean flag;
				int m, p, count = 0;
				for (m = a; m <= b; m++) {
					flag = true;
					for (p = 2; p <= m / 2; p++)
						if (m % p == 0) {						// �ж��Ƿ�������
							flag = false;
							break;
						}
					if (flag) {
						String str = String.valueOf(m); 			// ������ת��Ϊ�ַ�������
						TextAreaDemo.ta.append(str + "    ");		// ������д�뵽�ı�����
						count++;
						TextAreaDemo.num++;
						if (count % c == 0) { 					// ÿ����ֻ���c������
							TextAreaDemo.ta.append("\n");
						}
					}
				}
				String str = String.valueOf(TextAreaDemo.num);
				TextAreaDemo.tf4.setText(str);
			}
	}

