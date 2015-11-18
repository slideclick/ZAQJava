package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	//import javax.swing.JFrame;
	public class DrawLine extends Frame {
		Image img = null;
		Graphics og = null;
		public static void main(String[] args) {
			DrawLine d =new DrawLine();
			d.init();
			d.addWindowListener(new WindowHandler());
		}
		public void init() {
			setSize(400, 400);
			setVisible(true);	
			Dimension d = getSize();
			img = createImage(d.width, d.height);
			og = img.getGraphics();
			addMouseListener(new MouseAdapter() {
				int x;										// 横坐标
				int y;									     // 纵坐标
				public void mousePressed(MouseEvent e) {
					x = e.getX();
					y = e.getY();
				}
				public void mouseReleased(MouseEvent e) {
					Graphics g = getGraphics();
					g.setColor(Color.blue); 					// 设置绘图颜色为蓝色
					g.setFont(new Font("隶书", Font.ITALIC | Font.BOLD, 30));	
					g.drawString(new String(x + "," + y), x, y);		// 显示鼠标按下时的坐标
					//显示鼠标释放时的坐标
					g.drawString(new String(e.getX() + "," + e.getY()), e.getX(), e.getY());		
					g.drawLine(x, y, e.getX(), e.getY());
					og.setColor(Color.blue);									
					og.setFont(new Font("隶书", Font.ITALIC | Font.BOLD, 30));	
					og.drawString(new String(x + "," + y), x, y);							
					og.drawString(new String(e.getX() + "," + e.getY()), e.getX(),e.getY());	
					og.drawLine(x, y, e.getX(), e.getY());
				}
			});
		}
		public void paint(Graphics g) {
			if (img != null)
				g.drawImage(img, 0, 0, this);
		}
	}
	class WindowHandler extends WindowAdapter {
		// 方法windowClosing就是当窗口关闭时的处理动作
		public void windowClosing(WindowEvent e) {
			System.exit(1);
		} 
	}

