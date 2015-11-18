package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class CircleArea extends Frame implements ActionListener{
		static TextField tf1 = new TextField();
		static TextField tf2 = new TextField();
		static Button bt1 = new Button("Բ�뾶");
		static Button bt2 = new Button("Բ���");
		public static void main(String[] args) {
			CircleArea circle = new CircleArea();
			circle.setLayout(null);
			circle.setBackground(Color.cyan);
			circle.setVisible(true);
			circle.setSize(300, 200);
			circle.add(bt1);	circle.add(bt2);
			circle.add(tf1);	circle.add(tf2);
			bt1.setBackground(Color.cyan);
			bt1.setBounds(new Rectangle(25, 80, 70, 25));
			tf1.setBounds(new Rectangle(140, 80, 70, 25));
			bt2.setBounds(new Rectangle(25, 130, 70, 25));
			tf2.setBounds(new Rectangle(140, 130, 70, 25));
			bt2.setBackground(Color.cyan);
			bt2.addActionListener(circle);				// ע���¼�������
		}
		public void actionPerformed(ActionEvent e) {
			String s = tf1.getText();					// ��ȡ�ı����е�����
			int i = Integer.parseInt(s);
			float d = (float)Math.PI*i*i;					// ����Բ���
			String str = String.valueOf(d);		
			tf2.setText(str);							// ��Բ�����ֵ���뵽�ı�����
		}
	}
