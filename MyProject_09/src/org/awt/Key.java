package org.awt;
import java.awt.event.*;
	import java.awt.*;
	public class Key implements KeyListener {
		TextField tf = new TextField(20);
		TextArea ta1 = new TextArea("显示按下的键:\n", 7, 20);
		TextArea ta2 = new TextArea("显示释放的键:\n", 7, 20);
		TextArea ta3 = new TextArea("显示控制与功能键:\n", 7, 20);
		TextArea ta4 = new TextArea(null, 2, 20);
		public void keyTyped(KeyEvent e) {				// 键的按下与释放事件
			ta4.append(String.valueOf(e.getKeyChar()));		// 将获取的字符类型编码写入到文本区中
		}
		public void keyPressed(KeyEvent e) {				// 键的按下事件
			ta1.append(String.valueOf(e.getKeyChar()));		
			ta3.append(e.getKeyText(e.getKeyCode()) + "\n");	// 键的整数类型编码
		}
		public void keyReleased(KeyEvent e) {				// 键的释放事件
			ta2.append(String.valueOf(e.getKeyChar()));
		}
		Key() {
			Frame f = new Frame();
			f.setBackground(Color.cyan);
			f.addWindowListener(new WindowAdapter() {	// 关闭窗体
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			f.setLayout(new FlowLayout());				// 使用流式布局管理器
			Panel p1 = new Panel();
			f.add(p1);
			p1.add(new Label("请在此编辑框内输入字符: "));
			p1.add(tf);
			tf.addKeyListener(this);					// 注册事件监听器
			Panel p2 = new Panel();
			f.add(p2);
			p2.add(ta1); p2.add(ta2); p2.add(ta3);
			Panel p3 = new Panel();
			f.add(p3);
			p3.add(new Label("显示按下并释放的键盘: "));
			p3.add(ta4);
			f.setSize(500, 280);
			f.setVisible(true);
		}
		public static void main(String[] args) {
			new Key();
		}
	}

