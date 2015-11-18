package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class JTextFieldDemo extends JFrame{
		static JTextField tf1 = new JTextField();
		static JTextField tf2 = new JTextField();
		static JTextField tf3 = new JTextField();	
		public JTextFieldDemo(){
			Container contentPane = getContentPane();		// ���ش˴���� contentPane ����	
			contentPane.setLayout(null);					// ȡ�����ֹ�����
			contentPane.setBackground(Color.cyan);		// ���ô��ڵ���ɫ
			setLocation(300, 300);
			setSize(new Dimension(300, 200));
			JLabel l1 = new JLabel("��һ����");
			JLabel l2 = new JLabel("�ڶ�����");
			JLabel l3 = new JLabel("�������");
			Button bt1 = new Button("��Լ���͹�����");
			bt1.setBackground(Color.cyan);
			bt1.addActionListener(new NumAction());					// ע���¼�������
			bt1.setBounds(new Rectangle(80, 120, 120, 25));
			l1.setBounds(new Rectangle(30, 20, 60, 25));
			l2.setBounds(new Rectangle(120, 20, 60, 25));
			l3.setBounds(new Rectangle(210, 20, 120, 25));
			tf1.setBounds(new Rectangle(30, 50, 70, 25));
			tf2.setBounds(new Rectangle(120, 50, 70, 25));
			tf3.setBounds(new Rectangle(210, 50, 70, 25));
			tf3.setEditable(false);
			setVisible(true);										// ���ô���ɼ�
			contentPane.add(l1);contentPane.add(l2);contentPane.add(l3);
			contentPane.add(bt1);
			contentPane.add(tf1);contentPane.add(tf2);contentPane.add(tf3);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// �رմ���
		}
		public static void main(String[] args) {
			JTextFieldDemo fd = new JTextFieldDemo();
		}
	}
	class NumAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int m ,n, r =0;
			int gcd = 0;										// ���Լ��
			int lcm =0;										// ��С������
			m = Integer.parseInt(JTextFieldDemo.tf1.getText());			// ���ַ���ת��Ϊ����
			n = Integer.parseInt(JTextFieldDemo.tf2.getText());			
			lcm = m * n ;
			while((r=m%n)!=0){
				m = n;
				n =r;
			}
			gcd = n;
			lcm = lcm /gcd;
			String str1 = String.valueOf(gcd);						// ���ش��ַ�����ʽ
			String str2 = String.valueOf(lcm);
			String s = str1+"   "+str2;
			JTextFieldDemo.tf3.setText(s);						// ���õ������ı��������
		}
	}

