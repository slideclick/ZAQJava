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
			f.setLayout(new BorderLayout());					// 使用边界布局管理器
			f.add(tf,BorderLayout.SOUTH);
			f.add(ta,BorderLayout.NORTH);
			f.setVisible(true);
			f.pack();
			tf.addActionListener(new TFListener1());
			f.addWindowListener(new WindowAdapter() {		// 关闭窗口
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}
	}
	class TFListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = TestWindow.tf.getText().trim();		// 获取文本框中的内容
			int m = 0; int n = 0; int s = 0;	int i = 0;
			n = Integer.parseInt(str);					// 将字符串类型转换为整型
			for (m = 2; m < n; m++) {
				s = 0;
				for (i = 1; i < m; i++)
					if ((m % i) == 0)
						s = s + i;					// 计算因子之和
				if (s == m) {						// 判断该数的因子之和是否等于该数自身
					TestWindow.ta.append(m+"\t"+"它的完数是：");
					for (i = 1; i < m; i++) {
						if (m % i == 0) {
							TestWindow.ta.append(i + "   ");		// 将信息添加到窗体上
						}
					}
					TestWindow.ta.append("\n");					// 添加回车符
				}
			}
		}
	}

