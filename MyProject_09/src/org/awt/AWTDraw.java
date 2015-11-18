package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class AWTDraw extends Frame {
		private Color color = Color.BLUE;
		private int times; 								// 跟踪调用update()方法的次数
		public AWTDraw(String title) {
			super(title);
			Button button = new Button("change color");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					//更换画笔的颜色
					color = (color == Color.BLUE) ? Color.ORANGE : Color.BLUE; 	
					repaint(); 							// 刷新组件
				}
			});
			add(button, BorderLayout.SOUTH);
			setSize(200, 200);
			setVisible(true);
		}
		public void update(Graphics g) {
			super.update(g);
			//跟踪update()方法被调用的次数
			System.out.println("call update " + (++times) + " times");
		}
		public void paint(Graphics g) {
			g.setColor(color); 							// 设置画笔的颜色
			g.fillRect(0, 0, 200, 200); 						// 画一个矩形
		}
		public static void main(String args[]) {
			AWTDraw draw = new AWTDraw("AWT 绘图");
		}
	}

