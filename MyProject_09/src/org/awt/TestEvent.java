package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class TestEvent {
		static JButton bt = new JButton("隐藏按钮");
		public static void main(String[] args) {
			Frame f = new Frame();
			f.setLocation(300, 200);
			f.setSize(200,200);
			f.setLayout(null);						// 取消布局管理器
			bt.addMouseListener(new MouseMove());		// 注册鼠标事件监听器
			bt.setBackground(Color.cyan);
			bt.setBounds(new Rectangle(45, 100, 90, 30));
			f.add(bt);
			f.pack();
			f.addWindowListener(new WindowAdapter() {	// 关闭窗口
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			f.setVisible(true);						// 设置窗体可见
		}
	}
	class MouseMove extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {			// 鼠标单击Button按钮，按钮不可见
			TestEvent.bt.setVisible(false);
		}
		public void mouseExited(MouseEvent e) {			// 鼠标移开Button按钮，按钮出现
			TestEvent.bt.setVisible(true);
		}
	}
