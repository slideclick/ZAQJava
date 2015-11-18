package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class CircleArea extends Frame implements ActionListener{
		static TextField tf1 = new TextField();
		static TextField tf2 = new TextField();
		static Button bt1 = new Button("圆半径");
		static Button bt2 = new Button("圆面积");
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
			bt2.addActionListener(circle);				// 注册事件监听器
		}
		public void actionPerformed(ActionEvent e) {
			String s = tf1.getText();					// 获取文本框中的内容
			int i = Integer.parseInt(s);
			float d = (float)Math.PI*i*i;					// 计算圆面积
			String str = String.valueOf(d);		
			tf2.setText(str);							// 把圆面积的值放入到文本框中
		}
	}
