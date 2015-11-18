package org.awt;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	public class ContainerListenerDemo extends Frame implements ActionListener {
		// 设置有垂直和水平滚动条的文本区
		static TextArea ta = new TextArea("", 5, 10, TextArea.SCROLLBARS_BOTH);							public ContainerListenerDemo() {
			Button bt = new Button("求四位数");
			bt.setBackground(Color.cyan);
			bt.addActionListener(this);			// 把ContainerListener本身注册为Button的监听器
			bt.setBounds(100, 40, 80, 30);
			setLayout(null);									// 取消布局管理器
			setBackground(Color.cyan);
			setBounds(20, 20, 300, 300);
			ta.setBounds(45, 75, 220, 200);
			add(bt);
			add(ta);
			setVisible(true);									// 设置窗口可见
		}
		public void actionPerformed(ActionEvent e) {
			int a = 0;										// 千位上的数字
			int b = 0;										// 百位上的数字
			int c = 0;										// 十位上的数字
			int num = 0;									// 这种四位数的个数
			int i = 110;
			for (i = 1000; i < 10000; i++) {
				a = i / 1000;
				b = (i % 1000 - i % 100) / 100;
				c = (i % 100 - i % 10) / 10;
				if ((i % 11 == 0) && (a == b + c)) {
					String str = String.valueOf(i); 				// 将整型转换为字符串类型
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

