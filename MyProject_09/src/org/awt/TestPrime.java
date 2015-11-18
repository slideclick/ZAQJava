	package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class TestPrime {
		static TextField tf1 = new TextField();
		static TextField tf2 = new TextField();
		static TextField tf3 = new TextField();
		// 设置有垂直和水平滚动条的文本区
		static TextArea ta = new TextArea("", 5, 10, TextArea.SCROLLBARS_BOTH);						static TextField tf4 = new TextField();
		static int num = 0;
		public static void main(String[] args) {
			Frame f = new Frame("求a到b之间的质数");
			f.setBackground(Color.cyan);
			f.setSize(new Dimension(500, 400));
			f.setLayout(null);
			f.setLocation(300, 300);
			Button bt1 = new Button("求a到b之间的质数");
			bt1.setBackground(Color.cyan);
			bt1.addActionListener(new GetAction());
			Button bt2 = new Button("质数个数");
			bt2.setBackground(Color.cyan);
			Label l1 = new Label("输入a的值");
			Label l2 = new Label("输入b的值");
			Label l3 = new Label("每行显示个数");
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
			f.addWindowListener(new WindowHandler11());		// 注册事件监听器
		}
	}
	// ********方法windowClosing就是当窗口关闭时的处理动作**********
	class WindowHandler11 extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(1); // 关闭窗口
		}
	}
	class GetAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String text1 = TestPrime.tf1.getText();				// 获取文本框中的内容
			String text2 = TestPrime.tf2.getText();
			String text3 = TestPrime.tf3.getText();
			int a, b, c;
			a = Integer.parseInt(text1); 						// 将字符串类型转换为整型
			b = Integer.parseInt(text2);
			c = Integer.parseInt(text3);
			boolean flag;
			int m, p, count = 0;
			for (m = a; m <= b; m++) {
				flag = true;
				for (p = 2; p <= m / 2; p++)					// 判断是否是质数
					if (m % p == 0) {
						flag = false;
						break;
					}
				if (flag) { 
					String str = String.valueOf(m);			// 将整型转换为字符串类型
					TestPrime.ta.append(str + "    ");			// 将质数写入到文本区中
					count++;
					TestPrime.num++;
					if (count % c == 0) { 					// 每行中只输出c个质数
						TestPrime.ta.append("\n");
					}
				}
			}
			String str = String.valueOf(TestPrime.num);
			TestPrime.tf4.setText(str);
		}
	}

