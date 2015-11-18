package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class AWTDraw extends Frame {
		private Color color = Color.BLUE;
		private int times; 								// ���ٵ���update()�����Ĵ���
		public AWTDraw(String title) {
			super(title);
			Button button = new Button("change color");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					//�������ʵ���ɫ
					color = (color == Color.BLUE) ? Color.ORANGE : Color.BLUE; 	
					repaint(); 							// ˢ�����
				}
			});
			add(button, BorderLayout.SOUTH);
			setSize(200, 200);
			setVisible(true);
		}
		public void update(Graphics g) {
			super.update(g);
			//����update()���������õĴ���
			System.out.println("call update " + (++times) + " times");
		}
		public void paint(Graphics g) {
			g.setColor(color); 							// ���û��ʵ���ɫ
			g.fillRect(0, 0, 200, 200); 						// ��һ������
		}
		public static void main(String args[]) {
			AWTDraw draw = new AWTDraw("AWT ��ͼ");
		}
	}

