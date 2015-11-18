package org.swing;
	import java.awt.*;
	import javax.swing.*;
	public class MyJPanel {
		public static void main(String args[]) {
			JFrame fr = new JFrame();
			fr.setTitle("JPanel的用法");
			BorderLayout bl = new BorderLayout();
			fr.getContentPane().setLayout(bl);					// 设定边界布局管理器
			JPanel jp = new JPanel(new GridLayout(2, 2));		// 设定网格布局管理器
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
			//设定窗口背景色为绿色
			fr.getContentPane().setBackground(Color.green);
			fr.setLocation(300, 500); 						  // 设定窗口的初始显示位置
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	  // 关闭窗口
			fr.setSize(400, 300);
			fr.setResizable(true);							  // 设定可以调整窗体大小
			fr.setVisible(true);
		}
	}

