package org.swing;
	import java.awt.*;
	import javax.swing.*;
	public class MyJPanel {
		public static void main(String args[]) {
			JFrame fr = new JFrame();
			fr.setTitle("JPanel���÷�");
			BorderLayout bl = new BorderLayout();
			fr.getContentPane().setLayout(bl);					// �趨�߽粼�ֹ�����
			JPanel jp = new JPanel(new GridLayout(2, 2));		// �趨���񲼾ֹ�����
			fr.getContentPane().add("Center", jp);
			JLabel jl = new JLabel("this is a test");
			fr.getContentPane().add("South", jl);
			JLabel l1 = new JLabel("First", JLabel.CENTER);
			jp.add(l1);
			JLabel l2 = new JLabel("Second", JLabel.CENTER);
			jp.add(l2);
			JLabel l3 = new JLabel("Third", JLabel.CENTER);
			jp.add(l3);
			Font ft = new Font("Serif", Font.BOLD, 18);
			jl.setFont(ft);
			l1.setFont(ft);
			l2.setFont(ft);
			l3.setFont(ft);
			//�趨���ڱ���ɫΪ��ɫ
			fr.getContentPane().setBackground(Color.green);
			fr.setLocation(300, 500); 						  // �趨���ڵĳ�ʼ��ʾλ��
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	  // �رմ���
			fr.setSize(400, 300);
			fr.setResizable(true);							  // �趨���Ե��������С
			fr.setVisible(true);
		}
	}

